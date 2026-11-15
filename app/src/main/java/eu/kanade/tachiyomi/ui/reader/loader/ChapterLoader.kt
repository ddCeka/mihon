package eu.kanade.tachiyomi.ui.reader.loader

import android.content.Context
import eu.kanade.domain.chapter.model.toSChapter
import eu.kanade.tachiyomi.data.download.DownloadManager
import eu.kanade.tachiyomi.data.download.DownloadProvider
import eu.kanade.tachiyomi.source.Source
import eu.kanade.tachiyomi.source.online.HttpSource
import eu.kanade.tachiyomi.ui.reader.model.ReaderChapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import mihon.core.archive.archiveReader
import mihon.core.archive.book.UnsupportedMobiException
import mihon.core.archive.book.parseFb2
import mihon.core.archive.book.parseMobi
import mihon.core.archive.book.parseTxt
import mihon.core.archive.epubReader
import mihon.core.archive.pdfReader
import mihon.data.cache.ChapterCache
import tachiyomi.core.common.i18n.stringResource
import tachiyomi.core.common.storage.extension
import tachiyomi.core.common.util.system.logcat
import tachiyomi.domain.manga.model.Manga
import tachiyomi.domain.source.model.StubSource
import tachiyomi.i18n.MR
import tachiyomi.source.local.LocalSource
import tachiyomi.source.local.io.Format

/**
 * Loader used to retrieve the [PageLoader] for a given chapter.
 */
class ChapterLoader(
    private val context: Context,
    private val downloadManager: DownloadManager,
    private val downloadProvider: DownloadProvider,
    private val chapterCache: ChapterCache,
    private val appScope: CoroutineScope,
    private val canLoadAhead: () -> Boolean,
    private val manga: Manga,
    private val source: Source,
    private val forceResume: Boolean = false,
) {

    /**
     * Assigns the chapter's page loader and loads the its pages. Returns immediately if the chapter
     * is already loaded.
     */
    suspend fun loadChapter(chapter: ReaderChapter) {
        if (chapterIsReady(chapter)) {
            return
        }

        chapter.state = ReaderChapter.State.Loading
        withContext(Dispatchers.IO) {
            logcat { "Loading pages for ${chapter.chapter.name}" }
            try {
                val loader = getPageLoader(chapter)
                chapter.pageLoader = loader

                val pages = loader.getPages()
                    .onEach { it.chapter = chapter }

                if (pages.isEmpty()) {
                    throw Exception(context.stringResource(MR.strings.page_list_empty_error))
                }

                // If the chapter is partially read, set the starting page to the last the user read
                // otherwise use the requested page.
                if (!chapter.chapter.read || forceResume) {
                    chapter.requestedPage = chapter.chapter.lastPageRead
                    chapter.requestedPageOffset = chapter.chapter.lastPageReadOffset
                }

                chapter.state = ReaderChapter.State.Loaded(pages)
            } catch (e: Throwable) {
                chapter.state = ReaderChapter.State.Error(e)
                throw e
            }
        }
    }

    /**
     * Checks [chapter] to be loaded based on present pages and loader in addition to state.
     */
    private fun chapterIsReady(chapter: ReaderChapter): Boolean {
        return chapter.state is ReaderChapter.State.Loaded && chapter.pageLoader != null
    }

    /**
     * Returns the page loader to use for this [chapter].
     */
    private suspend fun getPageLoader(chapter: ReaderChapter): PageLoader {
        val dbChapter = chapter.chapter
        val isDownloaded = downloadManager.isChapterDownloadedOnDisk(
            dbChapter.name,
            dbChapter.scanlator,
            dbChapter.url,
            manga.title,
            source,
        )
        return when {
            isDownloaded -> DownloadPageLoader(
                context,
                chapter,
                manga,
                source,
                downloadManager,
                downloadProvider,
            )
            source is LocalSource -> source.getFormat(chapter.chapter.toSChapter()).let { format ->
                when (format) {
                    is Format.Directory -> DirectoryPageLoader(format.file)
                    is Format.Archive -> ArchivePageLoader(format.file.archiveReader(context))
                    is Format.Epub -> {
                        val reader = format.file.epubReader(context)
                        if (reader.isTextBook()) {
                            TextPageLoader(reader.readBook(), reader::getInputStream, reader::close)
                        } else {
                            EpubPageLoader(reader)
                        }
                    }
                    is Format.Pdf -> PdfPageLoader(format.file.pdfReader(context))
                    is Format.Text -> when (format.file.extension?.lowercase()) {
                        "fb2" -> {
                            val document = parseFb2(format.file.openInputStream())
                            TextPageLoader(document.book, { ref -> document.images[ref]?.inputStream() })
                        }
                        "mobi", "azw", "azw3" -> {
                            val document = try {
                                parseMobi(format.file.openInputStream())
                            } catch (e: UnsupportedMobiException) {
                                val message = when (e.reason) {
                                    UnsupportedMobiException.Reason.Drm -> MR.strings.reader_book_drm_error
                                    UnsupportedMobiException.Reason.Compression ->
                                        MR.strings.reader_book_compression_error
                                }
                                throw Exception(context.stringResource(message), e)
                            }
                            TextPageLoader(document.book, document::openImage)
                        }
                        else -> TextPageLoader(parseTxt(format.file.openInputStream()), { null })
                    }
                }
            }
            source is HttpSource -> HttpPageLoader(chapter, source, chapterCache, appScope, canLoadAhead)
            source is StubSource -> error(context.stringResource(MR.strings.source_not_installed, source.toString()))
            else -> error(context.stringResource(MR.strings.loader_not_implemented_error))
        }
    }
}
