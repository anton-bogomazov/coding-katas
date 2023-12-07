package com.abogomazov.gildedrose.item

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.AssertionError
import kotlin.test.assertEquals

class ItemTest {

    @Test
    fun `toString - domain item is a proxy for third party item`() {
        assertEquals("Bread, 3, 5", bread().toString())
    }

    @Test
    fun `getSellIn - domain item is a proxy for third party item`() {
        assertEquals(3, bread().getSellIn())
    }

    @Test
    fun `getQuality - domain item is a proxy for third party item`() {
        assertEquals(5, bread().getQuality())
    }

    @Test
    fun `quality can be increased by specific value`() {
        val sut = bread()
        sut.qualityChangeRate = 10
        sut.increase = true

        sut.age()

        assertEquals(15, sut.getQuality())
    }

    @Test
    fun `quality can't be increased by negative value`() {
        assertThrows<AssertionError> {
            val sut = bread()
            sut.qualityChangeRate = -1
            sut.increase = false

            sut.age()
        }
    }

    @Test
    fun `quality can't exceed 50`() {
        val sut = finestBread()
        sut.qualityChangeRate = 10
        sut.increase = true

        sut.age()

        assertEquals(50, sut.getQuality())
    }

    @Test
    fun `quality can be decreased by 1`() {
        val sut = bread()
        sut.qualityChangeRate = 1
        sut.increase = false

        sut.age()

        assertEquals(4, sut.getQuality())
    }

    @Test
    fun `quality can't be lower than 0`() {
        val sut = poorManBread()
        sut.qualityChangeRate = 1
        sut.increase = false

        sut.age()

        assertEquals(0, sut.getQuality())
    }
}

private fun poorManBread() = TestItem("Bread", 3, 0)
private fun bread() = TestItem("Bread", 3, 5)
private fun finestBread() = TestItem("Finest Bread", 1, 49)

private class TestItem(
    name: String, sellIn: Int, quality: Int
) : Item(name, sellIn, quality) {

    var qualityChangeRate = 1
    var increase = false

    override fun age() {
        if (increase) {
            increaseQualityBy(qualityChangeRate)
        } else {
            decreaseQualityBy(qualityChangeRate)
        }
        decreaseSellIn()
    }
}
