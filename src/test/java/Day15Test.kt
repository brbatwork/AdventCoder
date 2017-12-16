import kotlin.test.assertEquals

internal class Day15Test {
    @org.junit.jupiter.api.Test
    fun sample1() {
        val Day15: Day15 = Day15()
        val matches = Day15.runGenerators(65, 8921)
        assertEquals(588, matches)
    }

    @org.junit.jupiter.api.Test
    fun runPart1() {
        val Day15: Day15 = Day15()
        val matches = Day15.runGenerators(634, 301)
        assertEquals(573, matches)
    }

    @org.junit.jupiter.api.Test
    fun runPart2() {
        val Day15: Day15 = Day15()
        val matches = Day15.runPart2Generators(634, 301)
        assertEquals(294, matches)
    }
}
