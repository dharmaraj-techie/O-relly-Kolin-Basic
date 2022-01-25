package Lazy

fun main() {
    //When using lazy initialization in Kotlin,
    // you must declare variables with the val keyword because the value can only be initialized once.

    val a: String by lazy {
        print("Variable a is initialized. ")
        "I love Hyperskill!"
    }

    println("Initializing a! ") // Initializing a!
    println(a) // Variable a is initialized. I love Hyperskill!
    println(a) // I love Hyperskill!
}


//Normally, if a class field's value isn't null,
// we should either initialize the property immediately or do it in the constructor.
// But there are often situations where,
// at the time we create an instance of a class, we can't initialize the property, and we don't want to make it nullable.

class A {
    lateinit var a: String

    fun initA(a: String) {
        this.a = a
    }

    fun doSmth() {
        if (::a.isInitialized)
            println("a is Initialized")
        else
            println("a isn't Initialized")
    }
    //If you try to access a property before the binding has been initialized, an error will be thrown:
    //Caused by: kotlin.UninitializedPropertyAccessException: lateinit property binding has not been initialized
}