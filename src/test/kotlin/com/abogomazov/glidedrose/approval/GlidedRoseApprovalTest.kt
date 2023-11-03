package com.abogomazov.glidedrose.approval

import com.abogomazov.glidedrose.GlidedRoseApplication
import com.abogomazov.glidedrose.item.AgingItem
import com.abogomazov.glidedrose.item.ConjuredItem
import com.abogomazov.glidedrose.item.HypingItem
import com.abogomazov.glidedrose.item.Item
import com.abogomazov.glidedrose.item.LegendaryItem
import com.abogomazov.glidedrose.item.RegularItem
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class GlidedRoseApprovalTest {

    @Test
    fun `items degrade properly`() {
        val expectedOutput = resource("approval-test-expected-out")
        val items = listOf(
            RegularItem.of("+5 Dexterity Vest", 10, 20),
            AgingItem.of("Aged Brie", 2, 0),
            RegularItem.of("Elixir of the Mongoose", 5, 7),
            LegendaryItem.of("Sulfuras, Hand of Ragnaros", 0, 80),
            LegendaryItem.of("Sulfuras, Hand of Ragnaros", -1, 80),
            HypingItem.of("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            HypingItem.of("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            HypingItem.of("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            ConjuredItem.of("Conjured Mana Cake", 3, 6)
        )
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
