package com.abogomazov.uglytrivia

fun main(args: Array<String>) {
    GameRunner.run()
}

object GameRunner {
    fun run() {
        val game = Game(
            listOf("Chet", "Pat", "Sue"),
            QuestionSet(
                listOf(
                    Questions("Pop", (0..49).map { Question("Pop Question $it", "correct") }.toMutableList()),
                    Questions("Science", (0..49).map { Question("Science Question $it", "correct") }.toMutableList()),
                    Questions("Sports", (0..49).map { Question("Sports Question $it", "correct") }.toMutableList()),
                    Questions("Rock", (0..49).map { Question("Rock Question $it", "correct") }.toMutableList()),
                )
            )
        )

        while (!game.finished()) {
            val question = game.roll(Sequence.next(5) + 1)
            val answer = if (Sequence.next(9) == 7) "wrong" else "correct"
            question ?: continue
            if (question.checkAnswer(answer)) {
                game.wasCorrectlyAnswered()
            } else {
                game.wrongAnswer()
            }
        }
    }
}

object Sequence {
    private val sequence = List(100) { it }.iterator()

    fun next(until: Int): Int {
        return sequence.next() % until
    }
}
