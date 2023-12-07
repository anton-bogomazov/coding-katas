package com.abogomazov.marsrover.domain

enum class MapEntity {
    Ground, Obstacle
}

data class PlanetMap(
    private val map: List<List<MapEntity>>
) {
    fun entityAt(coordinate: Coordinate): MapEntity {
        val (x, y) = coordinate
        val rY = if (y < 0) map.lastIndex + y % map.lastIndex else y % map.lastIndex
        val rX = if (x < 0) map.lastIndex + x % map.lastIndex else x % map.lastIndex

        return map[rY][rX]
    }
}
