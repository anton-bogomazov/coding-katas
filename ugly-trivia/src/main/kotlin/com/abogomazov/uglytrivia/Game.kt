package com.abogomazov.uglytrivia

class Game(
    playerNames: List<String>,
    private val questions: QuestionSet,
    private val winScore: Int = 6,
) {
    private val players = playerNames.mapIndexed { i, name -> Player(id = i, name = name) }

    private var currentPlayer = players.first()

    init {
        require(players.size > 1) { "Min number of players is 2" }
        playerNames.forEachIndexed { i, it ->
            println("$it was added")
            println("They are player number " + (i + 1))
        }
    }

    fun roll(roll: Int) {
        println("${currentPlayer.name} is the current player")
        println("They have rolled a $roll")

        if (currentPlayer.inPenaltyBox) {
            currentPlayer.tryToGetOutFromPenaltyBox(roll)
            if (currentPlayer.isGettingOutOfPenaltyBox) {
                println("${currentPlayer.name} is getting out of the penalty box")
            } else {
                println("${currentPlayer.name} is not getting out of the penalty box")
                return
            }
        }
        currentPlayer.calculatePlace(roll)
        println("${currentPlayer.name}'s new location is ${currentPlayer.place}")
        println(questions.next(currentPlayer.place))
    }

    fun wasCorrectlyAnswered(): Boolean {
        if (currentPlayer.isPenalty()) {
            passTurn()
            return true
        }
        println("Answer was correct!!!!")
        currentPlayer.score += 1
        println("${currentPlayer.name} now has ${currentPlayer.score} Gold Coins.")
        val winner = currentPlayer.hasWon(winScore)
        passTurn()
        return winner
    }

    fun wrongAnswer(): Boolean {
        println("Question was incorrectly answered")
        println("${currentPlayer.name} was sent to the penalty box")
        currentPlayer.inPenaltyBox = true
        passTurn()
        return true
    }

    private fun passTurn() {
        if (currentPlayer.id == players.lastIndex) {
            currentPlayer = players[0]
        } else {
            currentPlayer = players[currentPlayer.id + 1]
        }
    }
}
