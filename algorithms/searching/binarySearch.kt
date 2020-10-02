/**
 * Binary search
 */

const val VALUE_NOT_FOUND = -1

fun main(args: Array<String>) {
    val list = listOf(1, 2, 8, 9, 13, 18, 25, 59, 94, 111, 147, 510, 1024)
    val valueToFind = 25
    val result = binarySearch(list, 0, list.size - 1, valueToFind)
    when (result) {
        VALUE_NOT_FOUND -> println("Value not found")
        else -> println("Value found at position -> $result")
    }
}


fun binarySearch(list: List<Int>, min: Int, max: Int, valueToFind: Int): Int {
    if (max >= min) {
        var position = min + (max - min) / 2
        return if (list[position] == valueToFind) {
            position
        } else if (list[position] > valueToFind) {
            binarySearch(list, min, position - 1, valueToFind)
        } else {
            binarySearch(list, position + 1, max, valueToFind)
        }
    }
    return VALUE_NOT_FOUND
}