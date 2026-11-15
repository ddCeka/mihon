package eu.kanade.tachiyomi.ui.reader.viewer.text

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import eu.kanade.tachiyomi.ui.reader.loader.TextPageLoader
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import mihon.core.archive.book.BookBlock
import mihon.core.archive.book.BookText

/** Text appearance from the text settings, [fontSize] and [lineSpacing] as the preferences hold them. */
data class TextSettings(
    val fontSize: Int,
    val lineSpacing: Int,
    val family: FontFamily,
    val justify: Boolean,
    val color: Color,
)

@Composable
fun TextBlockItem(block: BookBlock, settings: TextSettings, loader: TextPageLoader?) {
    val spacing = (settings.fontSize * 0.6f).dp
    when (block) {
        is BookBlock.Heading -> {
            val text = remember(block) { block.text.toAnnotatedString() }
            Text(
                text = text,
                style = settings.textStyle(scale = headingScale(block.level), weight = FontWeight.SemiBold),
                modifier = Modifier.padding(top = (settings.fontSize * 1.2f).dp, bottom = spacing),
            )
        }
        is BookBlock.Paragraph -> {
            val text = remember(block) { block.text.toAnnotatedString() }
            val color = if (block.quote) settings.color.copy(alpha = 0.7f) else settings.color
            val modifier = Modifier.padding(start = if (block.quote) 24.dp else 0.dp, bottom = spacing)
            if (block.preformatted) {
                Text(
                    text = text,
                    style = settings.textStyle(family = FontFamily.Monospace, color = color),
                    softWrap = false,
                    modifier = modifier.horizontalScroll(rememberScrollState()),
                )
            } else {
                Text(
                    text = text,
                    style = settings.textStyle(
                        color = color,
                        textAlign = if (settings.justify) TextAlign.Justify else TextAlign.Start,
                    ),
                    modifier = modifier,
                )
            }
        }
        is BookBlock.Image -> if (loader != null) {
            TextImage(
                ref = block.ref,
                loader = loader,
                modifier = Modifier.padding(bottom = spacing),
            )
        }
        BookBlock.Rule -> Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = spacing),
            contentAlignment = Alignment.Center,
        ) {
            HorizontalDivider(modifier = Modifier.fillMaxWidth(0.4f))
        }
    }
}

@Composable
private fun TextImage(ref: String, loader: TextPageLoader, modifier: Modifier) {
    val bitmap by produceState<ImageBitmap?>(null, ref, loader) {
        value = withContext(Dispatchers.IO) {
            runCatching {
                // Decoding straight from the archive's stream crashes natively, so the bytes are read out first.
                loader.openImage(ref)?.use { it.readBytes() }?.let { BitmapFactory.decodeByteArray(it, 0, it.size) }
            }.getOrNull()?.asImageBitmap()
        }
    }
    bitmap?.let {
        Image(
            bitmap = it,
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = modifier.fillMaxWidth(),
        )
    }
}

private fun headingScale(level: Int): Float = when (level) {
    1 -> 1.6f
    2 -> 1.4f
    3 -> 1.2f
    else -> 1.1f
}

private fun TextSettings.textStyle(
    scale: Float = 1f,
    family: FontFamily = this.family,
    weight: FontWeight? = null,
    color: Color = this.color,
    textAlign: TextAlign = TextAlign.Start,
): TextStyle {
    val size = fontSize * scale
    return TextStyle(
        fontFamily = family,
        fontSize = size.sp,
        lineHeight = (size * lineSpacing / 100f).sp,
        fontWeight = weight,
        color = color,
        textAlign = textAlign,
    )
}

private fun BookText.toAnnotatedString(): AnnotatedString = buildAnnotatedString {
    append(text)
    spans.forEach { span ->
        addStyle(span.style.toSpanStyle(), span.start, span.end)
    }
}

private fun BookText.Style.toSpanStyle(): SpanStyle = when (this) {
    BookText.Style.Bold -> SpanStyle(fontWeight = FontWeight.Bold)
    BookText.Style.Italic -> SpanStyle(fontStyle = FontStyle.Italic)
    BookText.Style.Underline -> SpanStyle(textDecoration = TextDecoration.Underline)
    BookText.Style.Strikethrough -> SpanStyle(textDecoration = TextDecoration.LineThrough)
    BookText.Style.Monospace -> SpanStyle(fontFamily = FontFamily.Monospace)
    BookText.Style.Superscript -> SpanStyle(baselineShift = BaselineShift.Superscript, fontSize = 0.75.em)
    BookText.Style.Subscript -> SpanStyle(baselineShift = BaselineShift.Subscript, fontSize = 0.75.em)
}
