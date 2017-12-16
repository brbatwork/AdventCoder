


import kotlin.test.assertEquals

internal class Day11Test {
    @org.junit.jupiter.api.Test
    fun sameDirection() {
        val day11: Day11 = Day11()
        val steps = day11.woMatrix("ne,ne,ne")
        assertEquals(3, steps)
    }

    @org.junit.jupiter.api.Test
    fun twoOutThenBack() {
        val day11: Day11 = Day11()
        val steps = day11.woMatrix("ne,ne,sw,sw")
        assertEquals(0, steps)
    }

    @org.junit.jupiter.api.Test
    fun neTwiceThenSouth() {
        val day11: Day11 = Day11()
        val steps = day11.woMatrix("ne,ne,s,s")
        assertEquals(2, steps)
    }


    @org.junit.jupiter.api.Test
    fun backAndForthTwiceAndAway() {
        val day11: Day11 = Day11()
        val steps = day11.woMatrix("se,sw,se,sw,sw")
        assertEquals(3, steps)
    }

    @org.junit.jupiter.api.Test
    fun runPart1() {
        val day11: Day11 = Day11()
        val steps = day11.loadInFile("/Users/Thunderbird/bbarbour/projects/AdventCoder/src/main/resources/day11.input")
        assertEquals(759, steps)
    }

    @org.junit.jupiter.api.Test
    fun findMax() {
        val day11: Day11 = Day11()
        val steps = day11.findMax("/Users/Thunderbird/bbarbour/projects/AdventCoder/src/main/resources/day11.input")
        assertEquals(1501, steps)
    }
}