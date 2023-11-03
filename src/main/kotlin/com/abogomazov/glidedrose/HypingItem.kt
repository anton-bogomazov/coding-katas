package com.abogomazov.glidedrose

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
        when (getSellIn()) {
            in Int.MIN_VALUE..<0 -> resetQuality()
            in 0..5 -> increaseQualityBy(3)
            in 6..10 -> increaseQualityBy(2)
            else -> increaseQualityBy(1)
        }
        decreaseSellIn()
    }
}
