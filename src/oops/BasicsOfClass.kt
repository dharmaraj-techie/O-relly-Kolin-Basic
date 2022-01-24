package oops

import java.text.SimpleDateFormat
import java.util.*


/**
 * @param cusId is the property of this class
 * @param name is also a property of this class
 * @param dob is default parameter with the default value the user can give dob if they wish
 */
class Customer(val cusId: Long, var name: String, private val phoneNumber: String, var dob: String = "") {
    //this is a test variable to see which run 1st init block or variable initialization turns out
    // the execution order of variable and init block are in the order in which they are presented inside the class
//    val i = println("the 1st variable is called")

    init {
//        println("init block is called")
        name = name.uppercase(Locale.getDefault())
        if (phoneNumber.length != 10) throw IllegalArgumentException("the phone number is incorrect")
    }

    val age: Int
        get() {
            val cal = Calendar.getInstance()
            val sdf = SimpleDateFormat("dd/mm/yyyy", Locale.ENGLISH)
            cal.time = sdf.parse(dob) // all done
            return Calendar.getInstance().get(Calendar.YEAR) - cal.get(Calendar.YEAR)
        }

    internal var pointsEarned: Int = 0
        get() {
            return field
        }
        set(value) {
            field = value * 100
        }

    //test variable
//    val j = println("the 2nd variable is called")

    //constructor with only phone number
    constructor(phoneNumber: String) : this(0L, "", phoneNumber) {
        println("the secondary constructor is called ")
    }


}


fun main() {
    val unknown = Customer("9099303939")
    val raj = Customer(123, "raj", "9099303939", "30/09/1993")
    println(raj.age)
    raj.pointsEarned = 2
    println(raj.pointsEarned)
}