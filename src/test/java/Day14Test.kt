

import kotlin.test.assertEquals

internal class Day14Test {
    @org.junit.jupiter.api.Test
    fun sameDirection() {
        val Day14: Day14 = Day14()
        val filledSquares = Day14.defrag("flqrgnkx")
        assertEquals(8108, filledSquares)
    }

    @org.junit.jupiter.api.Test
    fun runPart1() {
        val Day14: Day14 = Day14()
        val filledSquares = Day14.defrag("xlqgujun")
        assertEquals(8204, filledSquares)
    }

    @org.junit.jupiter.api.Test
    fun countRegions() {
        val Day14: Day14 = Day14()
        val regions = Day14.countRegionsBFS("flqrgnkx")
        assertEquals(1242, regions)
    }
    @org.junit.jupiter.api.Test
    fun countRegions2() {
        val Day14: Day14 = Day14()
        val regions = Day14.countRegionsBFS("xlqgujun")
        assertEquals(1089, regions)
    }
}