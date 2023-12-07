package com.abogomazov.marsrover

import com.abogomazov.marsrover.domain.Position

class MarsRover(
    private var position: Position,
) {
    fun execute(commands: List<MovingCommand>) {
        this.position = commands.fold(position) { position, command ->
            command.execute(position)
        }
    }

    fun coordinate() = position.coordinate
}
