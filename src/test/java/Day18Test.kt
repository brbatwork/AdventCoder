

import kotlin.test.assertEquals

internal class Day18Test {
//    @org.junit.jupiter.api.Test
//    fun sample1() {
//        val day18 = Day18()
//        val result =  day18.runDuet("/Users/Thunderbird/bbarbour/projects/AdventCoder/src/main/resources/day18sample.input")
//        assertEquals(4, result)
//    }

//    @org.junit.jupiter.api.Test
//    fun runPart1() {
//        val day18 = Day18()
//        val result =  day18.runDuet("/Users/Thunderbird/bbarbour/projects/AdventCoder/src/main/resources/day18.input")
//        assertEquals(4, result)
//    }

    @org.junit.jupiter.api.Test
    fun samplePart2() {
        val day18 = Day18()
        val result =  day18.runPart2("/Users/Thunderbird/bbarbour/projects/AdventCoder/src/main/resources/day18sample.input")
        assertEquals(3, result)
    }

    @org.junit.jupiter.api.Test
    fun runPart2() {
        val day18 = Day18()
        val result =  day18.runPart2("/Users/Thunderbird/bbarbour/projects/AdventCoder/src/main/resources/day18.input")
        assertEquals(3, result)
    }

}
