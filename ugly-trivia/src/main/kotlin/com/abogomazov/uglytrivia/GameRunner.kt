package com.abogomazov.uglytrivia

fun main(args: Array<String>) {
    GameRunner.run()
}

object GameRunner {
    var notAWinner: Boolean = false

    fun run() {
        val aGame = Game()

        aGame.add("Chet")
        aGame.add("Pat")
        aGame.add("Sue")

        val rand = Sequence

        do {

            aGame.roll(rand.nextInt(5) + 1)

            if (rand.nextInt(9) == 7) {
                GameRunner.notAWinner = aGame.wrongAnswer()
            } else {
                GameRunner.notAWinner = aGame.wasCorrectlyAnswered()
            }


        } while (GameRunner.notAWinner)

    }
}

object Sequence {
    private val sequence = List(100) { it }.iterator()

    fun nextInt(until: Int): Int {
        return sequence.next() % until
    }
}
