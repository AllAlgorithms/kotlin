import kotlin.math.max
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

fun main(args: Array<String>) {
    val alphabet = List('z' - 'a' + 1) {
        'a' + it
    }.toSet()

    val input = "lorem ipsum dolor sit amet, consectetur adipiscing elit."
    val expected = "mpsfn jqtvn epmps tju bnfu, dpotfdufuvs bejqjtdjoh fmju."

    val output = encrypt(input, alphabet, 1, 1)
    assertEquals(expected, output)
    val decoded = decrypt(output, alphabet, 1, 1)
    assertEquals(input, decoded)
}

val encrypt = affineGenerator { a, b, m, value ->
    ((a * value + b) % m)
}

val decrypt = affineGenerator { a, b, m, value ->
    (value - b) / a % m
}

fun affineGenerator(transform: (a: Int, b: Int, m: Int, value: Int) -> Int) =
        fun(input: String, alphabet: Set<Char>, a: Int, b: Int): String {
            assertNotEquals(0, alphabet.size, "Alphabet empty")
            assertTrue(a > 0, "a is not greater than zero")
            assertTrue(b > 0, "b is not greater than zero")
            assertTrue(checkCoprime(alphabet.size, a), "'a' is not coprime to alphabet size")

            return String(CharArray(input.length) {
                val old = alphabet.indexOf(input[it].toLowerCase())
                if (old == -1) {
                    input[it]
                } else {
                    val new = transform(a, b, alphabet.size, old)
                    alphabet.elementAt(new)
                }
            })
        }

fun checkCoprime(aP: Int, bP: Int): Boolean {
    var a = aP
    var b = bP
    while (a != 0 && b != 0) {
        if (a > b) {
            a -= b
        } else {
            b -= a
        }
    }
    return max(a, b) == 1
}
