package twentytwenty

import java.io.File
import java.nio.file.Paths

class DayOne {
    private var inputList: ArrayList<Int> = ArrayList<Int>()

    internal var partOneAnswer: Int = 0

    internal var partTwoAnswer: Int = 0

    fun loadInputFile(filename: String) {
        val path = Paths.get("").toAbsolutePath().toString()
        File("$path/$filename").forEachLine {
            inputList.add(it.toInt())
        }
    }

    private fun quickSort(input: ArrayList<Int>): ArrayList<Int> {
        if (input.count() < 2) {
            return input
        }
        val pivot = input[input.count()/2]
        val equal = input.filter { it == pivot } as ArrayList<Int>
        val less = input.filter { it < pivot } as ArrayList<Int>
        val greater = input.filter { it > pivot } as ArrayList<Int>
        return (quickSort(less) + equal + quickSort(greater)) as ArrayList<Int>
    }

    fun solvePartOne() {
        if (inputList.count()==0) { loadInputFile("src/data/DayOneInput.txt") }
        var filtered = inputList.filter { it < 2020 }
        var sorted = quickSort(filtered as ArrayList<Int>)
        loop@ for (lowVal in sorted) {
            for (highVal in sorted.reversed()) {
                if (lowVal + highVal == 2020) {
                    partOneAnswer = lowVal * highVal
                    break@loop
                }
            }
        }
    }

    fun solvePartTwo() {
        if (inputList.count()==0) { loadInputFile("src/data/DayOneInput.txt") }
        var filtered = inputList.filter { it < 2020}
        var sorted = quickSort(filtered as ArrayList<Int>)

        loop@ for(first in sorted) {
            for(second in sorted.filter { it != first}) {
                for(third in sorted.filter  { it != first && it != second }) {
                    if (first + second + third == 2020) {
                        partTwoAnswer = first * second * third
                        break@loop
                    }
                }
            }
        }
    }
}
