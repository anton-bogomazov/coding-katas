package com.abogomazov.marsrover

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PositionTest {
    @Test
    fun `forward returns next position ahead of current`() {
        val sut = position()
        assertEquals(
            Position(
                coordinate = Coordinate(0, 1),
                orientation = Orientation.N
            ),
            sut.forward()
        )
    }

    @Test
    fun `forward position depends on orientation`() {
        val sut = position(orientation = Orientation.S)
        assertEquals(
            Position(
                coordinate = Coordinate(0, -1),
                orientation = Orientation.S
            ),
            sut.forward()
        )
    }

    @Test
    fun `forward position could be calculated for any axis`() {
        val sut = position(orientation = Orientation.W)
        assertEquals(
            Position(
                coordinate = Coordinate(-1, 0),
                orientation = Orientation.W
            ),
            sut.forward()
        )
    }
}
