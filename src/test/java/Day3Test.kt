
import kotlin.test.assertEquals

internal class Day3Test {
    @org.junit.jupiter.api.Test

    fun sample1() {
        val day3 : Day3 = Day3()
        val result = day3.calcAccum(800,289326)
        println(result)
        assert(result > 289326)
    }


}