package com.abogomazov.marsrover

data class Position(
    val coordinate: Coordinate,
    val orientation: Orientation,
) {

    fun forward(): Position =
        this.copy(
            coordinate = applyDelta { it + this.orientation.delta }
        )

    private fun applyDelta(delta: (Int) -> Int): Coordinate {
        return Coordinate(
            x = if (this.orientation.axis == Axis.X) { delta(this.coordinate.x) } else this.coordinate.x,
            y = if (this.orientation.axis == Axis.Y) { delta(this.coordinate.y) } else this.coordinate.y
        )
    }

}

data class Coordinate(
    val x: Int,
    val y: Int,
)

enum class Axis { X, Y }

enum class Orientation(val axis: Axis, val delta: Int) {
    N(Axis.Y, 1), S(Axis.Y, -1), E(Axis.X, 1), W(Axis.X, -1)
}
