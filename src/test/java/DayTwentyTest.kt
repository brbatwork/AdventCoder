
import kotlin.test.assertEquals

internal class DayTwentyTest {
    @org.junit.jupiter.api.Test
    fun sample1() {
        val day20 = DayTwenty()
        val result =  day20.solve("/Users/Thunderbird/bbarbour/projects/AdventCoder/src/main/resources/day20sample.input")
        assertEquals(0, result)
    }

    @org.junit.jupiter.api.Test
    fun part1() {
        val day20 = DayTwenty()
        val result =  day20.solve("/Users/Thunderbird/bbarbour/projects/AdventCoder/src/main/resources/day20.input")
        assertEquals(344, result)
    }

    @org.junit.jupiter.api.Test
    fun sample2() {
        val day20 = DayTwenty()
        val result =  day20.solve2("/Users/Thunderbird/bbarbour/projects/AdventCoder/src/main/resources/day20sample.input")
        assertEquals(2, result)
    }

    @org.junit.jupiter.api.Test
    fun part2() {
        val day20 = DayTwenty()
        val result =  day20.solve2("/Users/Thunderbird/bbarbour/projects/AdventCoder/src/main/resources/day20.input")
        assertEquals(404, result)
    }
}