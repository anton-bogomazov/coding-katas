package com.abogomazov.marsrover

import org.junit.jupiter.api.Test

class CommandTest {
    @Test
    fun `move forward command`() {
        Forward.execute(Coordinate(0, 0), Orientation.N)
    }
    @Test
    fun `move backward command`() {
        Backward.execute(Coordinate(0, 0), Orientation.N)
    }
}
