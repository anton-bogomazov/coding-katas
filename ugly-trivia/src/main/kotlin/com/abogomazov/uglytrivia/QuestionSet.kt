package com.abogomazov.uglytrivia

data class QuestionSet(
    private val questions: List<Questions>
) {
    private val categories = questions.map { it.category }

    fun next(playerPlace: Int): Question {
        val currentCategory = categories[playerPlace % categories.size]
        println("The category is $currentCategory")

        return questions.find { it.category == currentCategory }!!.next()
    }
}
