package GettingFunctional

/**
 * higher order function is the concept of a function taking another function as parameter
 * or returning a function
 */
fun operation(a: Int, b: Int, opp: (Int, Int) -> Int): Int{
    return opp(a, b)
}

// * you can overload functions
fun operation(a: Int, opp: (Int) -> Int): Int{
    return opp(a)
}


fun sum(a: Int, b: Int) : Int = a+b

fun main(){
    println(operation(1,2,::sum)) //  3

    // * passing function as lambda
    println(operation(3,3){a,b ->
        a*b
    })
    //  9
}
