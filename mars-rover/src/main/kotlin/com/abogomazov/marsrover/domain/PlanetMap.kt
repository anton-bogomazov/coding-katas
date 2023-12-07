package com.abogomazov.marsrover.domain

enum class MapEntity {
    Ground, Obstacle
}

data class PlanetMap(
    private val map: List<List<MapEntity>>
) {
    fun entityAt(coordinate: Coordinate): MapEntity =
        map[coordinate.y][coordinate.x]
}
