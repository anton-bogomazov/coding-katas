package com.abogomazov.uglytrivia.domain

data class Player(
    val id: Int,
    val name: String,
    var inPenaltyBox: Boolean = false,
    var place: Int = 0,
    var score: Int = 0,
) {
    fun hasWon(targetScore: Int) = score >= targetScore

    fun calculatePlace(roll: Int) {
        place += roll
        if (place > 11) {
            place -= 12
        }
    }
}
