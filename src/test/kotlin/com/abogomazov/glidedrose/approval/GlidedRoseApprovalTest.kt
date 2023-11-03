package com.abogomazov.glidedrose.approval

import com.abogomazov.glidedrose.GildedRose
import com.abogomazov.glidedrose.Item
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class GlidedRoseApprovalTest {

    @Test
    fun `items degrade properly`() {
        val expectedOutput = resource("approval-test-expected-out")
        val items = listOf(
            Item("+5 Dexterity Vest", 10, 20),
            Item("Aged Brie", 2, 0),
            Item("Elixir of the Mongoose", 5, 7),
            Item("Sulfuras, Hand of Ragnaros", 0, 80),
            Item("Sulfuras, Hand of Ragnaros", -1, 80),
            Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            // this conjured item does not work properly yet
            Item("Conjured Mana Cake", 3, 6)
        )
        assertEquals(expectedOutput, runApp(items))
    }

}

private fun resource(filename: String) =
    GlidedRoseApprovalTest::class.java
        .getResourceAsStream("/$filename")!!
        .reader().readText()

private fun runApp(items: List<Item>): String {
    val app = GildedRose(items)

    return buildString {
        for (i in 0..30) {
            appendLine("-------- day $i --------")
            appendLine("name, sellIn, quality")
            for (item in items) {
                appendLine(item)
            }
            appendLine()
            app.updateQuality()
        }
    }
}
