package com.abogomazov.marsrover

import org.junit.jupiter.api.Test

class MarsRoverTest {
    @Test
    fun `coordinate and directory are required to initialize rover`() {
        MarsRover(Coordinate(0, 0), Direction.N)
    }
}
