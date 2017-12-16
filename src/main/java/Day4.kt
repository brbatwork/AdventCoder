import java.io.File
import java.io.InputStream
import java.util.*

fun main(args: Array<String>) {
    val inputStream: InputStream = File("/Users/Thunderbird/bbarbour/projects/AdventCoder/src/main/resources/day4.input").inputStream()
    val lineList = mutableListOf<String>()

    inputStream.bufferedReader().useLines { lines -> lines.forEach { lineList.add(it)} }
    var total_valid = 0

    for (it in lineList) {
        val parts = it.split(" ")
        var is_valid = true

        for (i in 0..parts.size - 1) {
            for (j in 0..parts.size -1) {
                if (i != j && isAnagram(parts[i], parts[j])) {
                    is_valid = false
                }

            }
        }

        if (is_valid) total_valid++

    }

    println(total_valid)
}

fun isAnagram(s1 : String, s2 : String) : Boolean {
    if (s1.length != s2.length)
        return false

    val a1 = s1.toCharArray()
    val a2 = s2.toCharArray()
    Arrays.sort(a1)
    Arrays.sort(a2)
    return Arrays.equals(a1,a2)




}