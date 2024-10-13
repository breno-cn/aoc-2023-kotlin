package com.nirra.aoc.days.day03

import com.nirra.aoc.days.Day

data class Engine(val content: List<String>, val width: Int, val height: Int) {
    private fun isPositionValid(i: Int, j: Int): Boolean {
        return  (i in 0..<height) &&
                (j in 0..<width)
    }

    fun findAdjacentNumbers(i: Int, j: Int): Set<Int> {
        val numbers: MutableSet<Int> = mutableSetOf()

        for (y in i-1..i+1) {
            for (x in j-1..j+1) {
                if (!isPositionValid(y, x))
                    continue

                val char = content[y][x]
                if (!char.isDigit())
                    continue

                // It's a valid position, and there is a number here
                // find the beginning and the end of the number
                val line = this.content[y]
                val begin = numberBeginningPosition(line, x)
                val end = numberEndPosition(line, x)

                val number = line.substring(begin, end).toInt()
                numbers.add(number)
            }
        }

        return numbers
    }
}

class Day03 : Day {
    private lateinit var input: Engine

    override fun prepareInput() {
        val content = this::class.java.getResource("/input/day03.txt")!!
            .readText()
            .lines()

        input = Engine(content, content.size, content[0].length)
    }

    override fun part1(): Int {
        var total = 0

        for (i in 0..<input.height) {
            for (j in 0..<input.width) {
                val char = input.content[i][j]
                if (!isSymbol(char))
                    continue

                total += input
                    .findAdjacentNumbers(i, j)
                    .sum()
            }
        }

        return total
    }

    override fun part2(): Int {
        var totalGearRatio = 0

        for (i in 0..<input.height) {
            for (j in 0..<input.width) {
                val char = input.content[i][j]
                if (char != '*')
                    continue

                val adjacentNumbers = input.findAdjacentNumbers(i, j)
                if (adjacentNumbers.size != 2)
                    continue

                totalGearRatio += adjacentNumbers.reduce(Int::times)
            }
        }

        return totalGearRatio
    }
}