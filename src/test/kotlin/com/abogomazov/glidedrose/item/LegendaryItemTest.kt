package com.abogomazov.glidedrose.item

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LegendaryItemTest {

    @Test
    fun `ages linearly, -1 quality per day`() {
        val sut = LegendaryItem.of("Pink Pony", 10000, 9999)
        sut.age()
        assertEquals(10000, sut.getSellIn())
        assertEquals(9999, sut.getQuality())
    }
}
