
import kotlin.test.assertEquals

internal class Day13Test {
    @org.junit.jupiter.api.Test
    fun sameDirection() {
        val day13: Day13 = Day13()
        val penalty = day13.movePacket("/Users/Thunderbird/bbarbour/projects/AdventCoder/src/main/resources/day13sample.input")
        assertEquals(24, penalty)
    }

    @org.junit.jupiter.api.Test
    fun runPart1() {
        val day13: Day13 = Day13()
        val penalty = day13.movePacket("/Users/Thunderbird/bbarbour/projects/AdventCoder/src/main/resources/day13.input")
        assertEquals(1632, penalty)
    }

//    @org.junit.jupiter.api.Test
//    fun calcSmallestDelay() {
//        val day13: Day13 = Day13()
//        val delay = day13.calcSmallestDelay("/Users/Thunderbird/bbarbour/projects/AdventCoder/src/main/resources/day13sample.input")
//        assertEquals(10, delay)
//    }

    @org.junit.jupiter.api.Test
    fun runPart2() {
        val day13: Day13 = Day13()
        val delay = day13.calcSmallestDelay("/Users/Thunderbird/bbarbour/projects/AdventCoder/src/main/resources/day13.input")
        assertEquals(10, delay)
    }
}