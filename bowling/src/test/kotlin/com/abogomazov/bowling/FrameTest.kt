package com.abogomazov.bowling

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class FrameTest {
    @Test
    fun `frame with one roll is not completed`() {
        val frame = Frame.std()
        frame.roll(Roll(5))
        assertFalse(frame.isCompleted())
    }

    @Test
    fun `standard frame is completed in 2 rolls`() {
        val frame: Frame = Frame.std()
        frame.roll(Roll(3))
        frame.roll(Roll(4))
        assertTrue(frame.isCompleted())
    }

    @Test
    fun `final frame is completed in 3 rolls if spare`() {
        val frame: Frame = Frame.final()
        frame.roll(Roll(6))
        frame.roll(Roll(4))
        frame.roll(Roll(5))
        assertTrue(frame.isCompleted())
    }

    @Test
    fun `final frame is completed in 2 rolls if first is strike`() {
        val frame: Frame = Frame.final()
        frame.roll(Roll(10))
        frame.roll(Roll(5))
        assertTrue(frame.isCompleted())
    }

    @Test
    fun `second strike cannot be rolled in standard frame`() {
        val frame: Frame = Frame.std()
        frame.roll(Roll(10))
        assertThrows<IllegalArgumentException> {
            frame.roll(Roll(10))
        }
    }

    @Test
    fun `4th strike cannot be rolled in final frame`() {
        val frame: Frame = Frame.final()
        frame.roll(Roll(10))
        frame.roll(Roll(10))
        frame.roll(Roll(10))
        assertThrows<IllegalArgumentException> {
            frame.roll(Roll(10))
        }
    }

    @Test
    fun `frame with no rolls is not completed`() {
        val frame: Frame = Frame.std()
        assertFalse(frame.isCompleted())
    }

    @Test
    fun `frame with two rolls sums up to total score`() {
        val frame: Frame = Frame.std()
        frame.roll(Roll(3))
        frame.roll(Roll(4))
        assertEquals(7, frame.score())
    }

    @Test
    fun `final frame sums up to total score exceeding total pins number`() {
        val frame = Frame.final()
        frame.roll(Roll(5))
        frame.roll(Roll(5))
        frame.roll(Roll(10))
        assertEquals(20, frame.score())
    }
}
