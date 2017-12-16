

import kotlin.test.assertEquals

internal class Day7Test {
    @org.junit.jupiter.api.Test
    fun sample1() {
        val day6 : Day7 = Day7()
        val result = day6.runPart1("/Users/Thunderbird/bbarbour/projects/AdventCoder/src/main/resources/day7sample.input")
        assertEquals("tknk", result)
    }

    @org.junit.jupiter.api.Test
    fun part1() {
        val day6 : Day7 = Day7()
        val result = day6.runPart1("/Users/Thunderbird/bbarbour/projects/AdventCoder/src/main/resources/day7.input")
        assertEquals("eqgvf", result)
    }

    @org.junit.jupiter.api.Test
    fun sample2() {
        val day6 : Day7 = Day7()
        val result = day6.runPart2("/Users/Thunderbird/bbarbour/projects/AdventCoder/src/main/resources/day7sample.input")
        assertEquals(60, result)
    }

    @org.junit.jupiter.api.Test
    fun runPart2() {
        val day6 : Day7 = Day7()
        val result = day6.runPart2("/Users/Thunderbird/bbarbour/projects/AdventCoder/src/main/resources/day7.input")
        assertEquals(60, result)
    }
}
