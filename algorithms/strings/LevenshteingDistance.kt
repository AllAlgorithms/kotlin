import kotlin.test.assertEquals

fun main(args: Array<String>) {
    "some" to "thing" test 5
    "kitten" to "sitting" test 3
    "equal" to "equal" test 0
    "empty" to "" test 5
    "" to "empty" test 5
}

infix fun Pair<String, String>.test(expected: Int) {
    val v = levenshteingDistance(first, second)
    assertEquals(expected, v, "$this")
}


fun levenshteingDistance(v1: String, v2: String): Int {
    if(v1.isEmpty()) {
        return v2.length
    }
    if(v2.isEmpty()) {
        return v1.length
    }

    var c1 = IntArray(v1.length + 1) { it }
    var c2 = IntArray(c1.size)

    for (j in 1..v2.length) {
        c2[0] = j
        for(i in 1..v1.length) {
            val cmp = if(v1[i - 1] == v2[j - 1]) 0 else 1

            val replace = c1[i - 1] + cmp
            val insert = c1[i] + 1
            val delete = c2[i - 1] + 1

            c2[i] = minOf(replace, insert, delete)
        }
        val tmp = c1
        c1 = c2
        c2 = tmp
    }

    return c1.last()
}