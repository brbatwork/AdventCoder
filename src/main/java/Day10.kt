import org.jetbrains.annotations.Mutable

class Day10 {

    fun twistRope(rope: IntArray, input: Array<Int>) : Int {
        var position = 0
        var skip = 0

        for (length in input) {
            val temp = mutableListOf<Int>()

            for (i in position..(position+length - 1)) {
                temp.add(rope[i % rope.size])
            }

            temp.reverse()

            for (counter in 0..length - 1) {
                rope[(position+counter) % rope.size] = temp[counter]
            }
            position += length + skip
            position %= rope.size
            skip++
        }

        return rope[0] * rope[1]
    }

    fun knotHash(rope: IntArray, input: String) : String {
        val lengthList = mutableListOf<Int>()

        // Load the buffer with out input string
        for (ch in input) {
            lengthList.add(ch.toInt())
        }

        lengthList.addAll(mutableListOf(17, 31, 73, 47, 23))
        var position = 0
        var skip = 0

        for ( iteration in 1..64) {
            for (length in lengthList) {
                val temp = mutableListOf<Int>()

                for (i in position..position+length - 1) {
                    temp.add(rope[i % rope.size])
                }

                temp.reverse()

                for (counter in 0..length - 1) {
                    rope[(position+counter) % rope.size] = temp[counter]
                }
                position += length + skip
                position %= rope.size
                skip++
            }
        }

        val blocks = IntArray(rope.size / 16)
        var blockId = 0


        for (i in 0..255) {
            if (i > 0 && i % 16 == 0) {
                blockId++
            }

            blocks[blockId] = rope[i].xor(blocks[blockId])
        }

        var output = ""
        for (block in blocks) {
            val hex = java.lang.String.format("%02x", block)
            output += hex
        }
        return output

    }
}