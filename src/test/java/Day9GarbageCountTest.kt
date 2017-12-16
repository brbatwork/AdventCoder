import kotlin.test.assertEquals

internal class Day9GarbageCountTest {
    @org.junit.jupiter.api.Test
    fun noCharacters() {
        val day9 : Day9 = Day9()
        val totalScore = day9.countGarbage("<>")
        assertEquals(0, totalScore)
    }
    @org.junit.jupiter.api.Test
    fun randomChars() {
        val day9 : Day9 = Day9()
        val totalScore = day9.countGarbage("<random characters>")
        assertEquals(17, totalScore)
    }
    @org.junit.jupiter.api.Test
    fun nestedGarbage() {
        val day9 : Day9 = Day9()
        val totalScore = day9.countGarbage("<<<<>")
        assertEquals(3, totalScore)
    }
    @org.junit.jupiter.api.Test
    fun escapesInGarbage() {
        val day9 : Day9 = Day9()
        val totalScore = day9.countGarbage("<{!>}>")
        assertEquals(2, totalScore)
    }
    @org.junit.jupiter.api.Test
    fun noCountBangs() {
        val day9 : Day9 = Day9()
        val totalScore = day9.countGarbage("<!!>")
        assertEquals(0, totalScore)
    }
    @org.junit.jupiter.api.Test
    fun moreBangChecks() {
        val day9 : Day9 = Day9()
        val totalScore = day9.countGarbage("<!!!>>")
        assertEquals(0, totalScore)
    }
    @org.junit.jupiter.api.Test
    fun moreBoundaryChecks() {
        val day9 : Day9 = Day9()
        val totalScore = day9.countGarbage("<{o\"i!a,<{i<a>")
        assertEquals(10, totalScore)
    }
    @org.junit.jupiter.api.Test
    fun accumGarbage() {
        val day9 : Day9 = Day9()
        val totalScore = day9.countGarbage("<one><one><one>")
        assertEquals(9, totalScore)
    }
    @org.junit.jupiter.api.Test
    fun runPart2() {
        val day9 : Day9 = Day9()
        val totalScore = day9.countGarbageInFile("/Users/Thunderbird/bbarbour/projects/AdventCoder/src/main/resources/day9.input")
        assertEquals(0, totalScore)
    }
}