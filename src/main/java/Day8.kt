import java.util.Collections
import java.io.File
import java.io.InputStream

class Day8 {
    fun runPart1(path: String) : Int {
        val inStream : InputStream = File(path).inputStream()
        val linelist = mutableListOf<String>()
        inStream.bufferedReader().useLines { lines -> lines.forEach { linelist.add(it)}}
        val instructions: MutableList<Instruction> = mutableListOf()
        val registers: MutableMap<String, Int> = mutableMapOf()

        linelist.forEach { it:String ->
            instructions.add(Instruction(it))
        }

        for (inst in instructions) {
            val currentValue = registers[inst.register] ?: 0
            val referenceValue = registers[inst.cond_left] ?: 0

            if (inst.shouldExecute(referenceValue)) {
                val result = inst.execute(currentValue)
                registers[inst.register] = result
            }
        }

        return Collections.max(registers.values)
    }
    fun runPart2(path: String) : Int {
        val inStream : InputStream = File(path).inputStream()
        val linelist = mutableListOf<String>()
        inStream.bufferedReader().useLines { lines -> lines.forEach { linelist.add(it)}}
        val instructions: MutableList<Instruction> = mutableListOf()
        val registers: MutableMap<String, Int> = mutableMapOf()

        linelist.forEach { it:String ->
            instructions.add(Instruction(it))
        }

        var largestValue = 0

        for (inst in instructions) {
            val currentValue = registers[inst.register] ?: 0
            val referenceValue = registers[inst.cond_left] ?: 0

            if (inst.shouldExecute(referenceValue)) {
                val result = inst.execute(currentValue)
                registers[inst.register] = result

                if (result > largestValue)
                    largestValue = result
            }
        }

        return largestValue
    }
}
