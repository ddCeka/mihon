package mihon.core.archive.book

import org.jsoup.Jsoup
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.nio.charset.Charset

class MobiDocument internal constructor(
    val book: Book,
    val cover: ByteArray?,
    private val images: (String) -> ByteArray?,
) {
    fun openImage(ref: String): InputStream? = images(ref)?.inputStream()
}

/** The book can't be read: it is DRM-protected or uses a compression this reader doesn't support. */
class UnsupportedMobiException(val reason: Reason) : Exception() {
    enum class Reason { Drm, Compression }
}

private const val NO_INDEX = 0xFFFFFFFFL
private const val EXTH_FLAG = 0x40L
private const val KF8_VERSION = 8L
private const val EXTH_TITLE = 503
private const val EXTH_COVER_OFFSET = 201
private const val UTF8_CODE_PAGE = 65001L
private const val KINDLE_EMBED = "kindle:embed:"
private val PAGE_BREAK = Regex("<mbp:pagebreak[^>]*>", RegexOption.IGNORE_CASE)
private val WHITESPACE_RUN = Regex("\\s+")
private val WINDOWS_1252: Charset = Charset.forName("windows-1252")

fun parseMobi(stream: InputStream): MobiDocument {
    val records = readPalmRecords(stream.use { it.readBytes() })
    val record0 = records[0]

    if (record0.u16(12) != 0) throw UnsupportedMobiException(UnsupportedMobiException.Reason.Drm)
    val compression = record0.u16(0)
    if (compression != 1 && compression != 2) {
        throw UnsupportedMobiException(UnsupportedMobiException.Reason.Compression)
    }

    val mobi = if (record0.size >= 20 && String(record0, 16, 4, Charsets.US_ASCII) == "MOBI") {
        readMobiHeader(record0)
    } else {
        null
    }
    val charset = mobi?.charset ?: WINDOWS_1252
    val extraFlags = mobi?.extraFlags ?: 0

    val rawText = ByteArrayOutputStream().apply {
        for (record in records.subList(1, minOf(record0.u16(8) + 1, records.size))) {
            val payload = stripTrailingEntries(record, extraFlags)
            write(if (compression == 2) decompressPalmDoc(payload) else payload)
        }
    }.toByteArray()
    val text = mobi?.fdstIndex?.let { records.getOrNull(it) }?.let { firstFlow(it, rawText) } ?: rawText
    val html = String(text, charset)

    fun imageRecord(src: String): Int? = imageRecordIndex(src, mobi?.firstImage, records.size)
    val images: (String) -> ByteArray? = { ref -> ref.toIntOrNull()?.let { records.getOrNull(it) } }

    val sections = html.split(PAGE_BREAK).filter { it.isNotBlank() }.mapNotNull { piece ->
        val body = Jsoup.parse(piece).body()
        body.select("img[recindex]").forEach { it.attr("src", it.attr("recindex")) }
        val blocks = parseHtmlBlocks(body) { src -> imageRecord(src)?.toString() }.blocks
        blocks.takeIf { it.isNotEmpty() }?.let { BookSection(it) }
    }

    val toc = sections.flatMapIndexed { sectionIndex, section ->
        section.blocks.mapIndexedNotNull { blockIndex, block ->
            (block as? BookBlock.Heading)
                ?.takeIf { it.level <= 2 }
                // A heading can hold line breaks, e.g. around an illustration caption.
                ?.let { TocEntry(it.text.text.replace(WHITESPACE_RUN, " "), it.level - 1, sectionIndex, blockIndex) }
        }
    }

    val title = (mobi?.exth?.get(EXTH_TITLE)?.toString(charset) ?: mobi?.fullTitle)
        ?.trim()
        ?.takeIf { it.isNotEmpty() }

    val coverOffset = mobi?.exth?.get(EXTH_COVER_OFFSET)?.takeIf { it.size >= 4 }?.u32(0)
    val coverIndex = mobi?.firstImage?.let { base -> coverOffset?.let { base + it } }
    val cover = coverIndex?.takeIf { it < records.size }?.let { records[it.toInt()] }
        ?: sections.asSequence()
            .flatMap { it.blocks }
            .firstNotNullOfOrNull { (it as? BookBlock.Image)?.ref }
            ?.let(images)

    return MobiDocument(Book(title, sections, toc), cover, images)
}

private class MobiHeader(
    val charset: Charset,
    val fullTitle: String?,
    val firstImage: Int?,
    val extraFlags: Int,
    val fdstIndex: Int?,
    val exth: Map<Int, ByteArray>,
)

private fun readMobiHeader(record0: ByteArray): MobiHeader {
    val headerLength = record0.u32(20).toInt()
    val charset = if (record0.u32(28) == UTF8_CODE_PAGE) Charsets.UTF_8 else WINDOWS_1252
    val version = record0.u32(36)

    val titleOffset = record0.u32(84).toInt()
    val titleLength = record0.u32(88).toInt()
    val fullTitle = if (titleOffset in record0.indices && titleLength > 0) {
        record0.copyOfRange(titleOffset, minOf(titleOffset + titleLength, record0.size)).toString(charset)
    } else {
        null
    }

    val firstImage = record0.u32(108).takeIf { it != NO_INDEX }?.toInt()
    val exth = if ((record0.u32(128) and EXTH_FLAG) != 0L) readExth(record0, 16 + headerLength) else emptyMap()
    val extraFlags = if (headerLength >= 228) record0.u16(242) else 0
    val fdstIndex = if (version == KF8_VERSION && headerLength >= 180) {
        record0.u32(192).takeIf { it != NO_INDEX }?.toInt()
    } else {
        null
    }
    return MobiHeader(charset, fullTitle, firstImage, extraFlags, fdstIndex, exth)
}

private fun readExth(record0: ByteArray, offset: Int): Map<Int, ByteArray> {
    if (offset + 12 > record0.size || String(record0, offset, 4, Charsets.US_ASCII) != "EXTH") return emptyMap()
    val count = record0.u32(offset + 8).toInt()
    val entries = mutableMapOf<Int, ByteArray>()
    var pos = offset + 12
    repeat(count) {
        if (pos + 8 > record0.size) return entries
        val type = record0.u32(pos).toInt()
        val length = record0.u32(pos + 4).toInt()
        if (length < 8 || pos + length > record0.size) return entries
        entries[type] = record0.copyOfRange(pos + 8, pos + length)
        pos += length
    }
    return entries
}

/** The first KF8 flow is the markup; the others are stylesheets. */
private fun firstFlow(fdst: ByteArray, text: ByteArray): ByteArray {
    if (fdst.size < 20) return text
    val start = fdst.u32(12).coerceAtMost(text.size.toLong()).toInt()
    val end = fdst.u32(16).coerceAtMost(text.size.toLong()).toInt()
    return if (start <= end) text.copyOfRange(start, end) else text
}

/**
 * Maps an image source to its record index. Older MOBI sources are decimal 1-based indexes, KF8 sources are
 * `kindle:embed:` references with a 1-based base-32 index.
 */
private fun imageRecordIndex(src: String, firstImage: Int?, recordCount: Int): Int? {
    val base = firstImage ?: return null
    val number = if (src.startsWith("kindle:embed:", ignoreCase = true)) {
        parseBase32(src.substring(KINDLE_EMBED.length).substringBefore('?'))
    } else {
        src.toIntOrNull()
    } ?: return null
    if (number < 1) return null
    return (base + number - 1).takeIf { it < recordCount }
}

private fun parseBase32(value: String): Int? {
    if (value.isEmpty()) return null
    var result = 0L
    for (ch in value) {
        val digit = Character.digit(ch, 32)
        if (digit < 0) return null
        result = result * 32 + digit
        if (result > Int.MAX_VALUE) return null
    }
    return result.toInt()
}
