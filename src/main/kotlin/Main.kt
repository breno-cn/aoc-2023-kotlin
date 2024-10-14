package com.nirra.aoc

import com.nirra.aoc.days.day04.Day04

fun main() {
    val days = listOf(Day04())

    for (day in days) {
        day.run()
    }
}