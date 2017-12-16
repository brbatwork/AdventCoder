
import kotlin.test.assertEquals

internal class Day9Test {
    @org.junit.jupiter.api.Test
    fun oneLevel() {
        val day9 : Day9 = Day9()
        val totalScore = day9.countGroups("{}")
        assertEquals(1, totalScore)
    }

    @org.junit.jupiter.api.Test
    fun threeLevels() {
        val day9 : Day9 = Day9()
        val totalScore = day9.countGroups("{{{}}}")
        assertEquals(6, totalScore)
    }

    @org.junit.jupiter.api.Test
    fun twoPairs() {
        val day9 : Day9 = Day9()
        val totalScore = day9.countGroups("{{},{}}")
        assertEquals(5, totalScore)
    }

    @org.junit.jupiter.api.Test
    fun threePairs() {
        val day9 : Day9 = Day9()
        val totalScore = day9.countGroups("{{{},{},{{}}}}")
        assertEquals(16, totalScore)
    }

    @org.junit.jupiter.api.Test
    fun gargabe() {
        val day9 : Day9 = Day9()
        val totalScore = day9.countGroups("{<a>,<a>,<a>,<a>}")
        assertEquals(1, totalScore)
    }

    @org.junit.jupiter.api.Test
    fun abGrabage() {
        val day9 : Day9 = Day9()
        val totalScore = day9.countGroups("{{<ab>},{<ab>},{<ab>},{<ab>}}")
        assertEquals(9, totalScore)
    }

    @org.junit.jupiter.api.Test
    fun ignoredGarbage() {
        val day9 : Day9 = Day9()
        val totalScore = day9.countGroups("{{<!!>},{<!!>},{<!!>},{<!!>}}")
        assertEquals(9, totalScore)
    }

    @org.junit.jupiter.api.Test
    fun moreGarbage() {
        val day9 : Day9 = Day9()
        val totalScore = day9.countGroups("{{<a!>},{<a!>},{<a!>},{<ab>}}")
        assertEquals(3, totalScore)
    }

    @org.junit.jupiter.api.Test
    fun runPart1() {
        val day9 : Day9 = Day9()
        val totalScore = day9.countGroupsInFile("/Users/Thunderbird/bbarbour/projects/AdventCoder/src/main/resources/day9.input")
        assertEquals(0, totalScore)
    }
}