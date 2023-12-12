package com.abogomazov.uglytrivia

import com.abogomazov.uglytrivia.domain.Question
import com.abogomazov.uglytrivia.domain.QuestionSet
import com.abogomazov.uglytrivia.domain.Questions

class NextgenGameRunner {
    private val players = listOf("John", "Roger", "Marie", "Tim")
    private val scienceQuestions = listOf(
        "Which of the planets in our solar system is the hottest?" to "Venus",
        "What are the three layers of the planet?" to "Crust, mantle and core",
        "Which is the only metal to be in liquid form at room temperature?" to "Mercury",
    )
    private val sportsQuestions = listOf(
        "What sport were women allowed to play in the Olympics for the first time?" to "Tennis",
        "What six-letter word names both a seed company and an exercise that combines a squat, a pushup and a jump in the air?" to "Burpee",
        "How many players are on each side of the net in beach volleyball?" to "2",
    )

    private val game = Game(
        playerNames = players,
        questions = QuestionSet(
            listOf(
                Questions("Science", scienceQuestions.map {
                        (q, a) -> Question(text = q, answer = a) }.toMutableList()
                ),
                Questions("Sports", sportsQuestions.map {
                        (q, a) -> Question(text = q, answer = a) }.toMutableList()
                ),
            ))
    )

    fun run() {
        while (!game.finished()) {
            val question = game.roll(Dice.roll()) ?: continue
            if (question.checkAnswer(readln())) {
                game.wasCorrectlyAnswered()
            } else {
                game.wrongAnswer()
            }
        }
    }
}

fun main() {
    NextgenGameRunner().run()
}

