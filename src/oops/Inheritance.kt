package oops

import java.util.*

/**
 *
 * Any is the base class of all the classes in kotlin
 *
 * by default all classes in kotlin are final
 * you have to make a class open to make it inheritable
 *
 * much like classes the members also need to be declared open to make it overrideable
 *
 */


open class Person(private val name: String) : Any() {

    open val hasAccessToCabin = false

    open val hasDressCode = true

    val specificMemberOfPerson = "I am specific only to person"

    /**
     * this method can't be overridden in the child class because it's not declared as open
     */
    fun getPersonName(): String = name.uppercase(Locale.getDefault())

    open fun objectType(): String = "Person"

    fun specificMethodOfPerson() = "$specificMemberOfPerson called from method"

}

open class Student(private val studentName: String) : Person(studentName) {

    override val hasDressCode: Boolean
        get() = super.hasDressCode


    val specificMemberOfStudent = "I am specific only to student"

    override fun objectType(): String = "Student"

    fun specificMethodOfStudent() = "$specificMemberOfStudent called from method"
}

open class Teacher(teacherName: String) : Person(teacherName) {


    //declaring a method final makes it not overridable in the child class
    final override val hasDressCode: Boolean
        get() = !super.hasDressCode

    val specificMemberOfTeacher = "I am specific only to Teacher"
    override val hasAccessToCabin: Boolean = true
    override fun objectType(): String = "Teacher"

    fun specificMethodOfTeacher() = "$specificMemberOfTeacher called from method"
}

class Hod(hodName: String) : Teacher(hodName) {

    //error
//    override val hasDressCode: Boolean
//        get() = super.hasDressCode
    /* can't override because this is declared as final in its super class      */

    override fun objectType(): String {
        //we use the super keyword to access the parent class fields and members
        return super.objectType() + ", Hod"
    }

    fun specificMethodOfHod() = "called from method"
}

//error
// class Hod: Teacher()
/*
this gives error because the Teacher class is not open and its final by default
 */

fun main() {
    val person = Person("someone")
    val student = Student("raj")
    val teacher = Teacher("malar")
    val hod = Hod("Vijayashree")

    println(student.getPersonName())
    //RAJ
    /**
     * here note that getPersonName is a Persons member function ,but
     * I am able to call it from Student also because it inherits that method from Person
     */
    println(hod.objectType())
    //Teacher, Hod


    /* ###########---------------  Upcasting Vs Downcasting ----------------------############# */

    /*------------------------- Upcasting : can a person hold Teacher -----------------------------------------*/
    /**
     *Upcasting is the typecasting of a child object to a parent object.
     * Upcasting can be done implicitly.
     * Upcasting gives us the flexibility to access the parent class members ,
     * but it is not possible to access all the child class members using this feature.
     * Instead of all the members, we can access some specified members of the child class.
     * For instance, we can access the overridden methods.
     *
     * here the teacher is the child and person is the Parent
     */

    val canPersonHoldTeacher: Person = Teacher("vino")
    //but only has access to methods of the Person class you can't access the Teacher specific methods
    println(canPersonHoldTeacher.specificMethodOfPerson())
    //I am specific only to person called from method

    /*------------------------- Downcasting : can a Teacher hold Person -----------------------------------------*/
    /**
     * Similarly, downcasting means the typecasting of a parent object to a child object.
     * Downcasting cannot be implicit.
     *
     * here the teacher is the child and person is the Parent
     *
     *  Article about upcasting and downcasting [https://www.javatpoint.com/upcasting-and-downcasting-in-java]
     */


//    val canTeacherHoldPerson: Teacher = Person("someRandom") as Teacher
    /*
    the above line will crash the program
    Exception in thread "main" java.lang.ClassCastException: oops.Person cannot be cast to oops.Teacher
	at oops.InheritanceKt.main(Inheritance.kt:127)
	at oops.InheritanceKt.main(Inheritance.kt)
     */

    /**
     *
     * To downcast the child, it must point to a parent object
     * otherwise you will get a runtime error
     */

    val canTeacherHoldPerson: Teacher = canPersonHoldTeacher as Teacher
    println(canPersonHoldTeacher.specificMethodOfTeacher())
    // I am specific only to Teacher called from method


}