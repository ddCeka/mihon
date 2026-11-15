package eu.kanade.tachiyomi.ui.reader.model

import eu.kanade.tachiyomi.source.model.Page
import mihon.core.archive.book.BookBlock

/** A reflowable text page, holding blocks rather than an image. */
class TextReaderPage(index: Int, val blocks: List<BookBlock>) : ReaderPage(index) {

    init {
        status = Page.State.Ready
    }
}
