package com.abogomazov.marsrover

import com.abogomazov.marsrover.domain.Position

fun interface MovingCommand {
    fun execute(position: Position): Position
}

val MoveForward = MovingCommand { position -> position.ahead() }
val MoveBackward = MovingCommand { position -> position.behind() }

val TurnLeft = MovingCommand { position ->
    position.copy(
        orientation = position.orientation.onLeft()
    )
}
val TurnRight = MovingCommand { position ->
    position.copy(
        orientation = position.orientation.onRight()
    )
}
