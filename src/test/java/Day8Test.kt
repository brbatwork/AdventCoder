import kotlin.test.assertEquals

internal class Day8Test {
    @org.junit.jupiter.api.Test
    fun sample1() {
        val day8 : Day8 = Day8()
        val largestValue = day8.runPart1("/Users/Thunderbird/bbarbour/projects/AdventCoder/src/main/resources/day8sample1.input")
        assertEquals(1, largestValue)
    }

    @org.junit.jupiter.api.Test
    fun runPart1() {
        val day8 : Day8 = Day8()
        val largestValue = day8.runPart1("/Users/Thunderbird/bbarbour/projects/AdventCoder/src/main/resources/day8.input")
        assertEquals(8022, largestValue)
    }

    @org.junit.jupiter.api.Test
    fun sample2() {
        val day8 : Day8 = Day8()
        val largestValue = day8.runPart2("/Users/Thunderbird/bbarbour/projects/AdventCoder/src/main/resources/day8sample1.input")
        assertEquals(10, largestValue)
    }

    @org.junit.jupiter.api.Test
    fun runPart2() {
        val day8 : Day8 = Day8()
        val largestValue = day8.runPart2("/Users/Thunderbird/bbarbour/projects/AdventCoder/src/main/resources/day8.input")
        assertEquals(10, largestValue)
    }
}
