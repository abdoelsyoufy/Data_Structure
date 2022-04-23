package queue

class CircleQueue(private val size: Int) {

    private var front: Int
    private var rear: Int
    private var length: Int
    private val queueItems: Array<Int>

    init {
        front = 0
        rear = -1
        length = 0
        queueItems = Array(size, { 0 })
    }

    fun isEmpty(): Boolean = length == 0
    fun isFull(): Boolean = length == size

    fun enQueue(item: Int) {
        if (isFull()) {
            println("Queue is full")
        } else {
            rear = (rear + 1) % size
            queueItems[rear] = item
            length++
        }

    }

    fun deQueue(): Boolean {
        if (isEmpty()) {
            return false
        } else {
            front = (front + 1) % size
            length--
            return true
        }
    }

    fun printQueue() {
        if (!isEmpty()) {
            var index = front
            while (index != rear ) {
                println(queueItems[index])
                index = (index + 1) % size
            }
            println(queueItems[rear])
        }
    }

    fun length(): Int = length

    fun front() : Int {
        if (!isEmpty()){
            return queueItems[front]
        }else{
            print("Queue is empty ")
            return -1
        }
    }

    fun rear() : Int {
        if (!isEmpty()){
            return queueItems[rear]
        }else{
            print("Queue is empty ")
            return -1
        }
    }

}

fun main() {
    val circleQueue = CircleQueue(4)
    circleQueue.enQueue(1)
    circleQueue.enQueue(2)
    circleQueue.enQueue(3)
    circleQueue.enQueue(4)
    println("the length is " + circleQueue.length())
    circleQueue.printQueue()
    circleQueue.deQueue()
    circleQueue.deQueue()
    circleQueue.deQueue()
    circleQueue.enQueue(33)
    circleQueue.enQueue(55)
    println("------------------------------\n")
    circleQueue.printQueue()
    println("------------------------------\n")
    println("front " +circleQueue.front())
    println("rear " + circleQueue.rear())


}