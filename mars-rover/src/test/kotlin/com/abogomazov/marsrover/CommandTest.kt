package com.abogomazov.marsrover

import org.junit.jupiter.api.Test

class CommandTest {
    @Test
    fun `move forward command`() {
        Forward.execute(position())
    }
    @Test
    fun `move backward command`() {
        Backward.execute(position())
    }
}
