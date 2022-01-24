package oops

/**
 * interfaces are similar to abstract class,
 * interface are referred to as contracts in kotlin
 * (contract that the person implementing it and also the person consuming it agrees too)
 *
 *  the concept of interfaces can also have implenmented methods came after java 8
 *
 * so what is the difference between abstract class and Interface:
 * 1. the interface can't have states like abstract class do,
 *      in interface you can only have abstract properties not fields
 *
 * 2. I can't have a class that inherits from 2 or more classes or abstract classes,
 *      but I can have a class the inherits from multiple interfaces
 *
 *
 */
interface CustomerRepository {
    /**
     * interface can have properties and this properties have to be abstract
     */
    val isEmpty: Boolean

    //property initialization are not allowed in interfaces
//    val property: Int = 0

    /**
     * property initialization are not allowed in interfaces,
     * but you can have getters and setters
     */
    val property: Int
        get() = 0

    /**
     * these are like abstract methods which needs to be implemented
     */
    fun getById(id: Int): Customer

    /**
     * you don't need to use the abstract keyWord
     */
    abstract fun getData()

    /**
     * interfaces can also implement members
     */
    fun store() {
        //implementation
    }
}


 class SQLCustomerRepository(override val isEmpty: Boolean) : CustomerRepository {
    override fun getById(id: Int): Customer {
        TODO("Not yet implemented")
    }
      override fun getData() {}
     /**
      * you override properties also
      */
     override val property: Int
         get() = 10

     /**
      * you can override implemented methods of interface also
      */
     override fun store() {
         super.store()
     }
 }


interface Interface1{
    fun funA( ){
        println("fun from interface 1")
    }
    fun funB()
    fun funC( ){
        println("fun c from interface 1")
    }
}

interface Interface2{
    fun funA( ){
        println("fun from interface 2")
    }
    fun funB()

    fun funC( ){
        println("fun c from interface 2")
    }
}


class Class1and2: Interface1, Interface2{
    /**
     * since both the interface have the same function name [funA] which is a fully implemented method
     * but in this class where we implemented both the interfaces we need to override [funA] only once
     *
     * this Class must override public open fun [funA] defined in [Interface1]
     * because it inherits multiple interface methods of it
     */
    override fun funA() {
        println("its our own")
    }

    /**
     * similarly for abstract member also
     */
    override fun funB() {
        TODO("Not yet implemented")
    }

    /**
     * Many supertypes available, so we need to specify the one in angle brackets, e.g. 'super<Foo>'
     */
    override fun funC() {
        super<Interface2>.funC()
    }


}

fun main(){
    val c = Class1and2()
    println(c.funA())
    //its our own
}