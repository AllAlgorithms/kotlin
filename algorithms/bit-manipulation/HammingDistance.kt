import kotlin.test.assertEquals

fun main(args: Array<String>) {
    val v1 = 0b1001010101011001L
    val v2 = 0b1001010110011101L

    val c1 = hammingDistance1(v1, v2)
    val c2 = hammingDistance2(v1, v2)
    assertEquals(3, c1)
    assertEquals(3, c2)
}

fun hammingDistance1(v1: Long, v2: Long): Int {
    var count = 0
    for(i in 0 until Long.SIZE_BITS) {
        if((v1 shr i) and 1 != (v2 shr i) and 1) {
            count++
        }
    }
    return count
}

fun hammingDistance2(v1: Long, v2: Long): Int {
    var count = 0
    var value = v1 xor v2
    while(value > 0) {
        count++
        value = value and value - 1
    }
    return count
}
