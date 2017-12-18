import java.io.File
import java.io.InputStream

class Program(val input: List<String>, regP: Long = 0, val partOne: Boolean = false) {
    private val instructions = input.map { (it + " .").split(" ").toTypedArray() }.toMutableList()
    private val registers = longArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, regP, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    private var pc = 0

    var count = 0
    val inputQueue = mutableListOf<Long>()
    val outQueue = mutableListOf<Long>()

    private fun isReg(s: String): Boolean = s[0] in 'a'..'z'

    private fun getValue(s: String): Long = when (isReg(s)) {
        true -> registers[s[0] - 'a']
        false -> s.toLong()
    }

    fun run(): Long {
        while (pc < instructions.size) {
            val (inst, op1, op2) = instructions[pc]

            when (inst) {
                "snd" -> {
                    outQueue.add(getValue(op1))
                    count++
                }
                "set" -> if (isReg(op1)) registers[op1[0] - 'a'] = getValue(op2)
                "add" -> if (isReg(op1)) registers[op1[0] - 'a'] += getValue(op2)
                "mul" -> if (isReg(op1)) registers[op1[0] - 'a'] *= getValue(op2)
                "mod" -> if (isReg(op1)) registers[op1[0] - 'a'] %= getValue(op2)
                "jgz" -> if (getValue(op1) > 0L) pc += getValue(op2).toInt() - 1
                "rcv" -> {
                    when {
                        partOne -> return outQueue.last()
                        inputQueue.size == 0 -> return -1
                        else -> registers[op1[0] - 'a'] = inputQueue.removeAt(0)
                    }
                }
            }
            pc++
        }
        return 0
    }
}

class Day18 {
    fun runPart2(path: String) : Int {
        return partTwo(File(path).readLines())
    }

    fun partTwo(input: List<String>): Int {
        val prog1 = Program(input, regP = 0)
        val prog2 = Program(input, regP = 1)
        var result1 = 1L
        var result2 = 1L
        while (true) {
            if (result1 != 0L) {
                result1 = prog1.run()
            }
            prog2.inputQueue.addAll(prog1.outQueue)
            prog1.outQueue.clear()
            if (result2 != 0L) {
                result2 = prog2.run()
            }
            prog1.inputQueue.addAll(prog2.outQueue)
            prog2.outQueue.clear()
            if (result1 == 0L && result2 == 0L) {
                break
            }
            if (result1 < 0L && result2 < 0L && prog1.inputQueue.size == 0 && prog2.inputQueue.size == 0) {
                break
            }
        }
        return prog2.count
    }

    fun runDuet(path: String) : Int {
        var lastSoundPlayed = 0
        var idx = 0
        val registers = mutableMapOf<Char, Long>()
        val inStream : InputStream = File(path).inputStream()
        val linelist = mutableListOf<String>()
        val instruction : MutableList<List<String>> = mutableListOf()
        inStream.bufferedReader().useLines { lines -> lines.forEach { linelist.add(it)}}

        linelist.forEach { it:String ->
            val parts = it.split(" ")
            instruction.add(parts)
        }

        do {
            val inst = instruction.get(idx)
            val op = inst[0].trim()
            val rawLeft = normalizeValue(inst[1].trim()) as Char
            var rawRight : Any = 0
            var right : Long = 0

            if (inst.size > 2) {
                rawRight = normalizeValue(inst[2].trim())
            }

            val left = registers.getOrDefault(rawLeft, 0)

            if (rawRight is Char) {
                right = registers.getOrDefault(rawRight, 0)
            } else {
                right = (rawRight as Int).toLong()
            }

            var jump = false

            if (op == "snd") {
                println("Setting lastSoundPlayed to $left")
                lastSoundPlayed = left.toInt()
            } else if (op == "set") {
                registers[rawLeft] = right
            } else if (op == "add") {
                registers[rawLeft] = left + right
            } else if (op == "mul") {
                registers[rawLeft] = left * right
            } else if (op == "mod") {
                registers[rawLeft] = left % right
            } else if (op == "rcv" && left > 0) {
                return lastSoundPlayed
            } else if (op == "jgz" && left > 0) {
                if (right > 0) {
                    idx += (right - 1).toInt()
                } else {
                    idx += right.toInt()
                }

                jump = true
            }

            if (!jump) idx++
        } while (idx < instruction.size)

        return lastSoundPlayed
    }

    fun normalizeValue(value : String) : Any {
        if (value.length == 1 && !value.toCharArray()[0].isDigit()) {
            return value.toCharArray()[0]
        }

        return value.toInt()
    }

}