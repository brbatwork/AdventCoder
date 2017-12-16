import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.math.BigInteger
import jdk.nashorn.internal.objects.ArrayBufferView.buffer



class Day14 {
    val grid = Array(128, {IntArray(128)})
    val visitedGrid = Array(128, {IntArray(128)})

    fun defrag(input : String) :  Int {
        // Take the input string and calc the knot hash then convert the hash to binary
        val day10 = Day10()
        var bitsInUse = 0

        for (i in 0..127) {
            val hash = day10.knotHash(IntArray(256, { it * 1 }), "$input-$i")
            for (ch in hash) {
                val binaryVal = convertToBinary("$ch").toString(2)
                var bitPattern = binaryVal

                if (binaryVal.length >= 4) {
                    bitPattern = binaryVal.substring(0, 4)
                }

                for (bp in bitPattern) {
                    if (bp == '1') {
                        bitsInUse++
                    }
                }
            }
        }

        return bitsInUse
    }

    fun countRegions(input: String) : Int {
        var totalRegions = 0
        val day10 = Day10()

        for (i in 0..127) {
            val hash = day10.knotHash(IntArray(256, { it * 1 }), "$input-$i")
            var column = 0
            for (ch in hash) {
                val binaryVal = convertToBinary("$ch").toString(2)
                var bitPattern = binaryVal

                if (binaryVal.length >= 4) {
                    bitPattern = binaryVal.substring(0, 4)
                }

                val columns = grid[i]
                for (bp in bitPattern) {
                    if (bp == '1') {
                        columns[column] = 1
                    }
                    column++
                }
            }
        }

        for (i in 0..127) {
            val row = grid[i]
            val visitedRow = visitedGrid[i]
            for (j in 0..127) {
                if (row[j] == 1 && visitedRow[j] != 1) {
                    depthFirstSearch(i, j)
                    totalRegions++
                    println("Region mapped for $i,$j Total regions $totalRegions\n")
                }
            }
        }

        return totalRegions
    }

    fun countRegionsBFS(input: String) : Int {
        val day10 = Day10()

        for (i in 0..127) {
            val hash = day10.knotHash(IntArray(256, { it * 1 }), "$input-$i")
            var column = 0
            for (ch in hash) {
                val binaryVal = convertToBinary("$ch").toString(2)
                var bitPattern = binaryVal

                if (binaryVal.length >= 4) {
                    bitPattern = binaryVal.substring(0, 4)
                }

                val columns = grid[i]
                for (bp in bitPattern) {
                    if (bp == '1') {
                        columns[column] = 1
                    }
                    column++
                }
            }
        }

        var currGroup = 2

        for (i in 0..127) {
            val row = grid[i]
            for (j in 0..127) {
                if (row[j] == 1) {
                    row[j] = currGroup
                    val queue = mutableListOf(listOf(i, j, currGroup))
                    // BFS: If the neighbour is set to 1 it's part of the group and wasn't yet explored
                    while (queue.isNotEmpty()) {
                        val (baseX, baseY, group) = queue.removeAt(0)
                        for ((xOff, yOff) in listOf(Pair(0, -1), Pair(0, 1), Pair(-1, 0), Pair(1, 0))) {
                            val x = baseX + xOff
                            val y = baseY + yOff
                            try {
                                val rowArray = grid[x]
                                if (rowArray[y] == 1) {
                                    rowArray[y] = (group)
                                    queue.add(listOf(x, y, group))
                                }
                            } catch (_: Exception) { }
                        }
                    }
                    currGroup++
                }
                }
            }

            return currGroup - 2
        }

    fun depthFirstSearch(row: Int, column: Int) {
        val rowNeighbrs = arrayOf(-1,1, 0, 0)
        val colNeighbrs = arrayOf(0,0, -1, 1)
        val visitedRow = visitedGrid[row]
        println("$row $column now visited")
        visitedRow[column] = 1

        for (neighbor in 0..rowNeighbrs.size-1) {
            val nextRow = row + rowNeighbrs[neighbor]
            val nextCol = column + colNeighbrs[neighbor]
            if (isHit(nextRow, nextCol)) {
                depthFirstSearch(nextRow, nextCol)
            }
        }
    }

    fun isHit(row: Int, col: Int) : Boolean {
        if (row >= 0 && row < 128) {
            val rowArray = grid[row]
            val visitedRow : IntArray = visitedGrid[row]
            val isOne =  (col >=0) && (col < 128) && (rowArray[col] == 1 && visitedRow[col] != 1)
            println("$row,$col = $isOne")
            return isOne
        }
        return false
    }

    fun convertToBinary(input: String) : Int {
        val value : Int = Integer.parseInt(input, 16)
        val buffer = ByteBuffer.allocate(4)
        buffer.order(ByteOrder.BIG_ENDIAN)
        buffer.asIntBuffer().put(value)
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        return buffer.asIntBuffer().get()
    }
}