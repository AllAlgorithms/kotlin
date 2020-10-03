import kotlin.math.abs
import kotlin.math.sqrt

/*
Babylonian method for finding square roots
https://en.wikipedia.org/wiki/Methods_of_computing_square_roots#Babylonian_method
*/

const val number: Double = 100.0

//starting point
var candidate = number / 2.0
val goodError = 0.000000001

fun babylonianMethod() {
    val actual: Double = sqrt(number)
    while (abs(actual - candidate) > goodError) {
        println("$candidate")
        candidate = formula(candidate)
    }
    println("$candidate")
}

private fun formula(candidate: Double): Double = (candidate + number / candidate) / 2.0