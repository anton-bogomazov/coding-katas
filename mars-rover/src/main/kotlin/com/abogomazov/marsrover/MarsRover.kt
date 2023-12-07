package com.abogomazov.marsrover

class MarsRover(
    private val coordinate: Coordinate,
    private val orientation: Orientation,
    private val commands: List<MovingCommand>
) {
}

data class Coordinate(
    val x: Int,
    val y: Int,
)

enum class Orientation {
    N, S, E, W
}
