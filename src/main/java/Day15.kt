import java.math.BigInteger
import kotlin.coroutines.experimental.buildIterator

class Day15 {
    val aFactor = 16807L
    val bFactor = 48271L

    fun runGenerators(aStart: Long, bStart: Long) : Int {
        var matches = 0
        var mask = 65535L
        var aBucket = aStart
        var bBucket = bStart

        repeat (40_000_000) {
            aBucket = (aBucket * aFactor) % Int.MAX_VALUE
            bBucket = (bBucket * bFactor) % Int.MAX_VALUE

            if (aBucket and(mask) == bBucket and(mask)) {
                matches++
            }
        }

        return matches
    }

    fun runPart2Generators(aStart: Long, bStart: Long) : Int {
        var matches = 0
        var mask = 65535L
        var aBucket = aStart
        var bBucket = bStart

        repeat (5_000_000) {
            do {
                aBucket = (aBucket * aFactor) % Int.MAX_VALUE
            } while (aBucket.toInt() % 4 != 0)

            do {
                bBucket = (bBucket * bFactor) % Int.MAX_VALUE
            } while (bBucket.toInt() % 8 != 0)

            if (aBucket and(mask) == bBucket and(mask)) {
                matches++
            }
        }

        return matches
    }
}
