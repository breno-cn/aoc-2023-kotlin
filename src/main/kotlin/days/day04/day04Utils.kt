package com.nirra.aoc.days.day04

fun parseCards(cards: String): Set<Int> {
    return cards
        .split(" ")
        .filter { it != "" }
        .map { it.toInt() }
        .toSet()
}
