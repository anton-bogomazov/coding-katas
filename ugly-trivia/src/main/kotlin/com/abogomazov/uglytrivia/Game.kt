package com.abogomazov.uglytrivia

import java.util.*

class Game(
    private val players: List<String>,
    private val winScore: Int = 6
) {
    private val places = IntArray(players.size)
    private val purses = IntArray(players.size)
    private val inPenaltyBox = BooleanArray(players.size)

    private val questions =
        listOf("Pop", "Science", "Sports", "Rock")
            .flatMap { category ->
                (0..49).map { i ->
                    val title = "$category Question $i"
                    Question(category, title)
                }
            }.toMutableList()

    private var currentPlayer = 0
    private var isGettingOutOfPenaltyBox: Boolean = false

    init {
        require(players.size > 1) { "Min number of players is 2" }
        players.forEachIndexed { i, it ->
            println(it + " was added")
            println("They are player number " + (i + 1))
        }
    }

    fun roll(roll: Int) {
        println(players[currentPlayer].toString() + " is the current player")
        println("They have rolled a " + roll)

        if (inPenaltyBox[currentPlayer]) {
            if (roll % 2 != 0) {
                isGettingOutOfPenaltyBox = true

                println(players[currentPlayer].toString() + " is getting out of the penalty box")
                places[currentPlayer] = places[currentPlayer] + roll
                if (places[currentPlayer] > 11) places[currentPlayer] = places[currentPlayer] - 12

                println(players[currentPlayer].toString()
                        + "'s new location is "
                        + places[currentPlayer])
                println("The category is " + currentCategory())
                askQuestion()
            } else {
                println(players[currentPlayer].toString() + " is not getting out of the penalty box")
                isGettingOutOfPenaltyBox = false
            }

        } else {

            places[currentPlayer] = places[currentPlayer] + roll
            if (places[currentPlayer] > 11) places[currentPlayer] = places[currentPlayer] - 12

            println(players[currentPlayer].toString()
                    + "'s new location is "
                    + places[currentPlayer])
            println("The category is " + currentCategory())
            askQuestion()
        }

    }

    private fun askQuestion() {
        val question = questions.find { it.category == currentCategory() }
            ?: error("no question of category ${currentCategory()}")
        questions.remove(question)
        println(question)
    }

    private fun currentCategory(): String {
        if (places[currentPlayer] == 0) return "Pop"
        if (places[currentPlayer] == 4) return "Pop"
        if (places[currentPlayer] == 8) return "Pop"
        if (places[currentPlayer] == 1) return "Science"
        if (places[currentPlayer] == 5) return "Science"
        if (places[currentPlayer] == 9) return "Science"
        if (places[currentPlayer] == 2) return "Sports"
        if (places[currentPlayer] == 6) return "Sports"
        if (places[currentPlayer] == 10) return "Sports"
        return "Rock"
    }

    fun wasCorrectlyAnswered(): Boolean {
        if (!inPenaltyBox[currentPlayer]) {
            println("Answer was corrent!!!!")
            purses[currentPlayer]++
            println(players[currentPlayer] + " now has " + purses[currentPlayer] + " Gold Coins.")
            val winner = didPlayerWin()
            currentPlayer++
            if (currentPlayer == players.size) {
                currentPlayer = 0
            }
            return winner
        }
        if (isGettingOutOfPenaltyBox) {
            println("Answer was correct!!!!")
            purses[currentPlayer]++
            println(players[currentPlayer] + " now has " + purses[currentPlayer] + " Gold Coins.")
            val winner = didPlayerWin()
            currentPlayer++
            if (currentPlayer == players.size) currentPlayer = 0
            return winner
        }
        currentPlayer++
        if (currentPlayer == players.size) currentPlayer = 0
        return true
    }

    fun wrongAnswer(): Boolean {
        println("Question was incorrectly answered")
        println(players[currentPlayer] + " was sent to the penalty box")
        inPenaltyBox[currentPlayer] = true

        currentPlayer++
        if (currentPlayer == players.size) currentPlayer = 0
        return true
    }

    private fun didPlayerWin(): Boolean {
        return purses[currentPlayer] < winScore
    }
}
