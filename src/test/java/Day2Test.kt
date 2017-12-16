import kotlin.test.assertEquals

internal class Day2Test {
    @org.junit.jupiter.api.Test
    fun solved() {
        var matrix = Array(16, {IntArray(size = 16)})
        matrix[0] = intArrayOf(3458,3471,163,1299,170,4200,2425,167,3636,4001,4162,115,2859,130,4075,4269)
        matrix[1] = intArrayOf(2777,2712,120,2569,2530,3035,1818,32,491,872,113,92,2526,477,138,1360)
        matrix[2] = intArrayOf(2316,35,168,174,1404,1437,2631,1863,1127,640,1745,171,2391,2587,214,193)
        matrix[3] = intArrayOf(197,2013,551,1661,121,206,203,174,2289,843,732,2117,360,1193,999,2088)
        matrix[4] = intArrayOf(3925,3389,218,1134,220,171,1972,348,3919,3706,494,3577,3320,239,120,2508)
        matrix[5] = intArrayOf(239,947,1029,2024,733,242,217,1781,2904,2156,1500,3100,497,2498,3312,211)
        matrix[6] = intArrayOf(188,3806,3901,261,235,3733,3747,3721,267,3794,3814,3995,3004,915,4062,3400)
        matrix[7] = intArrayOf(918,63,2854,2799,178,176,1037,487,206,157,2212,2539,2816,2501,927,3147)
        matrix[8] = intArrayOf(186,194,307,672,208,351,243,180,619,749,590,745,671,707,334,224)
        matrix[9] = intArrayOf(1854,3180,1345,3421,478,214,198,194,4942,5564,2469,242,5248,5786,5260,4127)
        matrix[10] = intArrayOf(3780,2880,236,330,3227,1252,3540,218,213,458,201,408,3240,249,1968,2066)
        matrix[11] = intArrayOf(1188,696,241,57,151,609,199,765,1078,976,1194,177,238,658,860,1228)
        matrix[12] = intArrayOf(903,612,188,766,196,900,62,869,892,123,226,57,940,168,165,103)
        matrix[13] = intArrayOf(710,3784,83,2087,2582,3941,97,1412,2859,117,3880,411,102,3691,4366,4104)
        matrix[14] = intArrayOf(3178,219,253,1297,3661,1552,8248,678,245,7042,260,581,7350,431,8281,8117)
        matrix[15] = intArrayOf(837,80,95,281,652,822,1028,1295,101,1140,88,452,85,444,649,1247)

        val day2 : Day2 = Day2()
        val result = day2.checksum(matrix)

        assertEquals(51139, result)
    }

    @org.junit.jupiter.api.Test
    fun sample1() {
        var matrix = Array(3, {IntArray(size = 4)})
        val row1  = intArrayOf(5,1,9,5)
        val row2  = intArrayOf(7, 5, 3)
        val row3  = intArrayOf(2, 4, 6, 8)
        matrix[0] = row1
        matrix[1] = row2
        matrix[2] = row3

        val day2 : Day2 = Day2()
        val result = day2.checksum(matrix)

        assertEquals(18, result)
    }

    @org.junit.jupiter.api.Test
    fun sample2() {
        var matrix = Array(3, {IntArray(size = 4)})
        val row1  = intArrayOf(5,9, 2, 8)
        val row2  = intArrayOf(9,4,7,3)
        val row3  = intArrayOf(3,8,6,5)
        matrix[0] = row1
        matrix[1] = row2
        matrix[2] = row3

        val day2 : Day2 = Day2()
        val result = day2.divisor(matrix)

        assertEquals(9, result)
    }

    @org.junit.jupiter.api.Test
    fun solved2() {
        var matrix = Array(16, {IntArray(size = 16)})
        matrix[0] = intArrayOf(3458,3471,163,1299,170,4200,2425,167,3636,4001,4162,115,2859,130,4075,4269)
        matrix[1] = intArrayOf(2777,2712,120,2569,2530,3035,1818,32,491,872,113,92,2526,477,138,1360)
        matrix[2] = intArrayOf(2316,35,168,174,1404,1437,2631,1863,1127,640,1745,171,2391,2587,214,193)
        matrix[3] = intArrayOf(197,2013,551,1661,121,206,203,174,2289,843,732,2117,360,1193,999,2088)
        matrix[4] = intArrayOf(3925,3389,218,1134,220,171,1972,348,3919,3706,494,3577,3320,239,120,2508)
        matrix[5] = intArrayOf(239,947,1029,2024,733,242,217,1781,2904,2156,1500,3100,497,2498,3312,211)
        matrix[6] = intArrayOf(188,3806,3901,261,235,3733,3747,3721,267,3794,3814,3995,3004,915,4062,3400)
        matrix[7] = intArrayOf(918,63,2854,2799,178,176,1037,487,206,157,2212,2539,2816,2501,927,3147)
        matrix[8] = intArrayOf(186,194,307,672,208,351,243,180,619,749,590,745,671,707,334,224)
        matrix[9] = intArrayOf(1854,3180,1345,3421,478,214,198,194,4942,5564,2469,242,5248,5786,5260,4127)
        matrix[10] = intArrayOf(3780,2880,236,330,3227,1252,3540,218,213,458,201,408,3240,249,1968,2066)
        matrix[11] = intArrayOf(1188,696,241,57,151,609,199,765,1078,976,1194,177,238,658,860,1228)
        matrix[12] = intArrayOf(903,612,188,766,196,900,62,869,892,123,226,57,940,168,165,103)
        matrix[13] = intArrayOf(710,3784,83,2087,2582,3941,97,1412,2859,117,3880,411,102,3691,4366,4104)
        matrix[14] = intArrayOf(3178,219,253,1297,3661,1552,8248,678,245,7042,260,581,7350,431,8281,8117)
        matrix[15] = intArrayOf(837,80,95,281,652,822,1028,1295,101,1140,88,452,85,444,649,1247)

        val day2 : Day2 = Day2()
        val result = day2.divisor(matrix)

        assertEquals(272, result)
    }
}