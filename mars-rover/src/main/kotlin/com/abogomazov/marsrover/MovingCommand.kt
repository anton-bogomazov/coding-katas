package com.abogomazov.marsrover

interface MovingCommand {
    fun execute(coordinate: Coordinate, orientation: Orientation): Coordinate
}
object Forward : MovingCommand {
    override fun execute(coordinate: Coordinate, orientation: Orientation): Coordinate {
        return coordinate
    }
}
object Backward : MovingCommand {
    override fun execute(coordinate: Coordinate, orientation: Orientation): Coordinate {
        return coordinate
    }
}
