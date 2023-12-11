package com.abogomazov.racecar.leaderboard

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class LeaderboardTest {

    @Test
    fun itShouldSumThePoints() {
        // setup

        // act
        val results = TestData.sampleLeaderboard1.driverResults()

        // verify
        assertTrue(results.containsKey("Lewis Hamilton"))
        assertEquals((18 + 18 + 25).toLong(), (results.get("Lewis Hamilton") as Int).toLong())
    }

    @Test
    fun isShouldFindTheWinner() {
        // setup

        // act
        val result = TestData.sampleLeaderboard1.driverRankings()

        // verify
        assertEquals("Lewis Hamilton", result.get(0))
    }

    @Test
    fun itShouldKeepAllDriversWhenSamePoints() {
        // setup
        // bug, drops drivers with same points
        val winDriver1 = Race("Australian Grand Prix", TestData.driver1, TestData.driver2, TestData.driver3)
        val winDriver2 = Race("Malaysian Grand Prix", TestData.driver2, TestData.driver1, TestData.driver3)
        val exEquoLeaderBoard = Leaderboard(winDriver1, winDriver2)

        // act
        val rankings = exEquoLeaderBoard.driverRankings()

        // verify
        assertEquals(arrayListOf(TestData.driver1.name, TestData.driver2.name, TestData.driver3.name), rankings)
        // note: the order of driver1 and driver2 is JDK/platform dependent
    }

}
