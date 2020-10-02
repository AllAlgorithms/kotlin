fun main(args: Array<String>) {
    val number1 = 284
    val number2 = 220

    val number1FactorsSum = number1.getFactors().sum()
    val number2FactorsSum = number2.getFactors().sum()

    if (number1FactorsSum == number2 && number2FactorsSum == number1)
        println("$number1 and $number2 are an Amicable Numbers")
    else
        println("$number1 and $number2 are NOT an Amicable Numbers")
}

fun Int.getFactors(): MutableList<Int> {
    val factors = mutableListOf<Int>()
    if (this < 2)
        return factors
    (1..this / 2)
        .filter { this % it == 0 }
        .forEach { factors.add(it) }
    return factors
}
