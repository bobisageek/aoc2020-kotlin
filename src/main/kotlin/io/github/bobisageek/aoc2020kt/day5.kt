package io.github.bobisageek.aoc2020kt

import java.util.*

fun main() {
    val seatNumberSet = dayLines("5").map(Day5::seatNum).toSortedSet()
    println(Day5.part1(seatNumberSet))
    println(Day5.part2(seatNumberSet))
}

object Day5 {
    val lettersToNumber = mapOf('B' to 1, 'R' to 1).withDefault { 0 }
    fun seatNum(seatCode: String) = seatCode.map {
        lettersToNumber[it]
    }.joinToString(separator = "").let { Integer.parseInt(it, 2) }

    fun part1(input: SortedSet<Int>) = input.last()
    fun part2(input: SortedSet<Int>) = input.zipWithNext().first { (a, b) -> b - a != 1 }.let { it.first + 1 }
}
