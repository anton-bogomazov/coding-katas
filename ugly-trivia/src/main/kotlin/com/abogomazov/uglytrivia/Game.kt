package com.abogomazov.uglytrivia

class Game(
    private val playerNames: List<String>,
    private val winScore: Int = 6
) {
    private val players = playerNames.mapIndexed { i, name -> Player(id = i, name = name) }
    private val questions =
        listOf("Pop", "Science", "Sports", "Rock")
            .flatMap { category ->
                (0..49).map { i ->
                    val title = "$category Question $i"
                    Question(category, title)
                }
            }.toMutableList()

    private var currentPlayerId = 0
    private var isGettingOutOfPenaltyBox: Boolean = false

    init {
        require(players.size > 1) { "Min number of players is 2" }
        playerNames.forEachIndexed { i, it ->
            println("$it was added")
            println("They are player number " + (i + 1))
        }
    }

    fun roll(roll: Int) {
        println("${getCurrentPlayer().name} is the current player")
        println("They have rolled a $roll")

        if (getCurrentPlayer().inPenaltyBox) {
            if (roll % 2 != 0) {
                isGettingOutOfPenaltyBox = true

                println("${getCurrentPlayer().name} is getting out of the penalty box")
                getCurrentPlayer().place += roll
                if (getCurrentPlayer().place > 11) getCurrentPlayer().place -= 12

                println("${getCurrentPlayer().name}'s new location is ${getCurrentPlayer().place}")
                println("The category is " + currentCategory())
                askQuestion()
            } else {
                println("${getCurrentPlayer().name} is not getting out of the penalty box")
                isGettingOutOfPenaltyBox = false
            }

        } else {
            getCurrentPlayer().place += roll
            if (getCurrentPlayer().place > 11) getCurrentPlayer().place -= 12

            println("${getCurrentPlayer().name}'s new location is ${getCurrentPlayer().place}")
            println("The category is ${currentCategory()}")
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
        if (getCurrentPlayer().place == 0) return "Pop"
        if (getCurrentPlayer().place == 4) return "Pop"
        if (getCurrentPlayer().place == 8) return "Pop"
        if (getCurrentPlayer().place == 1) return "Science"
        if (getCurrentPlayer().place == 5) return "Science"
        if (getCurrentPlayer().place == 9) return "Science"
        if (getCurrentPlayer().place == 2) return "Sports"
        if (getCurrentPlayer().place == 6) return "Sports"
        if (getCurrentPlayer().place == 10) return "Sports"
        return "Rock"
    }

    fun wasCorrectlyAnswered(): Boolean {
        if (!getCurrentPlayer().inPenaltyBox) {
            println("Answer was corrent!!!!")
            getCurrentPlayer().score += 1
            println("${getCurrentPlayer().name} now has ${getCurrentPlayer().score} Gold Coins.")
            val winner = didPlayerWin()
            currentPlayerId++
            if (currentPlayerId == playerNames.size) {
                currentPlayerId = 0
            }
            return winner
        }
        if (isGettingOutOfPenaltyBox) {
            println("Answer was correct!!!!")
            getCurrentPlayer().score += 1
            println("${getCurrentPlayer().name} now has ${getCurrentPlayer().score} Gold Coins.")
            val winner = didPlayerWin()
            currentPlayerId++
            if (currentPlayerId == playerNames.size) currentPlayerId = 0
            return winner
        }
        currentPlayerId++
        if (currentPlayerId == playerNames.size) currentPlayerId = 0
        return true
    }

    fun wrongAnswer(): Boolean {
        println("Question was incorrectly answered")
        println("${getCurrentPlayer().name} was sent to the penalty box")
        getCurrentPlayer().inPenaltyBox = true

        currentPlayerId++
        if (currentPlayerId == playerNames.size) currentPlayerId = 0
        return true
    }

    private fun didPlayerWin(): Boolean {
        return getCurrentPlayer().score < winScore
    }

    private fun getCurrentPlayer() = players.find { it.id == currentPlayerId }!!
}
