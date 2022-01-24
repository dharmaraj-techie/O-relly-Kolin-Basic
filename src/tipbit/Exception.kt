package tipbit

import java.lang.Exception
import java.lang.IllegalArgumentException

fun checkIsNumberException(obj: Any){
    when(obj){
        !is Int, Float, Long, Double -> throw NotANumberException()
    }
}

fun main(){
//    checkIsNumberException("dfds")
//    Exception in thread "main" tipbit.NotANumberException
//    at tipbit.ExceptionKt.checkIsNumberException(Exception.kt:5)
//    at tipbit.ExceptionKt.main(Exception.kt:10)
//    at tipbit.ExceptionKt.main(Exception.kt)

    try {
        checkIsNumberException("dkfn")
    } catch (e: NotANumberException){
        println("exception was handled")
    }finally {
        //what ever happens execute this block
        println("what ever happens I will run")
    }
    //exception was handled
    //what ever happens I will run



    //try catch black can also return an expression

    val result = try {
//        checkIsNumberException("dkfn")
        0
    } catch (e: NotANumberException){
        println("exception was handled")
        -1
    }finally {
        // this will run what ever happens but won't return any value
        //it only for running something after the operation not to return anything
        //this only execute this block
        println("what ever happens I will run")
        -2
    }

    println(result)
    //0

}
