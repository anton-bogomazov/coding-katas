package com.abogomazov.racecar.textconverter

import com.abogomazov.racecar.textconverter.HtmlTextConverter
import kotlin.test.Test
import kotlin.test.assertEquals

class HtmlTextConverterTest {
    @Test
    fun foo() {
        val converter = HtmlTextConverter("foo")
        assertEquals("fixme", converter.filename)
    }
}
