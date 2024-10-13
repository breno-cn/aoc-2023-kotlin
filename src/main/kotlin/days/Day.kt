package com.nirra.aoc.days

import kotlin.system.measureTimeMillis

interface Day {

    fun prepareInput()

    fun part1(): Int

    fun part2(): Int

    fun run() {
        println("Preparing input...")
        val inputTimeElapsed = measureTimeMillis {
            prepareInput()
        }

        println("Input reading took $inputTimeElapsed ms")

        var part1Result: Int
        val part1TimeElapsed = measureTimeMillis {
            part1Result = part1()
        }

        println("Part 1 took $part1TimeElapsed ms")
        println("Part 1 result: $part1Result")

        println("=".repeat(50))

        var part2Result: Int
        val part2TimeElapsed = measureTimeMillis {
            part2Result = part2()
        }

        println("Part 2 took $part2TimeElapsed ms")
        println("Part 2 result: $part2Result")

        println("=".repeat(50))
        println("=".repeat(50))
    }

}