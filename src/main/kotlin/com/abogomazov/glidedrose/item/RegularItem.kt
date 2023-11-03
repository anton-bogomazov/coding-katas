package com.abogomazov.glidedrose.item

class RegularItem private constructor(
    name: String,
    sellIn: Int,
    quality: Int
) : Item(name, sellIn, quality) {

    companion object {
        fun of(name: String, sellIn: Int, quality: Int): RegularItem {
            assert(quality <= 50)
            return RegularItem(name, sellIn, quality)
        }
    }

    override fun age() {
        decreaseQualityBy(qualityChangeRate())
        decreaseSellIn()
    }

    private fun qualityChangeRate() = if (isExpired()) 2 else 1
}
