/**
 * Factorial example using fold
 * works from 1 to 20. Above 20 numbers get overflowed
 */

fun main(args: Array<String>) {
    val number = 20
    println(factorialUsingFold(number))
}

fun factorialUsingFold(number: Int): Long {
    return listOf(1..number).flatMap { it }.fold(1L) { total, next -> total * next }
}