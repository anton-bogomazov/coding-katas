package com.abogomazov.glidedrose.approval

import com.abogomazov.glidedrose.GlidedRoseApplication
import com.abogomazov.glidedrose.GlidedRoseItemFactory
import com.abogomazov.glidedrose.item.Item
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class GlidedRoseApprovalTest {

    @Test
    fun `items degrade properly`() {
        val expectedOutput = resource("approval-test-expected-out")
        val items = listOf(
            Triple("+5 Dexterity Vest", 10, 20),
            Triple("Aged Brie", 2, 0),
            Triple("Elixir of the Mongoose", 5, 7),
            Triple("Sulfuras, Hand of Ragnaros", 0, 80),
            Triple("Sulfuras, Hand of Ragnaros", -1, 80),
            Triple("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            Triple("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            Triple("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            Triple("Conjured Mana Cake", 3, 6)
        ).map { (name, sellIn, quality) ->
            GlidedRoseItemFactory.create(name, sellIn, quality)
        }
        assertEquals(expectedOutput, runApp(items))
    }
}

private fun resource(filename: String) =
    GlidedRoseApprovalTest::class.java
        .getResourceAsStream("/$filename")!!
        .reader().readText()

private fun runApp(items: List<Item>): String {
    val app = GlidedRoseApplication.with(items)

    return buildString {
        for (i in 0..30) {
            appendLine("-------- day $i --------")
            appendLine("name, sellIn, quality")
            for (item in items) {
                appendLine(item)
            }
            appendLine()
            app.run()
        }
    }
}
