package com.abogomazov.marsrover

import com.abogomazov.marsrover.domain.MapEntity
import com.abogomazov.marsrover.domain.PlanetMap
import com.abogomazov.marsrover.domain.Position

class MarsRover(
    private var position: Position,
    private val map: PlanetMap,
    private val log: Log,
) {
    fun execute(commands: List<MovingCommand>) {
        this.position = calculateNewPosition(commands)
    }

    private fun calculateNewPosition(commands: List<MovingCommand>): Position {
        return commands.fold(position) { currentPosition, command ->
            val newPosition = command.execute(currentPosition)
            if (map.entityAt(newPosition.coordinate) == MapEntity.Obstacle) {
                log.append("Obstacle detected at ${newPosition.coordinate}! " +
                        "Retreating to safe ${currentPosition.coordinate}.")
                return currentPosition
            }
            newPosition
        }
    }

    fun coordinate() = position.coordinate
}

fun interface Log {
    fun append(message: String)
}
