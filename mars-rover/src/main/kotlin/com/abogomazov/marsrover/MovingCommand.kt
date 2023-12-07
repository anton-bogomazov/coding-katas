package com.abogomazov.marsrover

interface MovingCommand {
    fun execute(position: Position): Position
}
object Forward : MovingCommand {
    override fun execute(position: Position): Position {
        return position.ahead()
    }
}
object Backward : MovingCommand {
    override fun execute(position: Position): Position {
        return position.behind()
    }
}
object TurnLeft : MovingCommand {
    override fun execute(position: Position): Position {
        return position.copy(orientation = position.orientation.onLeft())
    }
}
object TurnRight : MovingCommand {
    override fun execute(position: Position): Position {
        return position.copy(orientation = position.orientation.onRight())
    }
}
