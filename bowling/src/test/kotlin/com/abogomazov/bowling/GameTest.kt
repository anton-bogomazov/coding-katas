package com.abogomazov.bowling

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class GameTest {
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
