import twentytwenty.DayOne

fun DayOneWrapper() {
    val dayOne = DayOne()
    dayOne.solvePartOne()
    dayOne.solvePartTwo()

    println("Day 1, Part 1: ${dayOne.partOneAnswer}")
    println("Day 1, Part 2: ${dayOne.partTwoAnswer}")
}

fun main(args: Array<String>) {
    DayOneWrapper()
}