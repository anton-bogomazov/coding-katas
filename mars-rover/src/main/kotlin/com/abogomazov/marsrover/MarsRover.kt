package com.abogomazov.marsrover

class MarsRover(
    private val coordinate: Coordinate,
    private val direction: Direction,
    private val commands: List<Command>
) {
}

data class Coordinate(
    val x: Int,
    val y: Int,
)

enum class Direction {
    N, S, E, W
}

class Command
