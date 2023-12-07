package com.abogomazov.marsrover

import com.abogomazov.marsrover.domain.position
import org.junit.jupiter.api.Test

class MarsRoverTest {
    @Test
    fun `coordinate, directory and list of commands are required to initialize rover`() {
        MarsRover(position(), listOf(MoveForward))
    }
}
