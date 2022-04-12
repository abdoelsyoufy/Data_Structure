package stack

class ConvertExpression {

    fun priority(op: Char): Int {
        when (op) {
            '+', '-' -> return 0
            '*', '/' -> return 1
            else -> return -1
        }
    }

    fun toPostFix(exp: String) {

        exp.forEach { char : Char ->
            if (char.isDigit()){

            }
        }

    }
}