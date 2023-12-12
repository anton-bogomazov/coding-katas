package com.abogomazov.uglytrivia

import kotlin.random.Random

object Dice {
    fun roll() = Random.nextInt(5) + 1
}
