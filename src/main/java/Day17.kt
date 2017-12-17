class Day17 {

    fun runSpinLock(steps : Int, times : Int, needle: Int) : Int {
        val buffer = mutableListOf<Int>()
        buffer.add(0)
        buffer.add(1)
        var currentPos = 1

        for (i in 2..times) {
            currentPos = ((currentPos + steps) % buffer.count()) + 1
            buffer.add(currentPos, i)
        }

        val idx = buffer.indexOf(needle)
        return buffer.get(idx + 1)
    }

    fun fasterSpin(steps: Int, times: Int, needle : Int) : Int {
        var buffer = 1
        var position = 0
        var output = 0

        for (i in 0..times) {
            val to_insert = i + 1
            var new_position = (position + steps) % buffer
            new_position += 1

            if (new_position == (needle + 1)) {
                output = to_insert
            }

            position = new_position
            buffer++
        }

        return output
    }
 }
