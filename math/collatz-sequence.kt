fun main(args: Array<String>) {

    val initialNumber = 27
    val list = mutableListOf(initialNumber)
    while (list[list.size - 1] != 1) {
        list.add(collatzSequence(list[list.size - 1], list.size))
    }

    list.forEach { println(it) }

}

fun collatzSequence(number: Int, index: Int): Int {
    return if (index == 0) number else modularArithmeticNotation(number)
}

fun modularArithmeticNotation(number: Int): Int {
    return if (number.rem(2) == 0) number / 2 else 3 * number + 1
}
