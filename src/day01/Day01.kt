package day01

import println
import readInput
import kotlin.math.abs


fun main() {
    val leftList = mutableListOf<Int>()
    val rightList = mutableListOf<Int>()

    fun parseInput(input: List<String>) {
        leftList.clear()
        rightList.clear()
        input.forEach { line ->
            val (left, right) = line.split("   ").map { it.toInt() }
            leftList.add(left)
            rightList.add(right)
        }
    }

    fun part1(): Int {
        val sortedlists = leftList.sorted() zip rightList.sorted()
        return sortedlists.sumOf { it.distance }
    }

    fun part2(): Int {
        val similarityScores = leftList.map { left -> left * rightList.count { right -> right == left } }
        return similarityScores.sum()
    }

    val testInput = readInput("day01/example")
    parseInput(testInput)
    check(part1() == 11)
    check(part2() == 31)

    val input = readInput("day01/input")
    parseInput(input)
    part1().println()
    part2().println()
}

private val Pair<Int, Int>.distance: Int
    get() = abs(first - second)