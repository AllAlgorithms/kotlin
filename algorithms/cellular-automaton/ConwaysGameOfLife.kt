//region Options

val initialTable = """
00000000000000000000000000000000000
00010000001100000000000000000000000
01010000001100000000000110000000000
00110000000000000010000110000000000
00000000000000000001010000000000000
00000000000000000000000001000000000
00000000000000000000000000000000000
00000000000000000000000000000000000
00000000000000000000000000000000000
00000000000000000000000000000000000
00000000000000000000000000000000000
00000000000000000000000000000000000
00000000000000000000000000000000000
00000000000000000000000000000000000
""".trimIndent()

const val generations = -1 // -1 = infinite
const val printEachGen = true
const val delay = 500L

//endregion




//region Data
val longLine = "\n".repeat(20)
val stateChar = charArrayOf('\u25A1', '\u25A9')
var width = 0
var height = 0
lateinit var emptyArrayLine: ByteArray
lateinit var data: List<ByteArray>
//endregion

fun main() {
    setupInitialData()
    val action: (Int) -> Unit = {
        if (printEachGen) {
            printData()
            Thread.sleep(delay)
        }
        step()
    }
    if(generations == -1) {
        while(true) {
            action(0)
        }
    } else {
        repeat(generations, action)
        printData()
    }
}

fun setupInitialData() {
    val lineList = initialTable.split("\n")

    height = lineList.size
    width = lineList.first().length

    emptyArrayLine = ByteArray(width)
    data = List(height) { ByteArray(width) }
    lineList.forEachIndexed { x, line ->
        line.forEachIndexed { y, c ->
            data[x][y] = if(c == '1') 1 else 0
        }
    }
}

fun step() {
    data = List(height) { x ->
        if(x == 0 || x == height - 1) {
            return@List emptyArrayLine
        }
        ByteArray(width) { y ->
            if(y == 0 || y == width - 1) {
                return@ByteArray 0
            }
            val cur = data[x][y]

            val neighbours = data.subList(x - 1, x + 2).sumBy {
                it[y - 1] + it[y] + it[y + 1]
            } - cur

            when {
                cur > 0 && neighbours < 2 -> 0
                cur > 0 && neighbours > 3 -> 0
                cur < 1 && neighbours == 3 -> 1
                else -> cur
            }
        }
    }
}

fun printData() {
    if(printEachGen) {
        print(longLine)
    }
    data.forEach { line ->
        println(CharArray(line.size) { stateChar[line[it].toInt()] })
    }
}
