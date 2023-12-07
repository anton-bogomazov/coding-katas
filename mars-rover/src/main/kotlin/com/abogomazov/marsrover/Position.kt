package com.abogomazov.marsrover

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
