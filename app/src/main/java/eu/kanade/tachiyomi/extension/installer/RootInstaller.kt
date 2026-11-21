package eu.kanade.tachiyomi.extension.installer

import android.content.Context
import android.os.Process
import eu.kanade.tachiyomi.extension.model.InstallStep
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runInterruptible
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import logcat.LogPriority
import tachiyomi.core.common.util.system.logcat
import java.io.File
import java.util.concurrent.TimeUnit

internal object RootInstaller {

    private const val ROOT_GRANTED = "ROOT_GRANTED"
    private val installLock = Mutex()

    private fun findSu(): File? = System.getenv("PATH")
        ?.splitToSequence(File.pathSeparatorChar)
        ?.filter { it.startsWith("/") }
        ?.map { File(it, "su") }
        ?.firstOrNull { it.isFile && it.canExecute() }

    fun hasSu(): Boolean = findSu() != null

    /** Returns null when root installation is unavailable or fails so caller can fall back. */
    suspend fun install(context: Context, apk: File): InstallStep? = installLock.withLock {
        try {
            runInterruptible(Dispatchers.IO) {
                val su = findSu() ?: return@runInterruptible null
                // Android's public UserHandle.hashCode() returns the ID used by pm --user.
                val userId = Process.myUserHandle().hashCode()
                val size = apk.length()
                // Stream APK via stdin so system_server never needs access to app private files.
                val command = """
                    [ "${'$'}(/system/bin/id -u)" = 0 ] || exit 1
                    echo $ROOT_GRANTED
                    result=${'$'}(
                        /system/bin/pm install -r --user $userId \
                            -i '${context.packageName}' -S $size 2>&1
                    )
                    status=${'$'}?
                    printf '%s\n' "${'$'}result"
                    exit "${'$'}status"
                """.trimIndent()

                val outputFile = File.createTempFile("extension_root_", ".log", context.cacheDir)
                try {
                    val process = ProcessBuilder(su.absolutePath, "-c", command)
                        .redirectInput(apk)
                        .redirectErrorStream(true)
                        .redirectOutput(outputFile)
                        .start()

                    val exitCode = try {
                        if (process.waitFor(120, TimeUnit.SECONDS)) process.exitValue() else null
                    } finally {
                        if (process.isAlive) process.destroyForcibly()
                    }

                    val output = outputFile.readLines()
                    when {
                        ROOT_GRANTED !in output -> {
                            logcat(LogPriority.INFO) { "Root access denied or unavailable" }
                            null
                        }
                        exitCode == 0 && output.any { it.trim() == "Success" } -> {
                            InstallStep.Installed
                        }
                        else -> {
                            logcat(LogPriority.WARN) {
                                "Root installer failed (exit=$exitCode), falling back: ${output.joinToString()}"
                            }
                            null
                        }
                    }
                } finally {
                    outputFile.delete()
                }
            }
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            logcat(LogPriority.WARN, e) { "Root installer threw an exception, falling back" }
            null
        }
    }
}
