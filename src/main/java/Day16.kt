import java.io.File
import java.io.InputStream
import java.nio.charset.Charset

class Day16(size : Int) {
    var danceFloor = (0 until 16).map { 'a' + it}

    init {
        if (size == 5) {
            danceFloor = (0 until 5).map {'a' + it}
        }
    }

    fun danceMany(path: String, times: Int) : String {
        val moves = loadMoves(path)
        val sequence = mutableListOf<List<Char>>()
        var currFloor = (0 until 16).map { 'a' + it }

        repeat (times) {
            if (currFloor in sequence) {
                return sequence[times % sequence.size].joinToString(separator = "")
            } else {
                sequence.add(currFloor)
                currFloor = performMove(moves)
            }
        }
        return currFloor.joinToString(separator = "")
    }

    fun dance(path: String) : String {
        val moves = loadMoves(path)
        val result = performMove(moves)
        return result.joinToString(separator = "")
    }

    fun performMove(moves : List<String>) : MutableList<Char> {
        var danceBuffer = danceFloor.toMutableList()

        for (move in moves) {
            val op = move.substring(0,1)
            if (op == "s") {
                val distance = move.substring(1).toInt()
                danceBuffer = (danceBuffer.drop(danceBuffer.size - distance) + danceBuffer.take(danceBuffer.size - distance)).toMutableList()
            } else if (op == "x") {
                val positions = move.split("/")
                val aPos = positions[0].substring(1).toInt()
                val bPos = positions[1].toInt()
                danceBuffer[aPos] = danceBuffer[bPos].also { danceBuffer[bPos] = danceBuffer[aPos] }
            } else if (op == "p") {
                val (aPos, bPos) = move.drop(1).split("/").map { danceBuffer.indexOf(it[0]) }
                danceBuffer[aPos] = danceBuffer[bPos].also { danceBuffer[bPos] = danceBuffer[aPos] }
            }
        }

            danceFloor = danceBuffer
        return danceBuffer
    }

    fun loadMoves(path: String) : List<String> {
        val file = File(path)
        var stream: InputStream = file.inputStream()
        var danceMoves = stream.readBytes().toString(Charset.defaultCharset())
        return danceMoves.split(",")
    }
}