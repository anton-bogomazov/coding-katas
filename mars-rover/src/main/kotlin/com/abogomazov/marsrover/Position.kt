package com.abogomazov.marsrover

data class Position(
    val coordinate: Coordinate,
    val orientation: Orientation,
) {

    fun forward(): Position =
        this.copy(
            coordinate = this.coordinate.copy(y = this.coordinate.y + 1)
        )

}

data class Coordinate(
    val x: Int,
    val y: Int,
)

enum class Orientation {
    N, S, E, W
}
