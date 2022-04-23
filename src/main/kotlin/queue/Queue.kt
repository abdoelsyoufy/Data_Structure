package queue

class Queue<T>() {

    private var front: Int
    private var rear: Int
    private val queueItems : ArrayList<T>

    init {
        front = -1
        rear = -1
        queueItems = arrayListOf()
    }

    fun isEmpty():Boolean = front == -1 || front > rear

    fun enQueue(item : T){
        if (front==-1){
            front = 0
        }
        rear+=1
        queueItems.add(rear,item)
    }

    fun deQueue():Boolean{
        if (isEmpty()){
            return false
        }else{
            front++
            return true
        }
    }

    fun printQueue(){
       if (!isEmpty()){
           for (index in front ..rear){
               println(queueItems[index])
           }
       }
    }

}

fun main() {

    val queue = Queue<Int>()
    queue.enQueue(3)
    queue.enQueue(5)
    queue.enQueue(77)
    queue.printQueue()
    queue.deQueue()
    queue.deQueue()
    queue.deQueue()
    queue.deQueue()
    queue.printQueue()

}