import java.io.File
import java.io.InputStream
import java.nio.charset.Charset

class Day12() {
    val lookup : MutableMap<Int, MutableList<Int>> = mutableMapOf()
    val foundPrograms : MutableSet<Int> = mutableSetOf()

    fun countProgramsInGroup(path: String) : Int {
        buildLookup(path)
        return foundPrograms.size
    }

    fun countGroups(path: String) : Int {
        var groupCount = 1

        buildLookup(path)
        for ((key,value) in this.lookup) {
            if (!foundPrograms.contains(key)) {
                groupCount += 1
                walkMap(key)
            }
        }
        return groupCount
    }

    fun buildLookup(path: String) {
        val inStream : InputStream = File(path).inputStream()
        val linelist = mutableListOf<String>()
        inStream.bufferedReader().useLines { lines -> lines.forEach { linelist.add(it)}}

        linelist.forEach { it:String ->
            val parts = it.split("<->")
            val program = parts[0].trim().toInt()
            val linksTo = parts[1].split(",")
            val linkedTo = mutableListOf<Int>()

            for (i in 0..linksTo.size - 1) {
                linkedTo.add(linksTo[i].trim().toInt())
            }

            this.lookup[program] = linkedTo
        }

        this.foundPrograms.add(0)
        walkMap(0)
    }

    fun walkMap(needle:Int) {
        val linked = this.lookup[needle]

        for (value in linked!!) {
            if (!this.foundPrograms.contains(value)) {
                this.foundPrograms.add(value)
                walkMap(value)
            }
        }
    }
}
