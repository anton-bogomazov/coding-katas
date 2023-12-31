package com.abogomazov.bowling

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class GameTest {
    @Test
    fun `total score for finished game is calculated correctly`() {
        val sut = finishedGame()
        assertEquals(115, sut.score())
    }

    @Test
    fun `total score for non-completed game is calculated correctly`() {
        val sut = unfinishedGame()
        assertEquals(44, sut.score())
    }

    @Test
    fun `total score of 300 can be earned in perfect game`() {
        val sut = perfectGame()
        assertEquals(300, sut.score())
    }

    @Test
    fun `cannot roll after the game is finished`() {
        assertThrows<IllegalArgumentException> {
            finishedGame().roll(3)
        }
    }

    @Test
    fun `game initially has zero scores`() {
        assertEquals(0, Game().score())
    }

    @Test
    fun `add n knocked pins to total score`() {
        val sut = Game()
        sut.roll(10)
        assertEquals(10, sut.score())
    }

    @Test
    fun `n knocked pins should be positive`() {
        val sut = Game()
        assertThrows<IllegalArgumentException> {
            sut.roll(-1)
        }
    }

    @Test
    fun `n knocked pins cannot exceed 10`() {
        val sut = Game()
        assertThrows<IllegalArgumentException> {
            sut.roll(11)
        }
    }
}
