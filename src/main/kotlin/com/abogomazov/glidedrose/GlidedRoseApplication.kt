package com.abogomazov.glidedrose

import com.abogomazov.glidedrose.item.Item

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
