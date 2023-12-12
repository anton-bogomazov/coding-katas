package com.abogomazov.uglytrivia

data class QuestionSet(
    private val categories: List<String>,
    private val questions: MutableList<Question>
) {
    fun next(playerPlace: Int): Question {
        val currentCategory = categories[playerPlace % categories.size]
        println("The category is $currentCategory")
        val question = questions.find { it.category == currentCategory }
            ?: error("no question of category $currentCategory")
        questions.remove(question)

        return question
    }
}
