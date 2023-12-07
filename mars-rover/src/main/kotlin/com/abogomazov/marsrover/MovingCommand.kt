package com.abogomazov.marsrover

interface MovingCommand {
    fun execute(coordinate: Coordinate, direction: Direction): Coordinate
}
object Forward : MovingCommand {
    override fun execute(coordinate: Coordinate, direction: Direction): Coordinate {
        return coordinate
    }
}
object Backward : MovingCommand {
    override fun execute(coordinate: Coordinate, direction: Direction): Coordinate {
        return coordinate
    }
}
