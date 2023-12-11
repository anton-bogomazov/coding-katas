package com.abogomazov.bowling

class Game {
    private var score: Int = 0

    fun roll(nKnockedPins: Int) {
        require(nKnockedPins in (0..10)) {
            "n knocked pins should be in range from 0 to 10"
        }
        score += nKnockedPins
    }

    fun score(): Int = score
}
