package com.abogomazov.gildedrose

import com.abogomazov.gildedrose.item.Item

class GlidedRoseApplication private constructor(
    private val items: List<Item>
) {
    companion object {
        fun with(items: List<Item>) = GlidedRoseApplication(items)
    }

    fun run() {
        items.forEach { it.age() }
    }
}
