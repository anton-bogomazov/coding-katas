package com.abogomazov.glidedrose

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.AssertionError
import kotlin.test.assertEquals

class HypingItemTest {

    @Test
    fun `quality is growing by one if sellIn more than 10`() {
        val sut = fanZoneTicket(11)
        sut.age()
        assertEquals(10, sut.getSellIn())
        assertEquals(11, sut.getQuality())
    }

    @Test
    fun `quality is growing faster if sellIn in 5-10`() {
        val sut = fanZoneTicket(10)
        sut.age()
        assertEquals(9, sut.getSellIn())
        assertEquals(12, sut.getQuality())
    }

    @Test
    fun `quality is growing even faster if almost expired`() {
        val sut = fanZoneTicket(5)
        sut.age()
        assertEquals(4, sut.getSellIn())
        assertEquals(13, sut.getQuality())
    }


    @Test
    fun `can't create with quality exceeds 50`() {
        assertThrows<AssertionError> {
            HypingItem.of("Too Good To Be True", 5, 80)
        }
    }

    @Test
    fun `quality of expired items is 0`() {
        val sut = fanZoneTicket(-1)
        sut.age()
        assertEquals(-2, sut.getSellIn())
        assertEquals(0, sut.getQuality())
    }
}

private fun fanZoneTicket(sellInt: Int) = HypingItem.of("Ticket", sellInt, 10)
