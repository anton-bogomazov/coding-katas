package com.abogomazov.marsrover.domain

fun position(
    coordinate: Coordinate = Coordinate(0, 0),
    orientation: Orientation = Orientation.N,
) = Position(coordinate, orientation)

fun freePlanetMap(size: Pair<Int, Int> = 100 to 100) =
    PlanetMap(
        List(size.first) { List(size.second) { MapEntity.Ground } }
    )

fun planetMapWithObstaclesAt(
    coordinates: List<Coordinate>,
    size: Pair<Int, Int> = 100 to 100,
) = PlanetMap(
        List(size.first) { i ->
            List(size.second) { j ->
                val coordinate = Coordinate(x = j, y = i)
                if (coordinate in coordinates) {
                    MapEntity.Obstacle
                } else {
                    MapEntity.Ground
                }
            }
        }
    )
