package com.abogomazov.bowling

data class Roll(
    private val value: Int
) {
    init {
        require(value in (0..10)) {
            "score should be in range from 0 to 10"
        }
    }

    fun toInt() = value
}
