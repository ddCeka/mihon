package mihon.core.archive.book

import org.jsoup.nodes.Element
import org.jsoup.nodes.TextNode

internal class ParsedHtml(val blocks: List<BookBlock>, val anchors: Map<String, Int>)

/**
 * [resolveImage] maps an img/src (or svg image xlink:href) attribute value to an image ref, or null to drop the image.
 */
internal fun parseHtmlBlocks(body: Element, resolveImage: (String) -> String?): ParsedHtml {
    val walker = HtmlBlockWalker(resolveImage)
    walker.visit(body)
    walker.flush()
    return ParsedHtml(walker.blocks, walker.anchors)
}

private class HtmlBlockWalker(private val resolveImage: (String) -> String?) {

    val blocks = mutableListOf<BookBlock>()
    val anchors = mutableMapOf<String, Int>()

    private val text = BookTextBuilder()
    private var heading: Int? = null
    private var quoteDepth = 0
    private var preDepth = 0
    private var pendingBullet = false

    fun visit(element: Element) {
        val tag = element.tagName()
        if (tag in SKIPPED_TAGS) return
        if (tag in BREAKING_TAGS) flush()
        recordAnchors(element)
        when (tag) {
            "br" -> text.lineBreak()
            "hr" -> {
                blocks += BookBlock.Rule
            }
            "img" -> addImage(element.attr("src"))
            "image" -> addImage(element.attr("xlink:href").ifEmpty { element.attr("href") })
            else -> visitOther(element, tag)
        }
    }

    fun flush() {
        val preformatted = preDepth > 0
        val content = text.flush(preformatted) ?: return
        val level = heading
        blocks += if (level != null) {
            BookBlock.Heading(level, content)
        } else {
            BookBlock.Paragraph(content, quote = quoteDepth > 0, preformatted = preformatted)
        }
    }

    private fun visitOther(element: Element, tag: String) {
        val style = INLINE_STYLES[tag]
        when {
            style != null -> {
                text.pushStyle(style)
                visitChildren(element)
                text.popStyle()
            }
            tag in BLOCK_TAGS -> visitBlock(element, tag)
            else -> visitChildren(element)
        }
    }

    /** Block boundaries were already flushed by [visit], so this only flushes the content inside. */
    private fun visitBlock(element: Element, tag: String) {
        val outerHeading = heading
        HEADING_LEVELS[tag]?.let { heading = it }
        if (tag == "blockquote") quoteDepth++
        if (tag == "pre") preDepth++
        if (tag == "li") pendingBullet = true

        visitChildren(element)
        flush()

        if (tag == "blockquote") quoteDepth--
        if (tag == "pre") preDepth--
        pendingBullet = false
        heading = outerHeading
    }

    private fun visitChildren(element: Element) {
        for (child in element.childNodes()) {
            when (child) {
                is TextNode -> appendText(child.wholeText)
                is Element -> visit(child)
            }
        }
    }

    private fun appendText(raw: String) {
        // A list item's bullet goes before its first visible text, so an item wrapping only a block child gets none.
        if (pendingBullet && raw.isNotBlank()) {
            text.append("• ")
            pendingBullet = false
        }
        text.append(raw, preformatted = preDepth > 0)
    }

    private fun recordAnchors(element: Element) {
        val id = element.id()
        if (id.isNotEmpty()) anchors.putIfAbsent(id, blocks.size)
        if (element.tagName() == "a") {
            val name = element.attr("name")
            if (name.isNotEmpty()) anchors.putIfAbsent(name, blocks.size)
        }
    }

    private fun addImage(src: String) {
        if (src.isEmpty()) return
        val ref = resolveImage(src)
        if (ref != null) blocks += BookBlock.Image(ref)
    }

    companion object {
        private val SKIPPED_TAGS = setOf("script", "style", "head", "title", "template", "noscript")

        private val BLOCK_TAGS = setOf(
            "p", "div", "section", "article", "aside", "header", "footer", "main", "nav", "figure", "figcaption",
            "blockquote", "li", "ul", "ol", "dl", "dt", "dd", "tr", "table", "tbody", "thead", "td", "th", "pre",
            "h1", "h2", "h3", "h4", "h5", "h6",
        )

        private val BREAKING_TAGS = BLOCK_TAGS + setOf("hr", "img", "image")

        private val HEADING_LEVELS = (1..6).associateBy { "h$it" }

        private val INLINE_STYLES = mapOf(
            "b" to BookText.Style.Bold,
            "strong" to BookText.Style.Bold,
            "i" to BookText.Style.Italic,
            "em" to BookText.Style.Italic,
            "cite" to BookText.Style.Italic,
            "dfn" to BookText.Style.Italic,
            "u" to BookText.Style.Underline,
            "ins" to BookText.Style.Underline,
            "s" to BookText.Style.Strikethrough,
            "strike" to BookText.Style.Strikethrough,
            "del" to BookText.Style.Strikethrough,
            "code" to BookText.Style.Monospace,
            "kbd" to BookText.Style.Monospace,
            "samp" to BookText.Style.Monospace,
            "tt" to BookText.Style.Monospace,
            "sup" to BookText.Style.Superscript,
            "sub" to BookText.Style.Subscript,
        )
    }
}
