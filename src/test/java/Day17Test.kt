
import kotlin.test.assertEquals

internal class Day17Test {
    @org.junit.jupiter.api.Test
    fun sample1() {
        val day17 = Day17()
        val result = day17.runSpinLock(3, 2017, 2017)
        assertEquals(638, result)
    }

    @org.junit.jupiter.api.Test
    fun runPart1() {
        val day17 = Day17()
        val result = day17.runSpinLock(348, 2017, 2017)
        assertEquals(417, result)
    }

    @org.junit.jupiter.api.Test
    fun runPart2() {
        val day17 = Day17()
        val result = day17.fasterSpin(348, 50_000_000, 0)
        assertEquals(34334221, result)
    }
}
