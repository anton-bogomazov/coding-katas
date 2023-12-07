package com.abogomazov.marsrover

import com.abogomazov.marsrover.domain.Coordinate
import com.abogomazov.marsrover.domain.position
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MarsRoverTest {
    @Test
    fun `initial position is required to construct the rover`() {
        MarsRover(position())
    }

    @Test
    fun `execute updates rover position based on command list`() {
        val sut = MarsRover(position())

        sut.execute(listOf(MoveForward, MoveForward, TurnLeft, MoveBackward, TurnRight, MoveForward))

        assertEquals(Coordinate(x = 1, y = 3), sut.coordinate())
    }
}
