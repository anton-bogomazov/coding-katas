package com.abogomazov.bowling

class Game {
    private val frames = List(10) { i -> if (i == 9) Frame.final() else Frame.std() }

    private var currentFrameIdx = 0
    private var isGameFinished = false

    fun roll(nKnockedPins: Int) {
        require(!isGameFinished) { "Game is already finished" }
        val currentFrame = frames[currentFrameIdx]

        currentFrame.roll(Roll(nKnockedPins))

        if (currentFrame.isCompleted()) {
            currentFrameIdx += 1
        }
        if (currentFrameIdx == 10) {
            isGameFinished = true
        }
    }

    fun score(): Int = ScoreCalculator(frames).calculate()
}
