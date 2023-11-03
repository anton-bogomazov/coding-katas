package com.abogomazov.glidedrose.item

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.AssertionError
import kotlin.test.assertEquals

class AgingItemTest {

    @Test
    fun `ages linearly, +1 quality per day`() {
        val sut = nobleWine()
        sut.age()
        assertEquals(99, sut.getSellIn())
        assertEquals(41, sut.getQuality())
    }

    @Test
    fun `ages linearly, +2 quality per day when expired`() {
        val sut = noblestWine()
        sut.age()
        assertEquals(-1, sut.getSellIn())
        assertEquals(42, sut.getQuality())
    }

    @Test
    fun `can't create with quality exceeds 50`() {
        assertThrows<AssertionError> {
            AgingItem.of("Too Good To Be True", 5, 80)
        }
    }
}

private fun nobleWine() = AgingItem.of("Cabernet Sauvignon", 100, 40)
private fun noblestWine() = AgingItem.of("Cabernet Sauvignon 1963", 0, 40)
