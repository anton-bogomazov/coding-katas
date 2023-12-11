package com.abogomazov.bowling

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class GameTest {
    @Test
    fun `game initially has zero scores`() {
        assertEquals(0, Game().score())
    }

    @Test
    fun `add n knocked pins to total score`() {
        val sut = Game()
        sut.roll(7)
        assertEquals(7, sut.score())
    }
}
