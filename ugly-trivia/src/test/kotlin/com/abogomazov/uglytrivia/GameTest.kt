package com.abogomazov.uglytrivia

import com.abogomazov.uglytrivia.domain.QuestionSet
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class GameTest {
    @Test
    fun `2 or more players can play the game`() {
        Game(listOf("Ben", "Ten"), emptyQuestionSet())
    }

    @Test
    fun `cannot create a game for 1 player`() {
        assertThrows<IllegalArgumentException> {
            Game(listOf("Joe"), emptyQuestionSet())
        }
    }

    @Test
    fun `cannot create a game without players`() {
        assertThrows<IllegalArgumentException> {
            Game(emptyList(), emptyQuestionSet())
        }
    }
}

private fun emptyQuestionSet() = QuestionSet(emptyList())
