package com.abogomazov.marsrover

import com.abogomazov.marsrover.domain.Coordinate
import com.abogomazov.marsrover.domain.freePlanetMap
import com.abogomazov.marsrover.domain.planetMapWithObstaclesAt
import com.abogomazov.marsrover.domain.position
import com.abogomazov.marsrover.domain.soleObstacleSquareMap10
import org.junit.jupiter.api.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals

class MarsRoverTest {
    @Test
    fun `initial position is required to construct the rover`() {
        MarsRover(position(), freePlanetMap(), OneRecordLog())
    }

    @Test
    fun `execute updates rover position based on command list`() {
        val sut = MarsRover(position(coordinate = Coordinate(2, 2)), freePlanetMap(), OneRecordLog())

        sut.execute(listOf(
            MoveBackward, MoveBackward, MoveBackward, MoveBackward,
            TurnLeft, TurnLeft,
            MoveForward, MoveBackward,
            TurnRight, MoveForward, MoveForward, TurnRight,
            MoveForward, MoveForward, TurnLeft,
            MoveForward, TurnRight, MoveForward,
            TurnRight, TurnRight, TurnRight, TurnRight,
            MoveForward
        ))

        assertEquals(Coordinate(-1, 2), sut.coordinate())
    }

    @Test
    fun `rover can go round the world infinite number of times`() {
        val sut = MarsRover(position(coordinate = Coordinate(2, 2)), soleObstacleSquareMap10(), OneRecordLog())
        val commands = List(1000) { MoveBackward }

        sut.execute(commands)

        assertEquals(Coordinate(2, -998), sut.coordinate())
    }

    @Test
    fun `rollback in case of encountering obstacle`() {
        val log = OneRecordLog()
        val sut = MarsRover(position(), planetMapWithObstaclesAt(listOf(Coordinate(2, 1))), log)

        sut.execute(listOf(MoveForward, TurnRight, MoveForward, MoveForward))

        assertEquals(Coordinate(1, 1), sut.coordinate())

        assertContains(log.record, "Obstacle detected")
        assertContains(log.record, Coordinate(2, 1).toString())
        assertContains(log.record, Coordinate(1, 1).toString())
    }
}

private class OneRecordLog : Log {
    lateinit var record: String

    override fun append(message: String) {
        record = message
    }
}
