package com.abogomazov.glidedrose

import com.abogomazov.glidedrose.item.AgingItem
import com.abogomazov.glidedrose.item.ConjuredItem
import com.abogomazov.glidedrose.item.HypingItem
import com.abogomazov.glidedrose.item.Item
import com.abogomazov.glidedrose.item.LegendaryItem
import com.abogomazov.glidedrose.item.RegularItem

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
