package tipbit

/**
 * Initially in kotlin there where tuples
 * but it was dropped and started using Pairs(2) Triples(3) and data class(more then 3)
 *
 * one important note
 * Tipples and Pairs are also Data classes
 */

fun main() {

    val result = capitalAndPopulation("India")

    println(result.first) // India
    println(result.second) // 3435

    val countryInfo = countryInformation("Sri lanka")

    println(countryInfo.third) //3435

}

fun capitalAndPopulation(country: String): Pair<String, Long> {
    return Pair(country, 3435)
}

fun countryInformation(country: String): Triple<String, String, Long> {
    return Triple(country, "Rupees", 3435)
}


// Implementation of Pairs
//public final data class Pair<out A, out B> public constructor(first: A, second: B)  {
//    public final val first: A /* compiled code */
//
//    public final val second: B /* compiled code */
//
//    public final operator fun component1(): A { /* compiled code */
//    }
//
//    public final operator fun component2(): B { /* compiled code */
//    }
//
//    public open fun toString(): kotlin.String { /* compiled code */
//    }
//}
