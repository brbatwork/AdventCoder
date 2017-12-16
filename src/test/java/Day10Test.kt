

import kotlin.test.assertEquals

internal class Day10Test {
    @org.junit.jupiter.api.Test
    fun sample1() {
        val day10: Day10 = Day10()
        val multiplied = day10.twistRope(IntArray(5, { it * 1 }), arrayOf(3, 4, 1, 5))
        assertEquals(12, multiplied)
    }

    @org.junit.jupiter.api.Test
    fun runPart1() {
        val day10: Day10 = Day10()
        val multiplied = day10.twistRope(IntArray(256, { it * 1 }), arrayOf(120, 93, 0, 90, 5, 80, 129, 74, 1, 165, 204, 255, 254, 2, 50, 113))
        assertEquals(826, multiplied)
    }

    @org.junit.jupiter.api.Test
    fun runPart2() {
        val day10 : Day10 = Day10()
        val result = day10.knotHash( IntArray(256, { it * 1 }), "120,93,0,90,5,80,129,74,1,165,204,255,254,2,50,113")
        assertEquals("", result)
    }

    @org.junit.jupiter.api.Test
    fun emptyString() {
        val day10: Day10 = Day10()
        val result = day10.knotHash(IntArray(256, { it * 1 }), "")
        assertEquals("a2582a3a0e66e6e86e3812dcb672a272", result)
    }

    @org.junit.jupiter.api.Test
    fun Aoc() {
        val day10: Day10 = Day10()
        val result = day10.knotHash(IntArray(256, { it * 1 }), "AoC 2017")
        assertEquals("33efeb34ea91902bb2f59c9920caa6cd", result)
    }

    @org.junit.jupiter.api.Test
    fun OneTwoThree() {
        val day10: Day10 = Day10()
        val result = day10.knotHash(IntArray(256, { it * 1 }), "1,2,3")
        assertEquals("3efbe78a8d82f29979031a4aa0b16a9d", result)
    }

    @org.junit.jupiter.api.Test
    fun OneTwoFour() {
        val day10: Day10 = Day10()
        val result = day10.knotHash(IntArray(256, { it * 1 }), "1,2,4")
        assertEquals("63960835bcdc130f0b66d7ff4f6a5a8e", result)
    }
}