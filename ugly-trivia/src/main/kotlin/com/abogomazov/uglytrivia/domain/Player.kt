package com.abogomazov.uglytrivia.domain

data class Player(
    val id: Int,
    val name: String,
    private var inPenaltyBox: Boolean = false,
    private var place: Int = 0,
    private var score: Int = 0,
) {
    fun hasWon(targetScore: Int) = score >= targetScore

    fun place() = place
    fun moveForwardOn(n: Int) {
        place += n
        if (place > 11) {
            place -= 12
        }
    }

    fun inPenaltyBox() = inPenaltyBox
    fun putInPenaltyBox() {
        inPenaltyBox = true
    }

    fun addScore() {
        score += 1
    }
    fun score() = score
}
