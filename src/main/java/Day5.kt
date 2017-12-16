import java.io.File
import java.io.InputStream
import java.util.*

fun main(args: Array<String>) {
    val inputStream: InputStream = File("/Users/Thunderbird/bbarbour/projects/AdventCoder/src/main/resources/day5.input").inputStream()
    val lineList = mutableListOf<String>()

    inputStream.bufferedReader().useLines { lines -> lines.forEach { lineList.add(it)} }
    val instructions : IntArray = IntArray(lineList.size)
    for (j in 0..lineList.size - 1) {
        instructions[j] = lineList[j].toInt()
    }

    var i : Int = 0
    var stepCounter = 0

    while (i < instructions.size) {
        val offset = instructions[i]

        if (offset >= 3) {
            instructions[i] = offset - 1
        } else {
            instructions[i] = offset + 1
        }

        i = i + offset
        stepCounter++
//        println("step $stepCounter has offset $offset i : $i ")
    }

    println(stepCounter)

}


