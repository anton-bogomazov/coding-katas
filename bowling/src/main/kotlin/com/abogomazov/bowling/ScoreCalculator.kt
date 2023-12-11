package com.abogomazov.bowling

class ScoreCalculator(
    private val frames: List<Frame>
) {

    companion object {
        private const val STRIKE_BONUS_ROLLS = 2
        private const val SPARE_BONUS_ROLLS = 1
    }

    private val rollValueToMultiplier = frames.flatMap { it.rolls() }.map { it to 1 }.toMutableList()
    private var currentRollIdx = 0

    fun calculate(): Int {
        setMultipliers()
        return calc()
    }

    fun setMultipliers() {
        for ((i, frame) in frames.withIndex()) {
            if (i == frames.lastIndex) continue
            if (frame.isStrike()) {
                currentRollIdx++
                increment(currentRollIdx)
                increment(currentRollIdx + 1)
            } else if (frame.isSpare()) {
                currentRollIdx++
                currentRollIdx++
                increment(currentRollIdx)
            } else {
                currentRollIdx += 2
            }
        }
    }

    fun calc(): Int {
        var result = 0
        for ((value, multiplier) in rollValueToMultiplier) {
            result += value * multiplier
        }
        return result
    }

    fun increment(idx: Int) {
        try {
            rollValueToMultiplier[idx] = rollValueToMultiplier[idx].first to rollValueToMultiplier[idx].second + 1
        } catch (e: Exception) {}
    }

}
