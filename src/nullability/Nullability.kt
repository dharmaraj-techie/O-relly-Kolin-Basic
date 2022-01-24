package nullability

import oops.Customer

/**
 * by default null safe
 */
fun main() {
    val message: String = "hello"
    println(message.length) // 5

    // val msg: String = null
    /*
      compiler error
      in kotlin by default the types can't be null
     */
/*------------------------------------------------------------*/
    var msg: String? = null

    //println(msg.length)
    //will trough a compile time error
    //Only safe(?) or non-null asserted (!!) calls are allowed
/*------------------------------------------------------------*/

    //let's say we assign a value to msg
    msg = "hello world"
    println(msg.length) // 11
    //this time it will work because the msg has a value
    //this isn't always going to be the case,
    //sometimes we might not know value going to be null or safe during the compile time
/*------------------------------------------------------------*/

    val nullMessage: String? = null
    if (nullMessage != null) {
        //after checking the value is not null inside the if block the variable behaves like a non-null type
        println(nullMessage.length)
    }
/*------------------------------------------------------------*/
    val nullableClass : ClassA? = ClassA("")

    // println(nullableClass.a.length)
    //compile time error because the class can be null
    // so we can do a null check

    if (nullableClass != null) {
        if(nullableClass.a != null){
            println(nullableClass.a.length)
        }
    }

    /* this is cumbersome so, the kotlin has elvis operator or the safe operator  */


    println(nullableClass?.a?.length) //
    // the "?" is saying if the value is not null then invoke the method length on it
    // if it is null then don't do it
/*---------------------------------------------------------------------------------------*/
    //The Elvis operator ?:

    // [execute if it's non null] ?: [execute if it's null]

    //the value before the elvis works if it's not null, when that value is null the block after wards will run

    val i : Int? = null
    println(i ?: "it's empty") // it's empty

    val nullableClassB: ClassA? = null
    println(nullableClassB ?: "the class is null") //the class is null

    val sp = createServiceProvide()

    sp?.createService()?.evaluate()

    //instead of
    if (sp != null) {
        if(sp.createService() != null){
            sp.createService()!!.evaluate()
        }
    }
/*-----------------------------------------------------------*/
    // !!
    println(nullMessage!!.length)
    //  this will crash with a null pointer exception
    // it's like saying to the compiler that I know what I am doing and let me do my thing

}


class ClassA(val a: String?){
}

class Service{
    fun evaluate(){}
}

class ServiceProvider{
  fun createService(): Service? {
      return null
  }
}


fun createServiceProvide(): ServiceProvider? {
    return null
}



