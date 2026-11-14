package eu.kanade.tachiyomi.ui.reader.loader

import eu.kanade.tachiyomi.ui.reader.model.ReaderPage
import eu.kanade.tachiyomi.ui.reader.model.TextReaderPage
import mihon.core.archive.book.Book
import mihon.core.archive.book.BookBlock
import java.io.InputStream

private const val PAGE_TEXT_LENGTH = 1200
private const val IMAGE_TEXT_LENGTH = 1200

/**
 * Loader used to load a text book (EPUB, FB2 or TXT) as reflowable pages.
 */
class TextPageLoader(
    private val book: Book,
    private val images: (String) -> InputStream?,
    private val onRecycle: () -> Unit = {},
) : PageLoader() {

    override var isLocal: Boolean = true

    private val layout by lazy { layout() }

    val toc: List<TextTocEntry>
        get() = layout.toc

    override suspend fun getPages(): List<ReaderPage> = layout.pages

    fun openImage(ref: String): InputStream? = images(ref)

    override fun recycle() {
        super.recycle()
        onRecycle()
    }

    private fun layout(): Layout {
        val pages = mutableListOf<TextReaderPage>()
        val current = mutableListOf<BookBlock>()
        var length = 0
        val pageOfBlock = mutableMapOf<Pair<Int, Int>, Int>()

        fun closePage() {
            if (current.isEmpty()) return
            pages += TextReaderPage(pages.size, current.toList())
            current.clear()
            length = 0
        }

        book.sections.forEachIndexed { sectionIndex, section ->
            closePage()
            section.blocks.forEachIndexed { blockIndex, block ->
                pageOfBlock[sectionIndex to blockIndex] = pages.size
                current += block
                length += block.textLength
                if (length >= PAGE_TEXT_LENGTH) closePage()
            }
        }
        closePage()

        val toc = book.toc.mapNotNull { entry ->
            pageOfBlock[entry.section to entry.block]?.let { TextTocEntry(entry.title, entry.depth, it) }
        }
        return Layout(pages, toc)
    }

    private class Layout(val pages: List<TextReaderPage>, val toc: List<TextTocEntry>)
}

class TextTocEntry(val title: String, val depth: Int, val pageIndex: Int)

private val BookBlock.textLength: Int
    get() = when (this) {
        is BookBlock.Heading -> text.text.length
        is BookBlock.Paragraph -> text.text.length
        is BookBlock.Image -> IMAGE_TEXT_LENGTH
        BookBlock.Rule -> 0
    }
