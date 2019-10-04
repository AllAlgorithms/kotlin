fun <T> List<T>.searchLinear(value: T): Boolean {
    this.forEach { if (it == value) return true }
    return false
}

fun main() {
    println(listOf(1, 2, 3, 4, 5).searchLinear(3)) // -> false
    println(listOf(1, 2, 3, 4, 5).searchLinear(6)) // -> false
}