import kotlin.test.assertEquals

fun main(args: Array<String>) {
    val a = 123132L
    val b = 483274L

    val (eB, eA) = xorSwap(a, b)

    assertEquals(a, eA)
    assertEquals(b, eB)
}

@Suppress("NAME_SHADOWING")
fun xorSwap(a: Long, b: Long): Pair<Long, Long> {
    var a = a
    var b = b

    a = a.xor(b)
    b = b.xor(a)
    a = a.xor(b)

    return a to b
}