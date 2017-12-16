import java.io.File
import java.io.InputStream
import java.nio.charset.Charset

class Day9 {

    fun countGroupsInFile(path: String) : Int {
        val file = File(path)
        var stream:InputStream = file.inputStream()
        var content = stream.readBytes().toString(Charset.defaultCharset())
        return countGroups(content)
    }

    fun countGarbageInFile(path: String) : Int {
        val file = File(path)
        var stream:InputStream = file.inputStream()
        var content = stream.readBytes().toString(Charset.defaultCharset())
        return countGarbage(content)
    }

    fun countGarbage(input: String) : Int {
        var total = 0
        var escape = false
        var inGarbage = false

        for (ch in input) {
            if (inGarbage) {
                if (escape) {
                    escape = false
                    continue
                }
                if (ch != '!' && ch != '>') {
                    total += 1
                }
                inGarbage = (ch != '>')
            } else {
                inGarbage = (ch == '<')
            }
            escape = (ch == '!')
        }

        return total
    }

    fun countGroups(input: String) : Int {
        var total = 0
        var level = 0
        var escape = false
        var inGarbage = false

        for (ch in input) {
            if (inGarbage && escape) {
                escape = false
                continue
            }

            if (!inGarbage) {
                if (ch == '{') {
                    level += 1
                }
                if (ch == '}') {
                    total += level
                    level -= 1
                }
                if (ch == '<') {
                    inGarbage = true
                }
            }

            if (ch == '>') {
                inGarbage = false
            }

            escape = (ch == '!')
        }
        return total
    }
}