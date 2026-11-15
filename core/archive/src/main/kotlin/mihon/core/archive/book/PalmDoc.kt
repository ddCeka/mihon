package mihon.core.archive.book

import java.nio.ByteBuffer

/** Splits a Palm database file into its records. */
internal fun readPalmRecords(bytes: ByteArray): List<ByteArray> {
    val count = bytes.u16(76)
    val starts = List(count) { bytes.u32(78 + it * 8).toInt() } + bytes.size
    return List(count) { bytes.copyOfRange(starts[it], starts[it + 1]) }
}

internal fun ByteArray.u16(offset: Int): Int = ByteBuffer.wrap(this).getShort(offset).toInt() and 0xFFFF

internal fun ByteArray.u32(offset: Int): Long = ByteBuffer.wrap(this).getInt(offset).toLong() and 0xFFFFFFFFL

/** Removes the trailing entries that the MOBI header's extra data flags announce. */
internal fun stripTrailingEntries(record: ByteArray, extraFlags: Int): ByteArray {
    var end = record.size
    for (bit in 1..15) {
        if ((extraFlags and (1 shl bit)) != 0) {
            end = (end - trailingEntrySize(record, end)).coerceAtLeast(0)
        }
    }
    if ((extraFlags and 1) != 0 && end > 0) {
        end = (end - ((record[end - 1].toInt() and 0x3) + 1)).coerceAtLeast(0)
    }
    return record.copyOf(end)
}

/** Size of the backward variable-length integer that ends at [end], including its own bytes. */
internal fun trailingEntrySize(record: ByteArray, end: Int): Int {
    var value = 0
    var shift = 0
    var pos = end - 1
    var count = 0
    while (pos >= 0 && count < 4) {
        val b = record[pos--].toInt() and 0xFF
        value = value or ((b and 0x7F) shl shift)
        shift += 7
        count++
        if ((b and 0x80) != 0) break
    }
    return value
}

/** PalmDOC LZ77 decompression. */
internal fun decompressPalmDoc(input: ByteArray): ByteArray {
    val output = ByteBuilder(input.size * 2)
    var i = 0
    while (i < input.size) {
        val c = input[i++].toInt() and 0xFF
        when (c) {
            0 -> output.add(0)
            in 1..8 -> {
                val count = minOf(c, input.size - i)
                output.addRange(input, i, count)
                i += count
            }
            in 9..0x7F -> output.add(c)
            in 0x80..0xBF -> {
                if (i >= input.size) break
                val pair = ((c shl 8) or (input[i++].toInt() and 0xFF)) and 0x3FFF
                val distance = pair shr 3
                val length = (pair and 7) + 3
                if (distance in 1..output.size) {
                    repeat(length) { output.add(output[output.size - distance].toInt()) }
                }
            }
            else -> {
                output.add(0x20)
                output.add(c xor 0x80)
            }
        }
    }
    return output.toByteArray()
}

private class ByteBuilder(capacity: Int) {
    private var bytes = ByteArray(capacity)

    var size = 0
        private set

    operator fun get(index: Int): Byte = bytes[index]

    fun add(value: Int) {
        ensureCapacity(size + 1)
        bytes[size++] = value.toByte()
    }

    fun addRange(source: ByteArray, offset: Int, count: Int) {
        ensureCapacity(size + count)
        source.copyInto(bytes, size, offset, offset + count)
        size += count
    }

    fun toByteArray(): ByteArray = bytes.copyOf(size)

    private fun ensureCapacity(required: Int) {
        if (required > bytes.size) bytes = bytes.copyOf(maxOf(required, bytes.size * 2))
    }
}
