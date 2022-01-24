package Algorithms

import java.io.File

fun main() {
    val inputFile = "src/Algorithms/sorted_array_input.txt"
    val input = File(inputFile).readLines()
    val array = input[0].split(" ").map { it.trim().toInt() }.toIntArray()
    val elementArray = input[1].split(" ").map { it.trim().toInt() }.toIntArray()

    elementArray.forEach {
        print("${binarySearch(array, it)} ")
    }

}

private fun binarySearch(array: IntArray, elementToFind: Int): Int {

    var start = 0
    var end = array.lastIndex

    var mid: Int = 0

    while (start <= end) {
        mid = (start + end) / 2
        if (array[mid] == elementToFind) {
            return array[mid]
        } else if (elementToFind > array[mid]) {
            start = mid + 1
        } else {
            end = mid - 1
        }
    }

    if(start == 0) return array[0]

    if(array[mid] > elementToFind){
        return array[mid-1]
    }else{

        return array[mid]
    }

}