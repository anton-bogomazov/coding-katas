package com.abogomazov.bowling

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class GameTest {
    @Test
    fun `game initially has zero scores`() {
        assertEquals(0, Game().score())
    }

}
