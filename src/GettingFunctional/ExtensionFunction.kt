package GettingFunctional

/**
 *  Extension Function
 * * Add a new functionality to string class
 *
 *this function capitalises the first letter of the string
 */
fun String.capitalizeFirstLetter(): String {
    return "${this[0].uppercaseChar()}${this.substring(1)}"
}


class Customer(){
    fun makePreferred(){
        println("Customer version")
    }
}

/**
 * let's create an extension function with the same name as the func already inside class
 */
fun Customer.makePreferred(){
    println("Extended version")
}
/**
 * let's create an extension function with the same name as the func already inside class
 * but with a parameter
 */
fun Customer.makePreferred(msg: String){
    println(msg)
}

fun main(){
    println("dharmaraj".capitalizeFirstLetter()) //Dharmaraj
    val customer = Customer()
/*-----------------------------------------------------------------------------*/
    // ! there are two functions with this same name [makePreferred] which would be called?
    customer.makePreferred() // Customer version
    // * here the function inside the class(i.e) member function is called

    customer.makePreferred("hello") //hello

/*-------------------------------------------------------------------------------------*/

    // * extension function are statically resolved

    val instance : BaseClass = InheritedClass()
    instance.extension()  // Base extension

    val instance1  = InheritedClass()
    instance1.extension()  // inheritance extension

    // * the extension function is also inherited
    val instance2 = InheritedClass2()
    instance2.extension() // Base extension
}

open class BaseClass
class InheritedClass: BaseClass()
class InheritedClass2: BaseClass()

fun BaseClass.extension(){
    println("Base extension")
}

fun InheritedClass.extension(){
    println("inheritance extension")
}









