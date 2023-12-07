package com.abogomazov.marsrover

interface MovingCommand {
    fun execute(position: Position): Position
}
object Forward : MovingCommand {
    override fun execute(position: Position): Position {
        return position
    }
}
object Backward : MovingCommand {
    override fun execute(position: Position): Position {
        return position
    }
}
