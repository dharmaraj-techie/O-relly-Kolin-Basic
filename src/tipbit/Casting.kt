package tipbit

open class Person{
}

class Employee: Person(){
    /**
     * this method only belong to Employee
     */
    fun vacationDays(days: Int){
        if(days < 60){
            println("you need more vacation")
        }
    }
}


fun hasVacation(obj: Person){
    if(obj is Employee){
        obj.vacationDays(20)
        //here obj is type Person but I am able to call method of Employee
        //this is because of type casting
        // the compiler knows that we are checking is the type is Employee so it knows that
        // inside if block if the condition is true the obj is Employee
        //so the compiler automatically cast the obj to Employee , you don't need to explicitly cast it to employee
        // this is also case with null check , if wee check for nullability inside the if block the
        // value or variable will behave as non-null type
    }
}

class Contractor: Person(){
}

var input: Any = 10
fun main(){
    val s : String? = null

    s?.length
    // s.length
    // the above will throw a compiler error

    if (s != null) {
        s.length
        //here the variable is typeCasted to String
    }
/* -------------------------------------------------------------------- */

    // what if we want to do the cast or compiler doesn't know how to do that
    // we can cast using the as keyword
    // we can use as? or as

    val str1 = input as? String
    // here it won't get any cast exception

    println(str1?.length) //null
    // here the cast is not possible because the int can't be cast as string
    //so str1 will be null

    val str = input as String
    // the above will run into an error
    //ClassCastException in the run time
    println(str.length)
}


