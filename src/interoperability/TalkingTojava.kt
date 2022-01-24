package interoperability

import interoperability.data.CustomerJava
import interoperability.data.CustomerRepository

fun main() {

    //here CustomerJava() is a java class
    val customer = CustomerJava()

    // * here id is converted to a property like in kotlin
    customer.id

    // * you can also call using the getterMethod
    customer.getId()

    // * this method returns void in java, but here it returns unit
    customer.prettyPrint()

    // * use of SAM
    println("Is 7 even? - ${isEven.accept(7)}")

}

/*--------------------------------------------------------------------------------------*/

/**
 * # can extend java classes
 */
class CustomerStorage : CustomerJava() {
}
/*--------------------------------------------------------------------------------------*/
/**
 * # implementing a java interface
 */
class KotlinCustomerRepo : CustomerRepository {
    override fun getById(Id: Int): CustomerJava {
        TODO("Not yet implemented")
    }

    override fun getAll(): MutableList<CustomerJava> {
        TODO("Not yet implemented")
    }

}
/*--------------------------------------------------------------------------------------*/

/**
 * # SAM
 * * Single Abstract method
 * An interface with only one abstract method is called a functional interface,
 * or a Single Abstract Method (SAM) interface.
 * The functional interface can have several non-abstract members but only one abstract member.
 * To declare a functional interface in Kotlin, use the fun modifier.
 */

fun interface KRunnable {
    fun invoke()
}

/**
For functional interfaces,
you can use SAM conversions that help make your code more concise and readable by using lambda expressions.
Instead of creating a class that implements a functional interface manually, you can use a lambda expression.
With a SAM conversion,Kotlin can convert any lambda expression
whose signature matches the signature of the interface's single method into the code,
which dynamically instantiates the interface implementation.
 */

//For example, consider the following Kotlin functional interface :

fun interface IntPredicate {
    fun accept(i: Int): Boolean
}

//If you don't use a SAM conversion, you will need to write code like this:

// * Creating an instance of a class
val isEven1 = object : IntPredicate {
    override fun accept(i: Int): Boolean {
        return i % 2 == 0
    }
}

/**
By leveraging Kotlin's SAM conversion,
you can write the following equivalent code instead:*/
// * Creating an instance using lambda
val isEven = IntPredicate { it % 2 == 0 }

