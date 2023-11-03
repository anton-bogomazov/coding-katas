package com.abogomazov.glidedrose.item

class ConjuredItem private constructor(
    name: String,
    sellIn: Int,
    quality: Int
) : Item(name, sellIn, quality) {

    companion object {
        fun of(name: String, sellIn: Int, quality: Int): ConjuredItem {
            assert(quality <= 50)
            return ConjuredItem(name, sellIn, quality)
        }
    }

    override fun age() {
        decreaseQualityBy(2)
        decreaseSellIn()
    }
}
