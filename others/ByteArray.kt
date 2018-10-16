package fr.imprimerienationale.innolab.inwallet.extensions

private val chars = "0123456789ABCDEF".toCharArray()

fun ByteArray.toHexString(): String {
    val result = StringBuffer()

    forEach {
        val octet = it.toInt()
        val firstIndex = (octet and 0xF0).ushr(4)
        val secondIndex = octet and 0x0F
        result.append(chars[firstIndex])
        result.append(chars[secondIndex])
    }

    return result.toString()
}