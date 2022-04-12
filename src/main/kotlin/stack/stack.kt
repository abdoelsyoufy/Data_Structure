package stack

/*
* last in first out
* apps on stack
* ctrl + z
* arrow back
* */
class CustomStack(private val size: Int) {

    private val stackItems: Array<Int>
    private var top: Int

    init {
        this.stackItems = Array<Int>(size, { 0 })
        top = -1
    }


    fun push(item: Int): Boolean {
        if (top == size - 1) {
            print("Stack is full ")
            return false
        } else {
            stackItems[++top] = item
            return true
        }
    }

    fun pop(): Int {

        if (top == -1) {
            print("Stack is Empty ")
            return -1
        } else {
            return stackItems[top--]
        }
    }

    fun isEmpty(): Boolean = top == -1

    fun top(): Int {
        if (!isEmpty()) {
            print("top of stack :  ")

            return stackItems[top]
        } else {
            print("stack is empty ")
            return -1
        }
    }

}


class MinStack() {

    private val stackItems: ArrayList<Int>
    private var top: Int

    init {
        this.stackItems = arrayListOf<Int>()
        top = -1
    }

    fun push(item: Int) =  stackItems.add(++top , item)

    fun pop() {
        top = top -1
    }

    fun top(): Int =  stackItems[top]

    fun getMin():Int{
        var min = stackItems[top]

       for(index in 0 until top){
           if (stackItems[index] < min ) min = stackItems[index]
       }
        return min
    }

}

fun main() {
    val stack = CustomStack(3)
    println(stack.push(1))
    println(stack.push(2))
    println(stack.push(3))
    println(stack.push(4))

    println(stack.isEmpty())
    println(stack.top())

    println(stack.pop())
    println(stack.pop())
    println(stack.pop())
    println(stack.pop())

    println(stack.isEmpty())
    println(stack.top())
}