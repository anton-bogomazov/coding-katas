package com.abogomazov.marsrover.domain

data class Position(
    val coordinate: Coordinate,
    val orientation: Orientation,
) {

    fun ahead(): Position =
        this.copy(
            coordinate = applyDelta { it + this.orientation.delta }
        )

    fun behind(): Position =
        this.copy(
            coordinate = applyDelta { it - this.orientation.delta }
        )

    private fun applyDelta(delta: (Int) -> Int): Coordinate {
        return Coordinate(
            x = if (this.orientation.axis == Axis.X) { delta(this.coordinate.x) } else this.coordinate.x,
            y = if (this.orientation.axis == Axis.Y) { delta(this.coordinate.y) } else this.coordinate.y
        )
    }

}
