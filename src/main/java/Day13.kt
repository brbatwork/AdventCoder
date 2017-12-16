import org.jetbrains.annotations.Mutable
import java.io.File
import java.io.InputStream

class Day13 {
    fun buildBoard(path: String) : MutableMap<Int, IntArray> {
        val inStream : InputStream = File(path).inputStream()
        val linelist = mutableListOf<String>()
        val board : MutableMap<Int, IntArray> = mutableMapOf()
        inStream.bufferedReader().useLines { lines -> lines.forEach { linelist.add(it)}}

        linelist.forEach { it:String ->
            val parts = it.split(":")
            val layer = parts[0].trim().toInt()
            val range = parts[1].trim().toInt()
            board[layer] = IntArray(range)
        }

        return board
    }
    fun movePacket(path : String) : Int {
        val board = buildBoard(path)
        val  layers : IntArray = board.keys.toIntArray()
        layers.sort()
        var totalPenalty = 0

        for (pSeconds in 0..layers.last()) {

            val range = board[pSeconds]

            if (range != null) {

                val penalty = pSeconds * range.size
                val hit = pSeconds == 0 || pSeconds % ((range.size * 2) - 2) == 0

                if (hit) {
                    totalPenalty += penalty
                }
            }
        }

        return totalPenalty
    }


    fun calcSmallestDelay(path : String) : Int {
        val board = buildBoard(path)
        val  layers : IntArray = board.keys.toIntArray()
        layers.sort()
        var delay = 0

        while (delay < 1_000_000_000) {
            var hit = false

            for (pSeconds in 0..layers.last()) {
//                print("Entering layer $pSeconds after a delay of $delay")
                val range = board[pSeconds]

                if (range != null) {
                    hit = (pSeconds + delay) % ((range.size * 2) - 2) == 0
//                    println(" Hit: $hit")
                    if (hit) {
                        break
                    }
                } else {
                    println()
                }
            }

            if (!hit) return delay
//            println("---")
            delay++
        }

        return delay
    }
}
