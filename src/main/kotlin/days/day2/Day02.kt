package com.nirra.aoc.days.day2

import com.nirra.aoc.days.Day

data class Game(val red: List<Int>, val green: List<Int>, val blue: List<Int>, val id: Int) {
    companion object {
        fun fromString(line: String): Game {
            val id = line.substringAfter("Game ").substringBefore(": ").toInt()
            val line = line.substringAfter(": ")
            val turns = line.split("; ")

            val red: MutableList<Int> = mutableListOf()
            val green: MutableList<Int> = mutableListOf()
            val blue: MutableList<Int> = mutableListOf()

            for (turn in turns) {
                val split = turn.split(", ")
                for (hand in split) {
                    val hand = hand.split(" ")
                    val ammount = hand[0].toInt()
                    val collor = hand[1]

                    when (collor) {
                        "red" -> red.add(ammount)
                        "green" -> green.add(ammount)
                        "blue" -> blue.add(ammount)
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
        return 0
    }

}