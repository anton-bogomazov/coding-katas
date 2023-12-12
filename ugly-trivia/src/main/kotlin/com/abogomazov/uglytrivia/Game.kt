package com.abogomazov.uglytrivia

import com.abogomazov.uglytrivia.domain.Player
import com.abogomazov.uglytrivia.domain.Question
import com.abogomazov.uglytrivia.domain.QuestionSet

class Game(
    playerNames: List<String>,
    private val questions: QuestionSet,
    private val winScore: Int = 6,
) {
    init {
        require(playerNames.size > 1) { "Min number of players is 2" }
        playerNames.forEachIndexed { i, it ->
            println("$it was added")
            println("They are player number " + (i + 1))
        }
    }
    private val players = playerNames.mapIndexed { i, name -> Player(id = i, name = name) }

    private var finished: Boolean = false

    private var currentPlayer = players.first()

    fun roll(roll: Int): Question? {
        println("${currentPlayer.name} is the current player")
        println("They have rolled a $roll")

        if (currentPlayer.inPenaltyBox) {
            currentPlayer.tryToGetOutFromPenaltyBox(roll)
            if (currentPlayer.isGettingOutOfPenaltyBox) {
                println("${currentPlayer.name} is getting out of the penalty box")
            } else {
                println("${currentPlayer.name} is not getting out of the penalty box")
                passTurn()
                return null
            }
        }
        currentPlayer.calculatePlace(roll)
        println("${currentPlayer.name}'s new location is ${currentPlayer.place}")
        val question = questions.next(currentPlayer.place)
        println(question)
        return question
    }

    fun wasCorrectlyAnswered() {
        if (currentPlayer.isPenalty()) {
            passTurn()
            return
        }
        println("Answer was correct!!!!")
        currentPlayer.score += 1
        println("${currentPlayer.name} now has ${currentPlayer.score} Gold Coins.")
        finished = currentPlayer.hasWon(winScore)
        passTurn()
    }

    fun wrongAnswer() {
        println("Question was incorrectly answered")
        println("${currentPlayer.name} was sent to the penalty box")
        currentPlayer.inPenaltyBox = true
        passTurn()
    }

    private fun passTurn() {
        if (currentPlayer.id == players.lastIndex) {
            currentPlayer = players[0]
        } else {
            currentPlayer = players[currentPlayer.id + 1]
        }
    }

    fun finished() = finished
}
