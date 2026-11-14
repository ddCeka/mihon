package mihon.core.archive.book

class Book(
    val title: String?,
    val sections: List<BookSection>,
    val toc: List<TocEntry>,
)

class BookSection(val blocks: List<BookBlock>)

sealed interface BookBlock {
    /** [level] is 1..6. */
    data class Heading(val level: Int, val text: BookText) : BookBlock

    data class Paragraph(
        val text: BookText,
        val quote: Boolean = false,
        val preformatted: Boolean = false,
    ) : BookBlock

    /**
     * [ref] is whatever the format's reader accepts to open the image: a zip entry path for EPUB,
     * a binary id for FB2.
     */
    data class Image(val ref: String) : BookBlock

    data object Rule : BookBlock
}

data class BookText(val text: String, val spans: List<Span> = emptyList()) {
    /** [end] is exclusive. */
    data class Span(val start: Int, val end: Int, val style: Style)

    enum class Style { Bold, Italic, Underline, Strikethrough, Monospace, Superscript, Subscript }
}

/** [block] is the index into the section's blocks where the entry starts. */
data class TocEntry(val title: String, val depth: Int, val section: Int, val block: Int = 0)
