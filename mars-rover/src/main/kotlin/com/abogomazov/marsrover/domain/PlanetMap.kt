package com.abogomazov.marsrover.domain

enum class MapEntity {
    Ground, Obstacle
}

data class PlanetMap(
    private val map: List<List<MapEntity>>
) {
    fun entityAt(coordinate: Coordinate): MapEntity {
        val (x, y) = coordinate
        val rY = if (y < 0) map.size + y else y
        val rX = if (x < 0) map.size + x else x

        return map[rY][rX]
    }
}
