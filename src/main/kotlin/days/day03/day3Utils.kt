package com.nirra.aoc.days.day03

fun isSymbol(char: Char): Boolean {
    return !char.isDigit() && char != '.'
}

fun numberBeginningPosition(line: String, start: Int): Int {
    var index = start

    while (index >= 0) {
        val char = line[index]
        if (!char.isDigit())
            break

        index--
    }

    return index + 1
}

fun numberEndPosition(line: String, start: Int): Int {
    var index = start

    while (index < line.length) {
        val char = line[index]
        if (!char.isDigit())
            break

        index++
    }

    return index
}
