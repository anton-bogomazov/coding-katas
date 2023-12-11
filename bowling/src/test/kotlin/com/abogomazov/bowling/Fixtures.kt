package com.abogomazov.bowling

fun finishedGame() = game(
    listOf(
        1, 3,
        10,
        7, 3,
        5, 5,
        10,
        10,
        0, 0,
        0, 3,
        3, 0,
        3, 7, 10
    )
)

fun unfinishedGame() = game(
    listOf(
        1, 3,
        10,
        7, 3,
        5,
    )
)

fun perfectGame() = game(listOf(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10))

private fun game(rolls: List<Int>): Game {
    val game = Game()
    rolls.forEach {
        game.roll(it)
    }
    return game
}
