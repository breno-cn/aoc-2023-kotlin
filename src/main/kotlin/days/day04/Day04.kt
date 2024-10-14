package com.nirra.aoc.days.day04

import com.nirra.aoc.days.Day

data class Game(val winningCards: Set<Int>, val guesses: Set<Int>) {
    companion object {
        fun parse(line: String): Game {
            val split = line
                .substringAfter(": ")
                .split(" | ")

            val winning = parseCards(split[0])
            val guesses = parseCards(split[1])

            return Game(winning, guesses)
        }
    }

    fun points(): Int {
        val correctGuesses = guesses
            .intersect(winningCards)
            .size

        return when {
            correctGuesses == 1 -> 1
            else -> 2 shl (correctGuesses - 2)
        }
    }
}

class Day04 : Day {
    private lateinit var input: List<Game>

    override fun prepareInput() {
        input = this::class.java.getResource("/input/day04.txt")!!
            .readText()
            .lines()
            .map(Game::parse)
    }

    override fun part1(): Int {
        return input.sumOf { it.points() }
    }

    override fun part2(): Int {
        return 0
    }
}