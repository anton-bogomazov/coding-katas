package com.abogomazov.marsrover

fun position(
    coordinate: Coordinate = Coordinate(0, 0),
    orientation: Orientation = Orientation.N,
) = Position(coordinate, orientation)
