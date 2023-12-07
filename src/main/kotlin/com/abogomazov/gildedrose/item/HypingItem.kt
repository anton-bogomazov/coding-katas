package com.abogomazov.gildedrose.item

class HypingItem private constructor(
    name: String,
    sellIn: Int,
    quality: Int
) : Item(name, sellIn, quality) {

    companion object {
        fun of(name: String, sellIn: Int, quality: Int): HypingItem {
            assert(quality <= 50)
            val correctedQuality = if (sellIn < 0) 0 else quality
            return HypingItem(name, sellIn, correctedQuality)
        }
    }

    override fun age() {
        if (isExpired()) {
            resetQuality()
        } else {
            increaseQualityBy(qualityChangeRate())
        }
        decreaseSellIn()
    }

    private fun qualityChangeRate() =
        when (getSellIn()) {
            in 1..5 -> 3
            in 6..10 -> 2
            else -> 1
        }
}
