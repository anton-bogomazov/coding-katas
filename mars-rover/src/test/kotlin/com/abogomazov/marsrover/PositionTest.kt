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
}
