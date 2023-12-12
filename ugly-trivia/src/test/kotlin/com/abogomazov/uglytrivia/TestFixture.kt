package com.abogomazov.uglytrivia

import org.junit.jupiter.api.Test
import java.io.File
import java.io.PrintStream
import java.nio.charset.Charset
import kotlin.test.assertEquals

class TestFixture {

    @Test
    fun `golden master test`() {
        System.setOut(PrintStream("test-out"))
        GameRunner.run()

        val expected = File("gold-out").readBytes().toString(Charset.defaultCharset())
        val actual = File("test-out").readBytes().toString(Charset.defaultCharset())
        assertEquals(expected, actual)
    }
}
