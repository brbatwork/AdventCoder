
import kotlin.test.assertEquals

internal class Day6Test {
    @org.junit.jupiter.api.Test
    fun sample1() {
        val day6 : Day6 = Day6()
        val result = day6.runSample1()
        assertEquals(5, result)
    }

    @org.junit.jupiter.api.Test
    fun solveSample1() {
        val day6 : Day6 = Day6()
        val result = day6.solveSample1()
        assertEquals(12841, result)
    }

    @org.junit.jupiter.api.Test
    fun sample2() {
        val day6 : Day6 = Day6()
        val result = day6.runSample2()
        assertEquals(4, result)
    }

    @org.junit.jupiter.api.Test
    fun solveSample2() {
        val day6 : Day6 = Day6()
        val result = day6.solveSample2()
        assertEquals(8038, result)
    }
}