package com.abogomazov.bowling

private const val TOTAL_PINS = 10

open class Frame {

    protected val rolls = mutableListOf<Roll>()

    companion object {
        fun std() = Frame()
        fun final() = FinalFrame() as Frame
    }

    fun roll(score: Roll) {
        require(!isCompleted()) { "Frame is completed" }
        require(score.toInt() <= pinsLeft()) {
            "Score ${score.toInt()} exceeds max possible of ${pinsLeft()}"
        }

        rolls.add(score)
    }

    open fun isCompleted() = rolls.size == 2 || isStrike()
    open fun score() = rolls.sumOf { it.toInt() }

    protected fun isStrike() = rolls.size == 1 && rolls.first().toInt() == 10
    protected fun isSpare() = rolls.size == 2 && rolls.sumOf { it.toInt() } == 10
    protected open fun pinsLeft() = TOTAL_PINS - rolls.sumOf { it.toInt() }

    private class FinalFrame : Frame() {
        override fun isCompleted(): Boolean {
            if (rolls.size == 3) return true
            if (isSpare() || isStrike()) return false
            if (rolls.size == 2) return true

            return false
        }

        override fun pinsLeft(): Int {
            if (isSpare() || isStrike()) return 10

            return super.pinsLeft()
        }
    }
}
