package com.abogomazov.bowling

open class Frame protected constructor() {

    protected val rolls = mutableListOf<Roll>()

    companion object {
        fun std(): Frame = Frame()
        fun final(): Frame = FinalFrame()

        private const val MAX_ROLLS = 2
        private const val TOTAL_PINS = 10
    }

    fun roll(score: Roll) {
        require(!isCompleted()) { "Frame is completed" }
        require(score.toInt() <= pinsLeft()) {
            "Score ${score.toInt()} exceeds max possible of ${pinsLeft()}"
        }
        rolls.add(score)
    }

    fun score() = rolls.sumOf { it.toInt() }

    open fun isCompleted() = rolls.size == MAX_ROLLS || isStrike()

    protected open fun isStrike() = allPinsKnocked() && rolls.size == 1
    protected fun isSpare() = allPinsKnocked() && rolls.size == MAX_ROLLS
    private fun allPinsKnocked() = score() == TOTAL_PINS

    protected open fun pinsLeft() = TOTAL_PINS - rolls.sumOf { it.toInt() }

    private class FinalFrame : Frame() {
        companion object {
            private const val MAX_ROLLS_EXTENDED = 3
        }

        override fun isCompleted(): Boolean {
            if (rolls.size == 2 && !isBonusRollAllowed()) return true

            return rolls.size == MAX_ROLLS_EXTENDED
        }

        override fun pinsLeft(): Int {
            if (isBonusRollAllowed()) return TOTAL_PINS
            return super.pinsLeft()
        }

        private fun isBonusRollAllowed() = isSpare() || isStrike()

        override fun isStrike(): Boolean {
            fun isStrikeRoll(n: Int) = rolls.size == n && rolls[n - 1].toInt() == TOTAL_PINS
            return isStrikeRoll(1) || isStrikeRoll(2) || isStrikeRoll(3)
        }
    }
}
