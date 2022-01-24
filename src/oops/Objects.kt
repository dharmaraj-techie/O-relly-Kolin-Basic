package oops


/**
 * Singleton
 *  a singleton class is a class that can have only one object (an instance of the class) at a time.
 */
object Global {
    val PI = 3.14
}

fun main(){
    println(Global.PI)
    val localObject = object {
        val PI = 3.13
    }
    println(localObject.PI)

    //* * accessing a object from inside a class

    Players.Rules.speed
    // ! here not that we don't need to create the instance of that class


}


class Players(val playerName:String){

    object Rules{
        val speed = 220
        fun printSpeed(s: String) = println(speed)
    }
}

class ExampleCompanionObject{
    companion object {
        val pi = 3.413
    }
//    object  {
//        val s = "trying to create annonumos object"
//    }
}