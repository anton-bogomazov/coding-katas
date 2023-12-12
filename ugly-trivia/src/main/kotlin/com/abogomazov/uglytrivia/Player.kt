package com.abogomazov.uglytrivia

data class Player(
    val id: Int,
    val name: String,
    var inPenaltyBox: Boolean = false,
    var place: Int = 0,
    var score: Int = 0,
)
