package com.abogomazov.marsrover

import org.junit.jupiter.api.Test

class MarsRoverTest {
    @Test
    fun `coordinate, directory and list of commands are required to initialize rover`() {
        MarsRover(Coordinate(0, 0), Orientation.N, listOf(Forward))
    }
}
