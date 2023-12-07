package com.abogomazov.gildedrose

import com.abogomazov.gildedrose.item.AgingItem
import com.abogomazov.gildedrose.item.ConjuredItem
import com.abogomazov.gildedrose.item.HypingItem
import com.abogomazov.gildedrose.item.Item
import com.abogomazov.gildedrose.item.LegendaryItem
import com.abogomazov.gildedrose.item.RegularItem

object GlidedRoseItemFactory {
    fun create(name: String, sellIn: Int, quality: Int): Item {
        val trimmedName = name.trim()
        return when {
            trimmedName.startsWith("Aged") -> AgingItem.of(trimmedName, sellIn, quality)
            trimmedName.startsWith("Conjured") -> ConjuredItem.of(trimmedName, sellIn, quality)
            trimmedName.startsWith("Sulfuras") -> LegendaryItem.of(trimmedName, sellIn, quality)
            trimmedName.startsWith("Backstage passes") -> HypingItem.of(trimmedName, sellIn, quality)
            else -> RegularItem.of(trimmedName, sellIn, quality)
        }
    }
}
