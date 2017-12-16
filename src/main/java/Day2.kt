class Day2 {
    fun checksum(matrix: Array<IntArray>): Int {
        var totalCS = 0
        for (rowArray in matrix) {
            var min = Int.MAX_VALUE
            var max = 0

            for (j in 0..rowArray.size - 1) {
                if (rowArray[j] > max) {
                    max = rowArray[j]
                }
                if (rowArray[j] < min) {
                    min = rowArray[j]
                }
            }

            totalCS += (max - min)

        }
        return totalCS
    }

    fun divisor(matrix: Array<IntArray>) : Int {
        var result = 0
        for (row in matrix) {
            var found = false
            while (!found) {
                for (j in 0..row.size - 1) {
                    val anchor = row[j]
                    for (i in 0..row.size - 1) {
                        if (anchor != row[i] && anchor % row[i] == 0) {
                            result += (anchor / row[i])
                            found = true
                        }
                    }
                }
            }
        }

        return result
    }
}