class Day3 {
    fun buildSpiral(size: Int) : Array<IntArray> {
        val spiral : Array<IntArray> = Array(size, {IntArray(size)})
        var value = 1
        var minCol = 0
        var maxCol = size - 1
        var minRow = 0
        var maxRow = size - 1

        while (value <= size * size) {
            for (i in minRow..maxRow) {
                spiral[i][minCol] = value
                value++
            }
            for (i in (minCol + 1)..maxCol) {
                spiral[maxRow][i] = value
                value++
            }
            for (i in (maxRow - 1) downTo minRow) {
                spiral[i][maxCol] = value
                value++
            }
            for (i in (maxCol - 1) downTo (minCol + 1)) {
                spiral[minRow][i] = value
                value++
            }
            minCol++
            minRow++
            maxCol--
            maxRow--
        }

        for (i in 0..spiral.size - 1) {
            for (j in 0..spiral.size - 1) {
                print("${spiral[i][j]} \t")
            }
            println()
        }

        return spiral
    }

    fun calcDistance(needle: Int) : Int {
        val spiral = buildSpiral(needle)
        var result : Int = 0

        for (j in spiral.indices) {
            val rowArray = spiral[j]
            for (i in rowArray.indices) {
                if (rowArray[i] == needle) {
                    result = j + i
                    break
                }
            }
        }

        return result

    }

    fun calcAccum(size:Int, needle: Int) : Int {
        val matrix = IntArray(needle, {0})

        for (i in 0..matrix.size - 1) {
            var running = 0

            for (j in 0..i) {
                running += matrix[j]
            }

            if (running == 0) {
                running++
            }
            matrix[i] = running

            if (running > needle) {
                return running
            }
        }


        return 0
    }
}
