package linked_list

class Doubly {
    private var head: Node? = null
    private var tail: Node? = null
    private var size: Int = 0

    fun isEmpty(): Boolean = head == null
    fun addAtFirst(item: Int) {
        val newNode = Node(item)
        if (isEmpty()) {
            tail = newNode
            head = newNode
            size++
            newNode.next = null
            newNode.perv = null
        } else {
            newNode.next = head
            newNode.perv = null
            head = newNode
            size++
        }
    }

    fun addAtLast(item: Int) {
        val newNode = Node(item)
        if (isEmpty()) {
            tail = newNode
            head = newNode
            newNode.next = null
            newNode.perv = null
            size++
        } else {
            newNode.perv = tail
            tail?.next = newNode
            newNode.next = null
            tail = newNode
            size++

        }

    }

    fun removeAtFirst() {
        if (isEmpty()) {
            println("Linked is empty")
        } else if (size == 1) {
            head = null
            tail = null
            size--
        } else {
            head = head?.next
            head?.perv = null
            size--

        }
    }

    fun removeAtLast() {
        if (isEmpty()) {
            println("Linked is empty")
        } else if (size == 1) {
            head = null
            tail = null
            size--
        } else {
            var pref: Node? = head
            var next = head?.next
            while (next != tail) {
                pref = next
                next = next?.next
            }
            pref?.next = null
            tail = pref
            size--
        }


    }

    fun addAtMid(item: Int, index: Int) {
        if (index < 0) {
            println("out of range")
            return
        }
        val newNode = Node(item)
        if (index == 0) {
            addAtFirst(item)
        } else if (index == size) {
            addAtLast(item)
        } else {
            var temp = head
            for (i in 1 until index) {
                temp = temp?.next
            }
            newNode.perv = temp
            newNode.next = temp?.next
            temp?.next = newNode
            size++

        }

    }




    fun printDoublyLinked() {
        var item = head
        while (item != null) {
            println(item.data)
            item = item.next
        }
    }




    inner class Node(val data : Int){
        var next : Node ? = null
        var perv : Node ? = null

    }
}

fun main() {
    val doubly = Doubly()
    doubly.addAtFirst(2)
    doubly.addAtFirst(6)
    doubly.addAtLast(11)
    doubly.addAtLast(99)
    doubly.addAtFirst(0)
    doubly.addAtMid(990 , 1)
    doubly.printDoublyLinked()
    println("=================================================")
    doubly.removeAtFirst()
    doubly.removeAtLast()
    doubly.printDoublyLinked()
}