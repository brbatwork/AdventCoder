class Instruction(instruction: String) {
    val parts = instruction.split(" ")
    val register = parts[0]
    val operator = parts[1]
    val amount = parts[2].toInt()
    val cond_left = parts[4]
    val cond_op = parts[5]
    val cond_right = parts[6].toInt()

    fun execute(existing_val: Int) : Int {
        var result = existing_val

        if (operator == "inc") {
            result += amount
        } else {
            result -= amount
        }
        return result
    }

    fun shouldExecute(existing_val: Int) : Boolean {
        if (cond_op == ">")
            return existing_val > cond_right

        if (cond_op == ">=")
            return existing_val >= cond_right

        if (cond_op == "<")
            return existing_val < cond_right

        if (cond_op == "<=")
            return existing_val <= cond_right

        if (cond_op == "!=")
            return existing_val != cond_right

        return existing_val == cond_right
    }


}
