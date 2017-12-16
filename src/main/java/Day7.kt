import org.jetbrains.annotations.Mutable
import java.io.File
import java.io.InputStream

class Day7 {
    fun runPart1(path: String) : String {
        val inStream : InputStream = File(path).inputStream()
        val linelist = mutableListOf<String>()
        inStream.bufferedReader().useLines { lines -> lines.forEach { linelist.add(it)}}
        val children: MutableList<String> = mutableListOf<String>()
        val programs: MutableList<String> = mutableListOf<String>()

        linelist.forEach { it:String ->
            val lpLoc = it.indexOf('(')
            val gtLoc = it.indexOf('>')
            val name = it.substring(0, lpLoc - 1).trim()

            if (gtLoc > 0) {
                it.substring(gtLoc + 1).split(",").map { child : String -> children.add( child.trim())}
            }
            programs.add(name)
        }

        var result = ""

        programs.forEach { program : String ->
            val found: List<String> = children.filter { c : String -> c == program}
            if (found.isEmpty()) {
                result = program
            }
        }

        return result
    }

    fun runPart2(path: String) : Int {
        val inStream : InputStream = File(path).inputStream()
        val linelist = mutableListOf<String>()
        inStream.bufferedReader().useLines { lines -> lines.forEach { linelist.add(it)}}
        val root = ProgramNode("root", 0)
        val firstLevelWeights : MutableMap<ProgramNode, Int> = mutableMapOf()

        linelist.forEach { it:String ->
            val lpLoc = it.indexOf('(')
            val rpLoc = it.indexOf(')')
            val gtLoc = it.indexOf('>')
            val name = it.substring(0, lpLoc - 1).trim()
            val weight = it.substring(lpLoc + 1, rpLoc).trim().toInt()
            val children: MutableList<String> = mutableListOf()

            if (gtLoc > 0) {
                it.substring(gtLoc + 1).split(",").map { child : String -> children.add(child.trim()) }
            }

            var currentNode = ProgramNode(name,weight)
            val existingNode = root.updateExistingWeight(currentNode.name, currentNode.weight)

            if (existingNode != null)
                currentNode = existingNode

            children.forEach { ch ->
                val found = root.updateParent(ch)
                if (found != null) {
                    found.parent = currentNode
                    currentNode.addChild(found)
                } else {
                    currentNode.addChild(ProgramNode(ch, -1))
                }
            }


            if (existingNode == null) {
                root.addChild(currentNode)
            }
        }

        val startNode = root.children.first()

        for (child in startNode.children) {
            firstLevelWeights[child] = child.totalWeight()
        }

        var max = drillDownBalances(firstLevelWeights)

        for (i in 0..1000) {
            firstLevelWeights.clear()
            for (child in max!!.children) {
                firstLevelWeights[child] = child.totalWeight()
            }
            max = drillDownBalances(firstLevelWeights)
        }

        return 0
    }

    fun drillDownBalances(weights: MutableMap<ProgramNode, Int>) : ProgramNode? {
        var min : Pair<ProgramNode, Int> = Pair(ProgramNode("",0), Int.MAX_VALUE)
        var max : Pair<ProgramNode, Int> = Pair(ProgramNode("",0), 0)

        for ((k,v) in weights) {
            if (v <= min.second) {
                min = Pair(k,v)
            }
            if (v >= max.second) {
                max = Pair(k,v)
            }
        }
        for ((k,v) in weights) { println("${k.name} = $v") }
        return max.first
    }
}
