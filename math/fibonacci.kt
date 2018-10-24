/**
 * Fibonacci recursive
 */

const val FIRST_NUMBER = 1
const val SECOND_NUMBER = 2

fun main(args: Array<String>) {
    println(fibonacci(6))
}

fun fibonacci(number: Int): Long {
    return when (number) {
        FIRST_NUMBER -> 1
        SECOND_NUMBER -> 1
        else -> fibonacci(number - 2) + fibonacci(number - 1)
    }
}