import java.io.File
import java.io.InputStream
import java.nio.charset.Charset

class Day11 {
    fun loadBoard(size:Int) : Array<IntArray> {
        val matrix = Array(size, {IntArray(size)})
        var distance = 0
        var rowCounter= 0
        var skip = false

        for (i in 0..size-1) {
            if (i > 0) {
                if (skip) {
                    distance = rowCounter
                } else {
                    distance = rowCounter++
                }
            }

            for (j in 0..size-1) {
                if (skip) {
                    matrix[i][j] = -1
                } else {
                    matrix[i][j] = distance++
                }
                skip = !skip
            }
            if (i == 0) rowCounter++
        }

//        for (i in 0..size-1) {
//            for (j in 0..size-1) {
//                if (matrix[i][j] < 0) print("  ") else print(matrix[i][j])
//            }
//                print("\t")
//
//            println()
//        }
        return matrix
    }

    fun calcSteps(input : String) : Int {
        val matrix = loadBoard(1000)
        val startRow = 500
        val startCol = 500
        var currentRow = startRow
        var currentCol = startCol

        val moves = input.split(",")

        for (move in moves) {
            if (move == "n") {
                currentCol += 2
            }
            if (move == "s") {
                currentCol -= 2
            }
            if (move == "ne") {
                currentCol += 1
                currentRow += 1
            }
            if (move == "se") {
                currentCol -= 1
                currentRow += 1
            }
            if (move == "sw") {
                currentRow -= 1
                currentCol -= 1
            }
            if (move == "nw") {
                currentRow -= 1
                currentCol += 1
            }

            if (currentRow < 0) {
                currentRow = 0
            }

            if (currentCol < 0) {
                currentCol = 0
            }

            if (currentCol > 999) {
                currentCol = 999
            }

            if (currentRow > 999) {
                currentRow = 999
            }
        }

        val origin = matrix[startRow][startCol]
        val destination = matrix[currentRow][currentCol]
        println("Origin ($startRow, $startCol) = $origin \t Dest ($currentRow, $currentCol) = $destination")
        return Math.abs((startRow - currentRow) * (startCol - currentCol)) / 2
//        return Math.abs(Math.abs(origin) - Math.abs(destination))
    }

    fun woMatrix(input: String) : Int {
        val moves = input.split(",")
        var x = 0
        var y = 0

        for (move in moves) {
            if (move == "n") {
                y += -1
            }
            if (move == "s") {
                y += 1
            }
            if (move == "ne") {
                x += 1
                y += -1
            }
            if (move == "se") {
                x += 1
            }
            if (move == "nw") {
                x += -1
            }
            if (move == "sw") {
                x += -1
                y += 1
            }
        }

        val distance = (Math.abs(x) + Math.abs(y) + Math.abs(x + y)) / 2
        return distance
    }

    fun loadInFile(path: String) : Int {
        val file = File(path)
        var stream: InputStream = file.inputStream()
        var content = stream.readBytes().toString(Charset.defaultCharset())
        return woMatrix(content)
    }

    fun findMax(path: String) : Int {
        val file = File(path)
        var stream: InputStream = file.inputStream()
        var input = stream.readBytes().toString(Charset.defaultCharset())
        val moves = input.split(",")
        var x = 0
        var y = 0
        var maxDistance = 0

        for (move in moves) {
            if (move == "n") {
                y += -1
            }
            if (move == "s") {
                y += 1
            }
            if (move == "ne") {
                x += 1
                y += -1
            }
            if (move == "se") {
                x += 1
            }
            if (move == "nw") {
                x += -1
            }
            if (move == "sw") {
                x += -1
                y += 1
            }

            val distance = (Math.abs(x) + Math.abs(y) + Math.abs(x + y)) / 2

            if (distance > maxDistance) {
                maxDistance = distance
            }
        }

        return maxDistance
    }
}