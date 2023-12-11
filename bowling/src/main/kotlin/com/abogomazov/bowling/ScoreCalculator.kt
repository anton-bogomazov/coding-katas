package com.abogomazov.bowling

class ScoreCalculator(
    private val frames: List<Frame>
) {
    fun calculate(): Int =
        frames.flatMap { it.rolls() }.zip(multipliers())
            .sumOf { (value, multiplier) -> value * (multiplier + 1) }

    private fun multipliers(): List<Int> {
        var rollIndex = 0

        val multipliers = frames.flatMapIndexed { i, frame ->
            when {
                i == frames.lastIndex -> listOf()
                frame.isStrike() -> {
                    rollIndex++
                    listOf(rollIndex, rollIndex + 1)
                }
                frame.isSpare() -> {
                    rollIndex += 2
                    listOf(rollIndex)
                }
                else -> {
                    rollIndex += 2
                    emptyList()
                }
            }
        }.groupingBy { it }
            .eachCount()
            .filter { (i, _) -> i in frames.flatMap { it.rolls() }.indices }

        return List(frames.flatMap { it.rolls() }.size) { i -> multipliers[i] ?: 0 }
    }
}
