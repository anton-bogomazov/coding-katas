package com.abogomazov.gildedrose

import com.abogomazov.gildedrose.item.Item

class GildedRoseApplication private constructor(
    private val items: List<Item>
) {
    companion object {
        fun with(items: List<Item>) = GildedRoseApplication(items)
    }

    fun run() {
        items.forEach { it.age() }
    }
}
