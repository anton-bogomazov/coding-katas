package com.abogomazov.marsrover.domain

import com.abogomazov.marsrover.domain.Coordinate
import com.abogomazov.marsrover.domain.Orientation
import com.abogomazov.marsrover.domain.Position

fun position(
    coordinate: Coordinate = Coordinate(0, 0),
    orientation: Orientation = Orientation.N,
) = Position(coordinate, orientation)
