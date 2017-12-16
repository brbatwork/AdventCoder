import java.util.Objects

class ProgramNode(name:String, weight:Int){
    var name:String = name
    var weight:Int = weight
    var parent:ProgramNode? = null
    var children:MutableList<ProgramNode> = mutableListOf()

    fun addChild(node:ProgramNode){
        children.add(node)
        node.parent = this
    }

    fun updateParent(needle:String) : ProgramNode? {
        var found : ProgramNode? = null

        for (child in this.children) {
            if (child.name == needle) {
                this.children.remove(child)
                return child
            } else {
                found = child.updateParent(needle)
            }

            if (found != null) return found
        }

        return found
    }

    fun updateExistingWeight(needle:String, weight: Int) : ProgramNode? {
        var found : ProgramNode? = null

        for (child in this.children) {
            if (child.name == needle) {
                child.weight = weight
                return child
            } else {
                found =  child.updateExistingWeight(needle, weight)
            }

            if (found != null) return found
        }

        return found
    }


    fun totalWeight() : Int {
        var total = this.weight

        for (child in this.children) {
            total += child.totalWeight()
        }

        return total
    }


    override fun toString(): String {
        var s = "${name} ($weight)"
        if (!children.isEmpty()) {
            s += "\n\t{" + children.map { it.toString() } + " } ::: "
        }
        return s
    }

    override fun equals(other: Any?) : Boolean {
        val progOther = other as ProgramNode
        return (this.name == progOther.name)
    }

    override fun hashCode(): Int {
        return Objects.hash(name)
    }
}