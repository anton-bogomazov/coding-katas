package com.abogomazov.glidedrose.item

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.AssertionError
import kotlin.test.assertEquals

class ConjuredItemTest {

    @Test
    fun `ages linearly, -2 quality per day`() {
        val sut = bellBottomGreenJeans()
        sut.age()
        assertEquals(14, sut.getSellIn())
        assertEquals(38, sut.getQuality())
    }

    @Test
    fun `can't create with quality exceeds 50`() {
        assertThrows<AssertionError> {
            ConjuredItem.of("Too Good To Be True", 5, 80)
        }
    }
}

private fun bellBottomGreenJeans() =
    ConjuredItem.of("Disco Jeans", 15, 40)
