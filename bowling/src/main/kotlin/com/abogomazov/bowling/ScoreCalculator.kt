package com.abogomazov.bowling

class ScoreCalculator(
    private val frames: List<Frame>
) {
    private val rollToMultiplier =
        frames.flatMap { it.rolls() }.map { it to 1 }.toMutableList()

    fun calculate(): Int {
        setMultipliers()
        return rollToMultiplier.sumOf { (value, multiplier) -> value * multiplier }
    }

    private fun setMultipliers() {
        var currentRollIdx = 0
        for ((i, frame) in frames.withIndex()) {
            if (i == frames.lastIndex || !frame.isCompleted()) return

            if (frame.isStrike()) {
                currentRollIdx++
                rollToMultiplier.increment(currentRollIdx)
                rollToMultiplier.increment(currentRollIdx + 1)
            } else if (frame.isSpare()) {
                currentRollIdx += 2
                rollToMultiplier.increment(currentRollIdx)
            } else {
                currentRollIdx += 2
            }
        }
    }

    private fun MutableList<Pair<Int, Int>>.increment(idx: Int) {
        if (idx !in this.indices) {
            // safely ignore if there are no rolls to multiply
            return
        }
        this[idx] = this[idx].first to this[idx].second + 1
    }
}
