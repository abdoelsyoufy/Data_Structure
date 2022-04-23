package queue


fun higherOrder(num1 : Int , operation : (num : Int) -> Unit){
    operation(num1)
}

fun higherOrder(num1 : Int , num2 :Int, operation : (num1 : Int , num2 : Int) -> Int){
    println(operation(num1, num2))
}

fun higherOrder(vararg  num : Int ,operation : () -> Unit){
}

fun main() {
    higherOrder(10 , ::operation)
    higherOrder(15,10 , {a ,b -> a *b})
    higherOrder {-> println("Hi")}
}

fun operation(num:Int){
    println("the num is : ${num * 2}")
}