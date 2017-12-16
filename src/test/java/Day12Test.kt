import kotlin.test.assertEquals

internal class Day12Test {
    @org.junit.jupiter.api.Test
    fun sameDirection() {
        val day12: Day12 = Day12()
        val programs = day12.countProgramsInGroup("/Users/Thunderbird/bbarbour/projects/AdventCoder/src/main/resources/day12sample.input")
        assertEquals(6, programs)
    }

    @org.junit.jupiter.api.Test
    fun runPart1() {
        val day12: Day12 = Day12()
        val programs = day12.countProgramsInGroup("/Users/Thunderbird/bbarbour/projects/AdventCoder/src/main/resources/day12.input")
        assertEquals(239, programs)
    }

    @org.junit.jupiter.api.Test
    fun sampleGroupCount() {
        val day12: Day12 = Day12()
        val groups = day12.countGroups("/Users/Thunderbird/bbarbour/projects/AdventCoder/src/main/resources/day12sample.input")
        assertEquals(2, groups)
    }

    @org.junit.jupiter.api.Test
    fun runPart2() {
        val day12: Day12 = Day12()
        val groups = day12.countGroups("/Users/Thunderbird/bbarbour/projects/AdventCoder/src/main/resources/day12.input")
        assertEquals(215, groups)
    }
}