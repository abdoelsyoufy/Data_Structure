package stack

import LinkedStack
import java.util.*

class Balanced {
    val stack = LinkedStack<Char>()
    fun arePair(open: Char, close: Char): Boolean {
        return if (open == '(' && close == ')') true
        else if (open == '{' && close == '}') true
        else open == '[' && close == ']'

    }

    fun areBalanced(expression: String): Boolean {

        expression.forEach { char: Char ->

            if (char == '(' || char == '{' || char == '[') stack.push(char)
            else if (char == ')' || char == '}' || char == ']') {
                if (!stack.isEmpty() && arePair(stack.top()!!, char)) {
                    stack.pop()
                } else {
                    return false
                }
            }
        }

        return stack.isEmpty()

    }

}

fun main() {

//    val balanced = Balanced()
//    val exp = readLine("Enter expression")
//    println(balanced.areBalanced(exp!!))


}

fun readLine(s: String): String? {
    println(s)
    return readLine()
}

fun isValid(s: String): Boolean {

    val  stack = Stack<Char>()
    s.forEach { char: Char ->

        if (char == '(' || char == '{' || char == '[') stack.push(char)
        else if (char == ')' || char == '}' || char == ']') {
            if (!stack.isEmpty() && arePair(stack.peek()!!, char)) {
                stack.pop()
            } else {
                return false
            }
        }
    }

    return stack.isEmpty()
}

fun arePair(open: Char, close: Char): Boolean {
    return if (open == '(' && close == ')') true
    else if (open == '{' && close == '}') true
    else open == '[' && close == ']'

}
