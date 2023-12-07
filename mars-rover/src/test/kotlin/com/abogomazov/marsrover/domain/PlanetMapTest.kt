package com.abogomazov.marsrover.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PlanetMapTest {

    @Test
    fun `entity at return map entity by coordinate`() {
        val sut = soleObstacleSquareMap10(obstacleAt = Coordinate(1, 3))
        assertEquals(MapEntity.Obstacle, sut.entityAt(Coordinate(1, 3)))
    }

    @Test
    fun `wrap map n times if coordinate exceeds map size`() {
        val sut = soleObstacleSquareMap10(obstacleAt = Coordinate(1, 3))
        assertEquals(MapEntity.Obstacle, sut.entityAt(Coordinate(10, -15)))
    }
}
