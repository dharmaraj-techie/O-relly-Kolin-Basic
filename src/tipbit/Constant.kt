package tipbit




/** Avoid using companion objects. Behind the hood,
 * getter and setter instance methods are created for the fields to be accessible.
 * Calling instance methods is technically more expensive than calling static methods.
 */
public class DbConstants {
    companion object {
        val TABLE_USER_ATTRIBUTE_EMPID = "_id"
        val TABLE_USER_ATTRIBUTE_DATA = "data"
    }
//    Instead define the constants in object.

//    Recommended practice :

    object DbConstants {
        const val TABLE_USER_ATTRIBUTE_EMPID = "_id"
        const val TABLE_USER_ATTRIBUTE_DATA = "data"
    }
}

/**
 * have constant as a global variable
 */
const val copyRightAuthor = "Raj"

/**
 * create
 */
object CopyRight {
    val author = "Dharmaraj"
}


//First of all, the naming convention in Kotlin for constants is the same than in java (e.g : MY_CONST_IN_UPPERCASE).

/**
 * How should I create it ?
1. As a top level value (recommended)
You just have to put your const outside your class declaration.
Two possibilities : Declare your const in your class file (your const have a clear relation with your class)
 */

private const val CONST_USED_BY_MY_CLASS = 1


fun main() {
    CopyRight.author
    CONST_USED_BY_MY_CLASS
}

//Create a dedicated constants.kt file where to store those global const (Here you want to use your const widely across your project) :
//
//package com.project.constants
//const val URL_PATH = "https:/"
//Then you just have to import it where you need it :
//
//import com.project.constants
//
//MyClass {
//    private fun foo() {
//        val url = URL_PATH
//        System.out.print(url) // https://
//    }
//}


/**
2. Declare it in a companion object (or an object declaration)
This is much less clean because under the hood, when bytecode is generated, a useless object is created :
*/

class MyClass() {
    companion object {
        private const val URL_PATH = "https://"
        const val PUBLIC_URL_PATH = "https://public" // Accessible in other project files via MyClass.PUBLIC_URL_PATH
    }
}

/**
 * Even worse if you declare it as a val instead of a const (compiler will generate a useless object + a useless function) :
 */
class MyClass1 {
    companion object {
        val URL_PATH = "https://"
    }
}

