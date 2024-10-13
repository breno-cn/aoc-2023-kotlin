package com.nirra.aoc.days.day2

import com.nirra.aoc.days.Day

data class Game(val red: List<Int>, val green: List<Int>, val blue: List<Int>, val id: Int) {
    companion object {
        fun fromString(line: String): Game {
            val id = line
                .substringAfter("Game ")
                .substringBefore(": ")
                .toInt()

            val line = line.substringAfter(": ")
            val turns = line.split("; ")

            val red: MutableList<Int> = mutableListOf()
            val green: MutableList<Int> = mutableListOf()
            val blue: MutableList<Int> = mutableListOf()

            for (turn in turns) {
                turn.split(", ")
                    .forEach {
                        val hand = it.split(" ")
                        val amount = hand[0].toInt()
                        val color = hand[1]

                        when (color) {
                            "red" -> red.add(amount)
                            "green" -> green.add(amount)
                            "blue" -> blue.add(amount)
                        }
                    }
            }

            return Game(red, green, blue, id)
        }
    }

    fun isPossible(red: Int, green: Int, blue: Int): Boolean {
        return this.red.all { it <= red } &&
                this.green.all { it <= green } &&
                this.blue.all { it <= blue }
    }

    fun power(): Int {
        val red = this.red.max()
        val green = this.green.max()
        val blue = this.blue.max()

        return red * green * blue
    }
}

class Day02 : Day {

    private lateinit var input: List<Game>

    override fun prepareInput() {
        input = this::class.java.getResource("/input/day02.txt")!!
            .readText()
            .lines()
            .map(Game::fromString)
    }

    override fun part1(): Int {
        return input
            .filter { it.isPossible(12, 13, 14) }
            .sumOf { it.id }
    }

    override fun part2(): Int {
        return input.sumOf { it.power() }
    }

}