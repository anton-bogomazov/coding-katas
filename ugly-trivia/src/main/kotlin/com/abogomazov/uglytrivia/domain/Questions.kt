package com.abogomazov.uglytrivia.domain

data class Questions(
    val category: String,
    val questions: MutableList<Question>
) {
    fun next() = questions.removeFirst()
}
