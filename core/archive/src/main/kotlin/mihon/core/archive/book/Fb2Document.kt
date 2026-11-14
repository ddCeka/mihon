package mihon.core.archive.book

import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import org.jsoup.nodes.Node
import org.jsoup.nodes.TextNode
import org.jsoup.parser.Parser
import java.io.InputStream
import java.util.Base64

class Fb2Document(val book: Book, val images: Map<String, ByteArray>)

fun parseFb2(stream: InputStream): Fb2Document {
    val document = stream.use { Jsoup.parse(it, null, "", Parser.xmlParser()) }
    val title = document.select("FictionBook > description > title-info > book-title").firstOrNull()
        ?.text()
        ?.takeIf { it.isNotBlank() }

    val sections = mutableListOf<BookSection>()
    val toc = mutableListOf<TocEntry>()
    for (body in document.select("FictionBook > body")) {
        val units = body.children().filter { it.tagName() == "section" }.ifEmpty { listOf(body) }
        for (unit in units) {
            val blocks = mutableListOf<BookBlock>()
            val index = sections.size
            sections += BookSection(blocks)
            Fb2SectionWalker(blocks, index, toc).walk(unit, depth = 0)
        }
    }

    val images = document.select("FictionBook > binary").associate { element ->
        element.attr("id") to Base64.getMimeDecoder().decode(element.text())
    }
    return Fb2Document(Book(title, sections, toc), images)
}

/** Walks one top-level section and everything nested in it, which all become a single [BookSection]. */
private class Fb2SectionWalker(
    private val blocks: MutableList<BookBlock>,
    private val section: Int,
    private val toc: MutableList<TocEntry>,
) {

    /** [depth] is the section nesting depth of [element], 0 for a top-level section. */
    fun walk(element: Element, depth: Int) {
        for (child in element.children()) {
            when (child.tagName()) {
                "title" -> addHeading(child, level = minOf(depth + 1, 6), tocDepth = depth)
                "subtitle" -> addHeading(child, level = 4, tocDepth = null)
                "p" -> addParagraph(child, quote = false)
                "epigraph", "cite" -> {
                    child.children()
                        .filter { it.tagName() == "p" || it.tagName() == "text-author" }
                        .forEach { addParagraph(it, quote = true) }
                }
                "poem" -> child.select("stanza > v").forEach { addParagraph(it, quote = false) }
                "image" -> addImage(child)
                "section" -> walk(child, depth + 1)
            }
        }
    }

    private fun addHeading(element: Element, level: Int, tocDepth: Int?) {
        val text = paragraphText(element) ?: return
        if (tocDepth != null) toc += TocEntry(text.text, tocDepth, section, blocks.size)
        blocks += BookBlock.Heading(level, text)
    }

    private fun addParagraph(element: Element, quote: Boolean) {
        val text = paragraphText(element) ?: return
        blocks += BookBlock.Paragraph(text, quote = quote)
    }

    private fun addImage(element: Element) {
        val ref = element.attr("l:href")
            .ifEmpty { element.attr("xlink:href") }
            .ifEmpty { element.attr("href") }
            .removePrefix("#")
        if (ref.isNotEmpty()) blocks += BookBlock.Image(ref)
    }
}

/** Text of an element whose content is either inline or a list of `p` children, joined with a space. */
private fun paragraphText(element: Element): BookText? {
    val builder = BookTextBuilder()
    val parts = element.children().filter { it.tagName() == "p" }.ifEmpty { listOf(element) }
    parts.forEachIndexed { index, part ->
        if (index > 0) builder.append(" ")
        part.childNodes().forEach { appendInline(it, builder) }
    }
    return builder.flush()
}

private fun appendInline(node: Node, builder: BookTextBuilder) {
    when (node) {
        is TextNode -> builder.append(node.wholeText)
        is Element -> {
            val style = INLINE_STYLES[node.tagName()]
            if (style != null) builder.pushStyle(style)
            node.childNodes().forEach { appendInline(it, builder) }
            if (style != null) builder.popStyle()
        }
    }
}

private val INLINE_STYLES = mapOf(
    "strong" to BookText.Style.Bold,
    "emphasis" to BookText.Style.Italic,
    "strikethrough" to BookText.Style.Strikethrough,
    "code" to BookText.Style.Monospace,
    "sup" to BookText.Style.Superscript,
    "sub" to BookText.Style.Subscript,
)
