package com.abogomazov.bowling

class Game {
    private var score: Int = 0

    fun roll(nKnockedPins: Int) {
        score += nKnockedPins
    }

    fun score(): Int = score
}
