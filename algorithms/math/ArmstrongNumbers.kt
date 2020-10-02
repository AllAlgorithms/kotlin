fun main(args: Array<String>) {
    val number = 54748

    val length = number.toString().length.toDouble()

    val sum = number.toString().toCharArray().map { Math.pow(it.toString().toDouble(), length).toInt() }.sum()

    if (sum==number)
        println("$number is an Armstrong number")
    else
        println("$number is NOT an Armstrong number")
}