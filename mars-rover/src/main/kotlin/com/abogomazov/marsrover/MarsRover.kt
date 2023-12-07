package com.abogomazov.marsrover

import com.abogomazov.marsrover.domain.Position

class MarsRover(
    private val position: Position,
    private val commands: List<MovingCommand>
) {
}
