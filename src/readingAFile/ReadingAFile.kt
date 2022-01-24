package readingAFile

import java.io.File

fun main(){
    val lines =  File("src/words_with_numbers.txt").readLines()
    val numbers = lines.filter{item ->
        var isNumber = false
        item.forEach {isNumber = it.isDigit()}
        isNumber
    }
    println(numbers.size)

}