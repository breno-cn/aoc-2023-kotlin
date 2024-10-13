package com.nirra.aoc

import com.nirra.aoc.days.day1.Day01

fun main() {
    val days = listOf(Day01())

    for (day in days) {
        day.run()
    }
}