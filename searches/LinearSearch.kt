/**
 * @return index of element. -1 if not found or list is empty
 */
fun <T> List<T>.searchLinear(
    value: T,
    fromIndex: Int = 0,
    toIndex: Int = size
): Int {
    takeIf { it.isNotEmpty() }
    for (i: Int in fromIndex until toIndex) if (this[i] == value) return i
    return -1
}

fun main() {
    val list = listOf(1, 2, 3, 4, 5)
    println(list.searchLinear(3)) // -> 2
    println(list.searchLinear(6)) // -> -1
    println(list.searchLinear(4, 3, 9)) // -> 3
    println(listOf<Int>().searchLinear(5)) // -> -1
}