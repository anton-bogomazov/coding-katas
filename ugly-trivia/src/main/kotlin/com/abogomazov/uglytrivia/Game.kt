package com.abogomazov.uglytrivia

class Game(
    playerNames: List<String>,
    private val winScore: Int = 6
) {
    private val players = playerNames.mapIndexed { i, name -> Player(id = i, name = name) }
    private val categories = listOf("Pop", "Science", "Sports", "Rock")
    private val questions =
        categories.flatMap { category ->
                (0..49).map { i ->
                    val title = "$category Question $i"
                    Question(category, title)
                }
            }.toMutableList()

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
            if (roll % 2 == 0) {
                println("${currentPlayer.name} is not getting out of the penalty box")
                currentPlayer.isGettingOutOfPenaltyBox = false
                return
            }
            currentPlayer.isGettingOutOfPenaltyBox = true
            println("${currentPlayer.name} is getting out of the penalty box")
        }
        calculatePlace(roll)
        println("${currentPlayer.name}'s new location is ${currentPlayer.place}")
        println("The category is ${currentCategory()}")
        askQuestion()
    }

    private fun calculatePlace(roll: Int) {
        currentPlayer.place += roll
        if (currentPlayer.place > 11) currentPlayer.place -= 12
    }

    private fun askQuestion() {
        val question = questions.find { it.category == currentCategory() }
            ?: error("no question of category ${currentCategory()}")
        questions.remove(question)
        println(question)
    }

    private fun currentCategory(): String {
        return categories[currentPlayer.place % 4]
    }

    fun wasCorrectlyAnswered(): Boolean {
        if (currentPlayer.inPenaltyBox && !currentPlayer.isGettingOutOfPenaltyBox) {
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
