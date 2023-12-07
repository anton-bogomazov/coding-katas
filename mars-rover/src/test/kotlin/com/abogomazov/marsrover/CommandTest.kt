package com.abogomazov.marsrover

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CommandTest {
    @Test
    fun `move forward command returns new position ahead of current`() {
        val initialPosition = position()
        assertEquals(
            position(coordinate = Coordinate(0, 1)),
            Forward.execute(initialPosition)
        )
    }
    @Test
    fun `move backward command returns new position behind the current`() {
        val initialPosition = position()
        assertEquals(
            position(coordinate = Coordinate(0, -1)),
            Backward.execute(initialPosition)
        )
    }
}
