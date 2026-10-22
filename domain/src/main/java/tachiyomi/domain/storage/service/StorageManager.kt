package tachiyomi.domain.storage.service

import android.content.Context
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.DocumentsContract
import androidx.core.net.toUri
import com.hippo.unifile.UniFile
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.Inject
import dev.zacsweers.metro.SingleIn
import eu.kanade.tachiyomi.util.storage.DiskUtil
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.shareIn
import mihon.core.metro.AppCoroutineScope
import java.io.File
import java.util.concurrent.ConcurrentHashMap

@Inject
@SingleIn(AppScope::class)
class StorageManager(
    @AppCoroutineScope private val scope: CoroutineScope,
    private val context: Context,
    storagePreferences: StoragePreferences,
) {

    @Volatile
    private var baseDirLazy: Lazy<UniFile?> = lazy {
        getBaseDir(storagePreferences.baseStorageDirectory.get())
    }

    private val baseDir: UniFile?
        get() = baseDirLazy.value

    // SAF roots can change at runtime; invalidate all child cache entries when that happens.
    private val childDirectories = ConcurrentHashMap<String, UniFile>()

    private val _changes: Channel<Unit> = Channel(Channel.UNLIMITED)
    val changes = _changes.receiveAsFlow()
        .shareIn(scope, SharingStarted.Lazily, 1)

    init {
        updateBaseDir(storagePreferences.baseStorageDirectory.get())

        storagePreferences.baseStorageDirectory.changes()
            .distinctUntilChanged()
            .onEach { uri ->
                updateBaseDir(uri)
            }
            .launchIn(scope)
    }

    private fun updateBaseDir(uri: String) {
        baseDirLazy = lazyOf(getBaseDir(uri))
        childDirectories.clear()

        baseDir?.let { parent ->
            ensureStandardDirectories(parent)
        }

        _changes.trySend(Unit)
    }

    private fun ensureStandardDirectories(parent: UniFile) {
        listOf(AUTOMATIC_BACKUPS_PATH, LOCAL_SOURCE_PATH, DOWNLOADS_PATH).forEach { name ->
            val dir = getOrCreateChildDirectory(parent, name)
            if (name == DOWNLOADS_PATH && dir != null) {
                DiskUtil.createNoMediaFile(dir, context)
            }
        }
    }

    fun getAutomaticBackupsDirectory(): UniFile? {
        val dir = getChildDirectory(AUTOMATIC_BACKUPS_PATH)
        if (dir == null && Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
            val fallback = File(Environment.getExternalStorageDirectory(), AUTOMATIC_BACKUPS_PATH)
            if (fallback.exists() || fallback.mkdirs()) {
                return UniFile.fromFile(fallback)
            }
        }
        return dir
    }

    fun getDownloadsDirectory(): UniFile? {
        val dir = getChildDirectory(DOWNLOADS_PATH)
        if (dir == null && Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
            val fallback = File(Environment.getExternalStorageDirectory(), DOWNLOADS_PATH)
            if (fallback.exists() || fallback.mkdirs()) {
                return UniFile.fromFile(fallback)
            }
        }
        return dir
    }

    fun getLocalSourceDirectory(): UniFile? {
        val dir = getChildDirectory(LOCAL_SOURCE_PATH)
        if (dir == null && Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
            val fallback = File(Environment.getExternalStorageDirectory(), LOCAL_SOURCE_PATH)
            if (fallback.exists() || fallback.mkdirs()) {
                return UniFile.fromFile(fallback)
            }
        }
        return dir
    }

    private fun getChildDirectory(name: String): UniFile? {
        val parent = baseDir ?: return null
        return getOrCreateChildDirectory(parent, name)
    }

    private fun getOrCreateChildDirectory(parent: UniFile, name: String): UniFile? {
        val cached = childDirectories[name]
        if (cached != null && cached.exists()) {
            return cached
        }

        childDirectories.remove(name)

        var dir = parent.createDirectory(name)
        if (dir == null && Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
            dir = createDirectoryFromRawFallback(parent, name)
        }

        return dir?.also { childDirectories[name] = it }
    }

    private fun createDirectoryFromRawFallback(parent: UniFile, name: String): UniFile? {
        val parentPath = parent.filePath
            ?: resolveToFile(context, parent.uri.toString())?.absolutePath
            ?: return null

        val child = File(parentPath, name)
        if (child.exists() || child.mkdirs()) {
            return UniFile.fromFile(child)
        }
        return null
    }

    private fun getBaseDir(uri: String): UniFile? {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
            val rawFile = resolveToFile(context, uri)
            if (rawFile != null) {
                if (!rawFile.exists()) {
                    rawFile.mkdirs()
                }
                if (rawFile.exists() && rawFile.isDirectory) {
                    UniFile.fromFile(rawFile)?.let { return it }
                }
            }
        }

        val file = UniFile.fromUri(context, uri.toUri())
        if (file?.exists() == true) {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
                file.filePath?.let { rawPath ->
                    val rawFile = File(rawPath)
                    if (!rawFile.exists()) {
                        rawFile.mkdirs()
                    }
                    if (rawFile.exists()) {
                        UniFile.fromFile(rawFile)?.let { return it }
                    }
                }
            }
            return file
        }

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
            file?.filePath?.let { rawPath ->
                val rawFile = File(rawPath)
                if (rawFile.mkdirs() || rawFile.exists()) {
                    UniFile.fromFile(rawFile)?.let { return it }
                }
            }

            val externalRoot = Environment.getExternalStorageDirectory()
            val fallback = File(externalRoot, DEFAULT_APP_STORAGE_FOLDER)
            if (fallback.exists() || fallback.mkdirs()) {
                return UniFile.fromFile(fallback)
            }
        }

        return file?.takeIf { it.exists() }
    }

    companion object {
        fun resolveToFile(context: Context, uriString: String): File? {
            if (uriString.isBlank()) return null

            return try {
                if (uriString.startsWith("/")) {
                    return File(uriString)
                }

                val uri = uriString.toUri()
                when (uri.scheme) {
                    "file" -> {
                        val path = uri.path ?: return null
                        File(path)
                    }

                    "content" -> {
                        val docId = when {
                            DocumentsContract.isTreeUri(uri) ->
                                DocumentsContract.getTreeDocumentId(uri)

                            DocumentsContract.isDocumentUri(context, uri) ->
                                DocumentsContract.getDocumentId(uri)

                            else -> {
                                val path = uri.path ?: ""
                                val unquoted = Uri.decode(path)
                                when {
                                    unquoted.contains("/tree/") ->
                                        unquoted.substringAfterLast("/tree/")

                                    unquoted.contains("/document/") ->
                                        unquoted.substringAfterLast("/document/")

                                    else -> null
                                }
                            }
                        } ?: return null

                        val decodedDocId = Uri.decode(docId)
                        val parts = decodedDocId.split(":", limit = 2)
                        val storageId = parts[0]
                        val relPath = if (parts.size > 1) parts[1] else ""

                        if (storageId.equals("primary", ignoreCase = true)) {
                            val ext = Environment.getExternalStorageDirectory()
                            if (relPath.isNotEmpty()) File(ext, relPath) else ext
                        } else {
                            val storageRoot = File("/storage/$storageId")
                            val file = if (relPath.isNotEmpty()) {
                                File(storageRoot, relPath)
                            } else {
                                storageRoot
                            }

                            if (file.exists() || storageRoot.exists()) {
                                file
                            } else {
                                DiskUtil.getExternalStorages(context)
                                    .firstOrNull {
                                        it.name.equals(storageId, ignoreCase = true) ||
                                            it.absolutePath.contains(storageId)
                                    }
                                    ?.let { root ->
                                        if (relPath.isNotEmpty()) File(root, relPath) else root
                                    }
                                    ?: file
                            }
                        }
                    }

                    else -> null
                }
            } catch (_: Exception) {
                null
            }
        }
    }
}

private const val AUTOMATIC_BACKUPS_PATH = "autobackup"
private const val DOWNLOADS_PATH = "downloads"
private const val LOCAL_SOURCE_PATH = "local"

// Generic fallback name used when no configured base storage is available.
private const val DEFAULT_APP_STORAGE_FOLDER = "storage"
