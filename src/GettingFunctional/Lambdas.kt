package GettingFunctional

/**
 * this function takes a
 * @param db as argument and
 * @param code which is function that takes nothing and returns unit
 */
fun transaction(db: Database, code: ()->Unit){
    try {
        code()
    }finally {
        db.commit()
    }
}

class Database(){
    fun commit(){}
}

fun main(){
    // * referencing func using ::
    println(operation(1,2,::sum)) // 3

/*------------------------------------------------------------------------------------------------------*/

    // * passing function as lambda
    operation(3,3){a,b ->
        a*b
    }
    //9

/*------------------------------------------------------------------------------------------------------*/

    // * use of it inside lambda

    val subtractionLambda: (Int, Int) -> Int = { x, y  -> x-y}
    operation(10,3, subtractionLambda)

    // * here it refers the variable inside lambda
    // ? {i -> i*i} is == {it * it}
    // * for single argument you don't need to give a name

    operation(3){it*it}

    val square:(Int) -> Int = {it * it }
/*------------------------------------------------------------------------------------------------------*/

    // * more elegant code

    val db = Database()
    transaction(db){
        // some code
    }

    // * now here the code is more concise
    // * most importantly transaction now look like a keyword of the language
    // * we just created a keyword kind of feel using higher order func and lambda

/*------------------------------------------------------------------------------------------------------*/

    // * Anonymous function
    operation(6 , fun(x: Int):Int { return x*x} )
    //here I have created an anonymous function with no name
}

