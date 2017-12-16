
import kotlin.test.assertEquals

internal class Day16Test {
//    @org.junit.jupiter.api.Test
//    fun sample1() {
//        val day16: Day16 = Day16(5)
//        val dances = day16.dance("/Users/Thunderbird/bbarbour/projects/AdventCoder/src/main/resources/day16sample.input")
//        assertEquals("baedc", dances)
//    }
//
//    @org.junit.jupiter.api.Test
//    fun runPart1() {
//        val day16: Day16 = Day16(16)
//        val dances = day16.dance("/Users/Thunderbird/bbarbour/projects/AdventCoder/src/main/resources/day16.input")
//        assertEquals("kpbodeajhlicngmf", dances)
//    }

    @org.junit.jupiter.api.Test
    fun runPart2() {
        val day16: Day16 = Day16(16)
        val dances = day16.danceMany("/Users/Thunderbird/bbarbour/projects/AdventCoder/src/main/resources/day16.input", 1_000_000_000)
        assertEquals("baedc", dances)
    }

}
