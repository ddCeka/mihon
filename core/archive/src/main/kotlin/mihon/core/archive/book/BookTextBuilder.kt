package mihon.core.archive.book

/**
 * Builds the text of one paragraph at a time. Styles still open when a paragraph is flushed carry over into the next
 * one, so a style that spans a block boundary keeps applying.
 */
internal class BookTextBuilder {

    private val text = StringBuilder()
    private val spans = mutableListOf<BookText.Span>()
    private val openStyles = mutableListOf<OpenStyle>()

    fun pushStyle(style: BookText.Style) {
        openStyles += OpenStyle(style, text.length)
    }

    fun popStyle() {
        val open = openStyles.removeAt(openStyles.lastIndex)
        addSpan(open.style, open.start, text.length)
    }

    /** Outside [preformatted], a run of whitespace becomes one space, and never a leading one. */
    fun append(raw: String, preformatted: Boolean = false) {
        if (preformatted) {
            text.append(raw)
            return
        }
        for (c in raw) {
            if (!isCollapsible(c)) {
                text.append(c)
            } else if (text.isNotEmpty() && !isCollapsible(text.last())) {
                text.append(' ')
            }
        }
    }

    fun lineBreak() {
        if (text.isNotEmpty()) text.append('\n')
    }

    /** Ends the paragraph and returns it, or null when it has no visible text. */
    fun flush(preformatted: Boolean = false): BookText? {
        for (open in openStyles) {
            addSpan(open.style, open.start, text.length)
            open.start = 0
        }

        var end = text.length
        if (!preformatted) {
            while (end > 0 && isCollapsible(text[end - 1])) end--
        }
        val content = text.substring(0, end)
        val kept = spans
            .filter { it.start < end }
            .map { it.copy(end = minOf(it.end, end)) }
            .sortedWith(compareBy<BookText.Span> { it.start }.thenByDescending { it.end })

        text.clear()
        spans.clear()
        if (content.isBlank()) return null
        return BookText(content, kept)
    }

    private fun addSpan(style: BookText.Style, start: Int, end: Int) {
        if (end > start) spans += BookText.Span(start, end, style)
    }

    private class OpenStyle(val style: BookText.Style, var start: Int)
}

private fun isCollapsible(c: Char): Boolean = c == ' ' || c == '\n' || c == '\t' || c == '\r' || c == '\u000C'
