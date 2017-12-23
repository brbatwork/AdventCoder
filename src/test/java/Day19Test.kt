import kotlin.test.assertEquals

internal class Day19Test {
    @org.junit.jupiter.api.Test
    fun sample1() {
        val day19 = Day19()
        val result =  day19.walkPath("/Users/Thunderbird/bbarbour/projects/AdventCoder/src/main/resources/day19sample.input")
        assertEquals("ABCDEF", result.first)
    }

    @org.junit.jupiter.api.Test
    fun testPart1() {
        val day19 = Day19()
        val result =  day19.walkPath("/Users/Thunderbird/bbarbour/projects/AdventCoder/src/main/resources/day19.input")
        assertEquals("UICRNSDOK", result.first)
    }

    @org.junit.jupiter.api.Test
    fun sample2() {
        val day19 = Day19()
        val result =  day19.walkPath("/Users/Thunderbird/bbarbour/projects/AdventCoder/src/main/resources/day19sample.input")
        assertEquals(38, result.second)
    }

    @org.junit.jupiter.api.Test
    fun testPart2() {
        val day19 = Day19()
        val result =  day19.walkPath("/Users/Thunderbird/bbarbour/projects/AdventCoder/src/main/resources/day19.input")
        assertEquals(38, result.second)
    }

}
