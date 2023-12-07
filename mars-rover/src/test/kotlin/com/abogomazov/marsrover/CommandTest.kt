package com.abogomazov.marsrover

import com.abogomazov.marsrover.domain.Coordinate
import com.abogomazov.marsrover.domain.Orientation
import com.abogomazov.marsrover.domain.position
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CommandTest {
    @Test
    fun `move forward command returns new position ahead of current`() {
        val initialPosition = position()
        assertEquals(
            position(coordinate = Coordinate(0, 1)),
            MoveForward.execute(initialPosition)
        )
    }
    @Test
    fun `move backward command returns new position behind the current`() {
        val initialPosition = position()
        assertEquals(
            position(coordinate = Coordinate(0, -1)),
            MoveBackward.execute(initialPosition)
        )
    }
    @Test
    fun `turn command returns the same position but differently oriented `() {
        val initialPosition = position()
        assertEquals(
            position(orientation = Orientation.W),
            TurnLeft.execute(initialPosition)
        )
    }
}
