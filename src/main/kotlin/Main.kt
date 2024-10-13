package com.nirra.aoc

import com.nirra.aoc.days.day03.Day03
import com.nirra.aoc.days.day1.Day01
import com.nirra.aoc.days.day2.Day02

fun main() {
    val days = listOf(Day03())

    for (day in days) {
        day.run()
    }
}