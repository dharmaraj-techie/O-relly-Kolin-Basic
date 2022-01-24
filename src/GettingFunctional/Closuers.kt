package GettingFunctional

fun outSideFunction(){
    val number = 10

    // * here inside lambda the number is used which is declared outside the function
    // * this is called closures

    operation(20) { x -> x  * number }

    for (n in 1..30){
        operation(20) { x ->
            println(n)
            // * here n is the closure
            // * in other languages when it's captured for the first time it stays the same
            // * it won't but in kotlin it's different

            x  * n
        }
    }

    /**
     * this is also a function declared inside a function a
     * and you can see here that the number is also used here
     */
    fun insideFun(): Int{
       return number + 10
    }
}

fun main(){
    outSideFunction()
}
