import java.math.BigInteger

/*
https://en.wikipedia.org/wiki/Catalan_number
 */

fun findFirst100(){
    for (i in 0..99){
        val number = catalanNumber(i)
        println("$number")
    }
}

fun catalanNumber(nThNumber: Int): BigInteger {
    val numerator = factorial(2 * nThNumber)
    val denominator = factorial(nThNumber + 1).multiply(factorial(nThNumber))
    return numerator.divide(denominator)
}

fun factorial(n: Int): BigInteger {
    var result = BigInteger.ONE
    for (i in 2..n) result = result.multiply(BigInteger.valueOf(i.toLong()))
    return result
}