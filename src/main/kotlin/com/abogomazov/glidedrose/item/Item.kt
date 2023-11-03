package com.abogomazov.glidedrose.item

import kotlin.math.max
import kotlin.math.min
import com.abogomazov.glidedrose.thirdparty.Item as TpItem

abstract class Item(
    name: String, sellIn: Int, quality: Int
) {
    private val thirdPartyItem = TpItem(name, sellIn, quality)

    abstract fun age()

    fun getQuality() = thirdPartyItem.quality

    fun getSellIn() = thirdPartyItem.sellIn

    internal fun increaseQualityBy(value: Int) {
        assert(value >= 0)
        thirdPartyItem.quality = min(getQuality() + value, 50)
    }

    internal fun decreaseQualityBy(value: Int) {
        thirdPartyItem.quality = max(getQuality() - value, 0)
    }

    internal fun resetQuality() {
        thirdPartyItem.quality = 0
    }

    internal fun decreaseSellIn() {
        thirdPartyItem.sellIn -= 1
    }

    override fun toString() = thirdPartyItem.toString()
}
