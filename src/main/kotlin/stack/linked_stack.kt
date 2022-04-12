// create node class for linked_stack
data class Node<T>(val data: T?) {
    var next: Node<T>?

    init {
        next = null
    }
}

class LinkedStack<T> {
   private var top: Node<T>? = null

    fun isEmpty(): Boolean = top == null

    fun printLinkedStack() {
        if (isEmpty()) {
            println("linked stack is empty..")
        } else {
            var temp = top
            while (temp != null) {
                println(temp.data)
                temp = temp.next
            }
        }
    }

    fun push(item: T) {
        val node = Node(item)
        node.next = top
        top = node
    }

    fun pop() {
        if (top != null) {
            println("you removed $top")
            top = top?.next
        }else{
            println("linked stack is empty")
        }

    }

    fun top():T? = top?.data

}

fun main() {
    val linkedStack = LinkedStack<Int>()
    linkedStack.push(12)
    linkedStack.push(13)
    linkedStack.push(14)
    linkedStack.push(15)
    linkedStack.push(16)
    linkedStack.push(17)
    linkedStack.printLinkedStack()
    linkedStack.pop()
    linkedStack.printLinkedStack()
    println(linkedStack.top())
    linkedStack.pop()
    linkedStack.pop()
    linkedStack.pop()
    linkedStack.pop()
    linkedStack.pop()
    linkedStack.pop()
    linkedStack.printLinkedStack()
    println(linkedStack.top())


}

