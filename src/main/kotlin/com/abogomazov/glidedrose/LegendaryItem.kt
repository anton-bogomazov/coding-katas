package com.abogomazov.glidedrose

class LegendaryItem private constructor(
    name: String,
    sellIn: Int,
    quality: Int
) : Item(name, sellIn, quality) {

    companion object {
        fun of(name: String, sellIn: Int, quality: Int): LegendaryItem {
            // Legendary item can be created with any sellIn and quality
            return LegendaryItem(name, sellIn, quality)
        }
    }

    override fun age() {
        // Legendary item is not aging
    }
}
