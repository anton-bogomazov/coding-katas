package com.abogomazov.uglytrivia

data class Question(
    val text: String,
    val answer: String,
) {
    fun checkAnswer(userAnswer: String) = userAnswer == answer
    override fun toString() = text
}
