package com.abogomazov.marsrover

data class Position(
    val coordinate: Coordinate,
    val orientation: Orientation,
) {

    fun forward(): Position =
        this.copy(
            coordinate = this.coordinate.copy(
                y = this.coordinate.y + this.orientation.delta
            )
        )

}

data class Coordinate(
    val x: Int,
    val y: Int,
)

enum class Orientation(val delta: Int) {
    N(1), S(-1), E(1), W(-1)
}
