package com.abogomazov.marsrover

class MarsRover(
    private val position: Position,
    private val commands: List<MovingCommand>
) {
}

data class Position(
    val coordinate: Coordinate,
    val orientation: Orientation,
)

data class Coordinate(
    val x: Int,
    val y: Int,
)

enum class Orientation {
    N, S, E, W
}
