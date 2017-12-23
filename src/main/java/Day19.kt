import java.io.File
import java.io.InputStream

class Day19 {
    fun walkPath(mapData: String) : Pair<String, Int> {
        val foundLetters = mutableListOf<Char>()
        val dungeon = mutableListOf<CharArray>()
        val inStream : InputStream = File(mapData).inputStream()
        val linelist = mutableListOf<String>()

        inStream.bufferedReader().useLines { lines -> lines.forEach { linelist.add(it)}}

        linelist.forEach { it:String ->
            dungeon.add(it.toCharArray())
        }

        var finished = false
        var x = 0
        var y = 0
        var yDirection = 0
        var xDirection = 1
        var totalSteps = 0

        // Find the starting coord
        val firstLine = dungeon[0]

        for (j in 0 until firstLine.size) {
            if (firstLine[j] == '|') {
                y = j
                x++
            }
        }

        do {
            val characters = dungeon[x]
            val c = characters[y].toUpperCase()
            when (c) {
                in 'A'..'Z' -> {
                    foundLetters.add(c)
                    x += xDirection
                    y += yDirection
                }
                '|' -> {
                    if (yDirection == 0) {
                        x += xDirection
                    } else {
                        y += yDirection
                    }
                }
                '+' -> {
                    if (xDirection != 0) {
                        xDirection = 0
                        if (y - 1 >= 0 && characters[y - 1] != ' ') {
                            yDirection = -1
                        } else if (y + 1 < characters.size && characters[y + 1] != ' ') {
                            yDirection = 1
                        }
                    } else if (yDirection != 0) {
                        yDirection = 0
                        if (x - 1 >= 0) {
                            val prevLine = dungeon[x - 1]
                            if (y >= 0 && y <= prevLine.size - 1 && prevLine[y] != ' ') {
                                xDirection = -1
                            }
                        }
                        if (x + 1 < dungeon.size) {
                            val nextLine = dungeon[x + 1]
                            if (y >= 0 && y <= nextLine.size - 1 && nextLine[y] != ' ') {
                                xDirection = 1
                            }
                        }
                    }

                    y += yDirection
                    x += xDirection
                }
                '-' -> {
                    if (xDirection == 0) {
                        y += yDirection
                    } else {
                        x += xDirection
                    }
                }
                ' ' -> finished = true
            }

            totalSteps++
            if (x < 0 || y < 0 || x > dungeon.size || y > characters.size) {
                break
            }

        } while(!finished && (xDirection != 0 || yDirection != 0))

        return Pair(foundLetters.joinToString(""), totalSteps)
    }

}