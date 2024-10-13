package com.nirra.aoc.days.day1

import com.nirra.aoc.days.Day

class Day01 : Day {

    private lateinit var input: List<String>

    private val numbers = mapOf(
        "zero" to 0,
        "one" to 1,
        "two" to 2,
        "three" to 3,
        "four" to 4,
        "five" to 5,
        "six" to 6,
        "seven" to 7,
        "eight" to 8,
        "nine" to 9
    )

    override fun prepareInput() {
        input = this::class.java.getResource("/input/day01.txt")!!
            .readText()
            .lines()
    }

    override fun part1(): Int {
        return input
            .map(::firstAndLastDigit)
            .sumOf { it.first * 10 + it.second }
    }

    override fun part2(): Int {
        val firstNumbers = input
            .map(::findFirstNumber)

        val lastNumbers = input
            .map(::findLastNumber)

        return firstNumbers
            .zip(lastNumbers)
            .sumOf { it.first * 10 + it.second }
    }

    fun firstAndLastDigit(line: String): Pair<Int, Int> {
        val digits = line
            .filter { it.isDigit() }
            .map { it.digitToInt() }

        return Pair(digits.first(), digits.last())
    }

    private fun findFirstNumber(line: String): Int {
        var startIndex = 0
        for (char in line) {
            if (char.isDigit()) {
                return char.digitToInt()
            }

            for (number in numbers.keys) {
                if (line.startsWith(number, startIndex)) {
                    return numbers[number]!!
                }
            }

            startIndex++
        }

        return 0
    }

    private fun findLastNumber(line: String): Int {
        var endIndex = line.length

        for (i in line.length - 1 downTo 0) {
            val currentChar = line[i]

            if (currentChar.isDigit()) {
                return currentChar.digitToInt()
            }

            for (number in numbers.keys) {
                if (line.substring(0, endIndex).endsWith(number)) {
                    return numbers[number]!!
                }
            }

            endIndex--
        }

        return 0
    }

}
