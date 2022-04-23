package linked_list

class Singly {

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
        } else {
            newNode.next = head
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
            size++
        } else {
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
            newNode.next = temp?.next
            temp?.next = newNode
            size++

        }

    }

    fun removeAtMid(index: Int) {
        if (index < 0) {
            println("out of range")
        }
        if (index == 0) {
            removeAtFirst()
        } else if (index == size) {
            removeAtLast()
        } else {
            var pref: Node? = head
            var next = head?.next
            for (i in 1 until index) {
                pref = next
                next = next?.next
            }
            pref?.next = next?.next
            tail = pref
            size--

        }

    }


    fun printSinglyLinked() {
        var item = head
        while (item != null) {
            println(item.data)
            item = item.next
        }
    }

    fun getLength(): Int = size

    fun search(element: Int) {
        var start = head
        while (start != null && start.data != element) {
            start = start.next
        }
        if (start == null) {
            println("not founded")
        } else {
            println("element ${start.data} founded ")
        }
    }

    fun revers(){
        var current = head
        var pervious : Node ?= null
        var next = current

        while (next!=null){
            next = current?.next
            current?.next = pervious
            pervious = current
            current = next
        }
        head = pervious
    }

    inner class Node(val data: Int) {
        var next: Node? = null
    }

}

fun main() {
    val singly = Singly()
    singly.addAtFirst(1)
    singly.addAtLast(55)
    singly.addAtLast(33)
    singly.addAtMid(10, 1)
    singly.addAtFirst(120)
    singly.addAtMid(400, 3)


    println("the length is ${singly.getLength()}")

    singly.printSinglyLinked()

    singly.search(600)

    singly.removeAtMid(2)
    println("--------------------------")
    singly.printSinglyLinked()
    singly.revers()
    singly.addAtLast(96)
    println("--------------------------")
    singly.printSinglyLinked()


}