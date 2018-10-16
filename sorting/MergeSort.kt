import java.util.*
import java.util.stream.IntStream
import kotlin.math.absoluteValue
import kotlin.streams.toList

fun List<Int>.print() = this.forEach {
    print(String.format("%d ", it))
}

fun main(args: Array<String>) {
    val list: List<Int> = IntStream.generate {
        Random().nextInt().absoluteValue % 1000
    }.limit(10).toList()

    list.print()
    println()

    sort(list).print()
}

fun sort(list: List<Int>): List<Int> {
    if (list.size <= 1) {
        return list
    }

    val halfWay: Int = list.size / 2

    val leftSide = sort(list.subList(0, halfWay))
    val rightSide = sort(list.subList(halfWay, list.size))

    return merge(leftSide, rightSide)
}

private fun merge(leftList: List<Int>, rightList:List<Int>): List<Int> {
    val mergedList = mutableListOf<Int>()
    var leftSide = leftList
    var rightSide = rightList

    while(leftSide.isNotEmpty() || rightSide.isNotEmpty()) {
        if(rightSide.isEmpty() || leftSide.isNotEmpty() && leftSide.first() < rightSide.first()) {
            mergedList.add(leftSide.first())
            leftSide = leftSide.subList(1, leftSide.size)
        } else {
            mergedList.add(rightSide.first())
            rightSide = rightSide.subList(1, rightSide.size)
        }
    }

    return mergedList
}

