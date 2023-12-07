package com.abogomazov.gildedrose.item

import kotlin.math.max
import kotlin.math.min
import com.abogomazov.gildedrose.thirdparty.Item as TpItem

abstract class Item(
    name: String, sellIn: Int, quality: Int
) {
    private val thirdPartyItem = TpItem(name, sellIn, quality)

    abstract fun age()

    fun getQuality() = thirdPartyItem.quality

    fun getSellIn() = thirdPartyItem.sellIn

    protected fun increaseQualityBy(value: Int) {
        assert(value >= 0)
        thirdPartyItem.quality = min(getQuality() + value, 50)
    }

    protected fun decreaseQualityBy(value: Int) {
        assert(value >= 0)
        thirdPartyItem.quality = max(getQuality() - value, 0)
    }

    protected fun resetQuality() {
        thirdPartyItem.quality = 0
    }

    protected fun decreaseSellIn() {
        thirdPartyItem.sellIn -= 1
    }

    override fun toString() = thirdPartyItem.toString()
}

fun Item.isExpired() = getSellIn() <= 0
