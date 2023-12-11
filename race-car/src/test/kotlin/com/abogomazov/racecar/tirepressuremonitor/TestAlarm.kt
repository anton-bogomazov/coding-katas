package com.abogomazov.racecar.tirepressuremonitor

import kotlin.test.Test
import kotlin.test.assertEquals

class TestAlarm {

    @Test
    fun foo() {
        val alarm = Alarm()
        assertEquals(false, alarm.isAlarmOn)
    }
}
