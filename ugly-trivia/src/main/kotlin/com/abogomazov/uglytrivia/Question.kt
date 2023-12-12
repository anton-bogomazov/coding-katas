package com.abogomazov.uglytrivia

data class Question(
    val category: String,
    val text: String,
) {
    override fun toString() = text
}
