package com.abogomazov.glidedrose

class AgingItem private constructor(
    name: String,
    sellIn: Int,
    quality: Int
) : Item(name, sellIn, quality) {

    companion object {
        fun of(name: String, sellIn: Int, quality: Int): AgingItem {
            assert(quality <= 50)
            return AgingItem(name, sellIn, quality)
        }

    }

    override fun age() {
        increaseQualityBy(1)
        decreaseSellIn()
    }
}
