import java.util.*

class Day6() {
    var banks : Array<Int>
    var history : ArrayList<Array<Int>>

    init {
        this.banks = arrayOf(4,10,4,1,8,4,9,14,5,1,14,15,0,15,3,5)
        this.history = ArrayList<Array<Int>>()
    }

    fun runSample1() : Int {
        this.banks = arrayOf(0,2,7,0)
        return defragBanks()
    }

    fun solveSample1() : Int {
        return defragBanks()
    }

    fun runSample2() : Int {
        this.banks = arrayOf(0,2,7,0)
        var count = 0
        defragBanks()
        val needle = this.history.get(this.history.size - 1)
        this.history.clear()
        this.history.add(needle)
        return defragBanks() + 1
    }

    fun solveSample2() : Int {
        var count = 0
        defragBanks()
        val needle = this.history.get(this.history.size - 1)
        this.history.clear()
        this.history.add(needle)
        return defragBanks() + 1
    }
    fun defragBanks() : Int {
        var startBank = getLargestBank()
        var currentCount = 0

        while (!seenBefore()) {
            var blocksToDefrag = this.banks[startBank]
            this.banks[startBank] = 0
            var nextBank = startBank + 1

            while (blocksToDefrag > 0) {
                if (nextBank > this.banks.size - 1) {
                    nextBank = 0
                }
                val bankValue = this.banks[nextBank]
                this.banks[nextBank] = bankValue + 1
                blocksToDefrag--
                nextBank++
            }
            startBank = getLargestBank()
            currentCount++
        }

        return currentCount
    }

    fun getLargestBank() : Int {
        val largestNumOBlocks = this.banks.max()
        var largestIndex = 0

        for (i in this.banks.indices) {
            if (this.banks[i] == largestNumOBlocks) {
                largestIndex = i
                break
            }
        }

        return largestIndex
    }

    fun seenBefore() : Boolean {
        for (ar in this.history) {
            if (Arrays.equals(ar, this.banks)) {
                return true
            }
        }
        this.history.add(this.banks.copyOf())
        return false
    }
}