package mihon.core.archive

import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.pdf.PdfRenderer
import android.os.ParcelFileDescriptor
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.Closeable
import java.io.InputStream
import kotlin.math.roundToInt

/**
 * Wrapper over [PdfRenderer] that exposes each page of a pdf file as a PNG image.
 */
class PdfReader(pfd: ParcelFileDescriptor) : Closeable {

    // PdfRenderer owns the descriptor and closes it along with the renderer.
    private val renderer = PdfRenderer(pfd)

    private var closed = false

    val pageCount: Int = renderer.pageCount

    /**
     * Renders the page at [index] as a PNG.
     */
    @Synchronized
    fun renderPage(index: Int): InputStream {
        check(!closed) { "PdfReader is closed" }
        val bitmap = renderer.openPage(index).use { page ->
            val scale = minOf(MAX_SIDE / maxOf(page.width, page.height).toFloat(), MAX_SCALE)
            Bitmap.createBitmap(
                (page.width * scale).roundToInt(),
                (page.height * scale).roundToInt(),
                Bitmap.Config.ARGB_8888,
            ).apply {
                // Transparent pages would otherwise show up black in the reader.
                eraseColor(Color.WHITE)
                page.render(this, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY)
            }
        }
        val output = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, output)
        bitmap.recycle()
        return ByteArrayInputStream(output.toByteArray())
    }

    @Synchronized
    override fun close() {
        if (closed) return
        closed = true
        renderer.close()
    }

    private companion object {
        const val MAX_SIDE = 2400f
        const val MAX_SCALE = 4f
    }
}
