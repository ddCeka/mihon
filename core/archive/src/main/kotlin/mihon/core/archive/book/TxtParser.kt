package mihon.core.archive.book

import java.io.InputStream
import java.nio.ByteBuffer
import java.nio.charset.Charset
import java.nio.charset.CodingErrorAction

private const val SECTION_PARAGRAPHS = 200
private val BLANK_LINE = Regex("\n\\s*\n")
private val SPACE_RUN = Regex("[ \t]+")

fun parseTxt(stream: InputStream): Book {
    val bytes = stream.use { it.readBytes() }
    val text = decode(bytes).replace("\r\n", "\n").replace('\r', '\n')
    val paragraphs = splitParagraphs(text).map { BookBlock.Paragraph(BookText(it)) }
    return Book(
        title = null,
        sections = paragraphs.chunked(SECTION_PARAGRAPHS).map { BookSection(it) },
        toc = emptyList(),
    )
}

/**
 * Paragraphs are separated by blank lines when the text has any, and are single lines otherwise.
 */
private fun splitParagraphs(text: String): List<String> {
    val trimmed = text.trim()
    val chunks = if (trimmed.lines().any { it.isBlank() }) trimmed.split(BLANK_LINE) else trimmed.lines()
    return chunks
        .map { SPACE_RUN.replace(it.replace('\n', ' '), " ").trim() }
        .filter { it.isNotEmpty() }
}

private fun decode(bytes: ByteArray): String = when {
    bytes.hasPrefix(0xEF, 0xBB, 0xBF) -> String(bytes, 3, bytes.size - 3, Charsets.UTF_8)
    bytes.hasPrefix(0xFF, 0xFE) -> String(bytes, 2, bytes.size - 2, Charsets.UTF_16LE)
    bytes.hasPrefix(0xFE, 0xFF) -> String(bytes, 2, bytes.size - 2, Charsets.UTF_16BE)
    else -> decodeUtf8OrWindows1252(bytes)
}

private fun ByteArray.hasPrefix(vararg prefix: Int): Boolean {
    return size >= prefix.size && prefix.indices.all { this[it] == prefix[it].toByte() }
}

private fun decodeUtf8OrWindows1252(bytes: ByteArray): String {
    return runCatching {
        Charsets.UTF_8.newDecoder()
            .onMalformedInput(CodingErrorAction.REPORT)
            .onUnmappableCharacter(CodingErrorAction.REPORT)
            .decode(ByteBuffer.wrap(bytes))
            .toString()
    }.getOrElse { String(bytes, Charset.forName("windows-1252")) }
}
