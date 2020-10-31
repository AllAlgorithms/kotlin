import kotlin.test.assertEquals

fun main(args: Array<String>) {
    val value = 0b10111101101011L // 10 bits set
    val c1 = countBitsSet1(value)
    val c2 = countBitsSet1(value)
    assertEquals(10, c1)
    assertEquals(10, c2)
}

fun countBitsSet1(value: Long): Int {
    var count = 0
    var current = value
    while (current > 0) {
        if (current and 1 > 0) {
            count++
        }
        current = current shr 1
    }
    return count
}

fun countBitsSet2(value: Long): Int {
    var count = 0
    var current = value
    while (current > 0) {
        count++
        current = current and current - 1
    }
    return count
}