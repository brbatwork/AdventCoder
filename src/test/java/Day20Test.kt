
import kotlin.test.assertEquals

internal class Day20Test {
    @org.junit.jupiter.api.Test
    fun sample1() {
        val day20 = Day20()
        val result =  day20.part1("/Users/Thunderbird/bbarbour/projects/AdventCoder/src/main/resources/day20sample.input")
        assertEquals(0, result)
    }

    @org.junit.jupiter.api.Test
    fun runPart1() {
        val day20 = Day20()
        val result =  day20.part1("/Users/Thunderbird/bbarbour/projects/AdventCoder/src/main/resources/day20.input")
        assertEquals(0, result)
    }
}