package mihon.core.archive.book

import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

/** A TOC link as written in its nav or ncx document. [href] is relative to that document. */
internal class TocLink(val title: String, val depth: Int, val href: String)

/** Where a TOC link points. [block] is already clamped to the section's blocks. */
internal class TocTarget(val section: Int, val block: Int)

internal fun parseNavToc(nav: Document): List<TocLink> {
    val root = nav.getElementsByTag("nav").firstOrNull { it.attr("epub:type") == "toc" }
        ?: nav.getElementsByTag("nav").firstOrNull()
        ?: return emptyList()
    val result = mutableListOf<TocLink>()
    root.children().firstOrNull { it.tagName() == "ol" }?.let { collectNav(it, 0, result) }
    return result
}

internal fun parseNcxToc(ncx: Document): List<TocLink> {
    val result = mutableListOf<TocLink>()
    ncx.getElementsByTag("navMap").firstOrNull()?.let { collectNavPoints(it, 0, result) }
    return result
}

/** Links without a title or without a target in the book are dropped. */
internal fun resolveToc(links: List<TocLink>, resolve: (href: String) -> TocTarget?): List<TocEntry> {
    return links.mapNotNull { link ->
        val title = link.title.trim()
        if (title.isEmpty()) return@mapNotNull null
        val target = resolve(link.href) ?: return@mapNotNull null
        TocEntry(title, link.depth, target.section, target.block)
    }
}

private fun collectNav(list: Element, depth: Int, out: MutableList<TocLink>) {
    for (item in list.children()) {
        if (item.tagName() != "li") continue
        item.children().firstOrNull { it.tagName() == "a" }?.let { link ->
            out += TocLink(link.text(), depth, link.attr("href"))
        }
        item.children().filter { it.tagName() == "ol" }.forEach { collectNav(it, depth + 1, out) }
    }
}

private fun collectNavPoints(parent: Element, depth: Int, out: MutableList<TocLink>) {
    for (point in parent.children()) {
        if (point.tagName() != "navPoint") continue
        val label = point.children().firstOrNull { it.tagName() == "navLabel" }
            ?.children()?.firstOrNull { it.tagName() == "text" }?.text()
        val src = point.children().firstOrNull { it.tagName() == "content" }?.attr("src")
        if (label != null && src != null) out += TocLink(label, depth, src)
        collectNavPoints(point, depth + 1, out)
    }
}
