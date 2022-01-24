package tipbit

import oops.Customer

fun main() {

    /**
     * here the [capitalAndPopulation] is a function which returns a Pair
     * so the variable result is of Type Pair
     *
     * we can access this value using [Pair.first] and [Pair.second] methods
     * but it's not concise , we know the type but not what its returning
     */
    val result = capitalAndPopulation("India")

    // so what we can do is
    val (countryName, population) = capitalAndPopulation("India")
    println(countryName) // India
    println(population) //3435


    val (countryInfo,capital, totalPopulation) = countryInformation("Sri lanka")
    println(totalPopulation) //3435

/*-----------------------------------------------------------------------------------------------*/

    //deconstruction can also work with other things


    //Data classes
    val (id, name, email) = tipbit.Customer(8, "raj","djfhd")

    // works with for loop
    val listCapitalsAndCountries = listOf(
            Pair("India","delhi"),
            Pair("France","paris")
    )
    for(( country, cap) in listCapitalsAndCountries){
        println("$country's capital is $cap")
    }
    //India's capital is delhi
    //France's capital is paris

}

data class Customer (val id:Int, val name:String, val mail:String){

}

