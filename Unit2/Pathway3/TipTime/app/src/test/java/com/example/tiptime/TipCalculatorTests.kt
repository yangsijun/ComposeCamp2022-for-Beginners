package com.example.tiptime

import org.junit.Assert.assertEquals
import org.junit.Test

class TipCalculatorTests {

    @Test
    fun calculate_20_percent_tip_no_roundup() {
        val amount = 10.00
        val tipPercent = 20.00
        val roundUp = false
        val expectedTip = "$2.00"
        val actualTip = calculateTip(amount, tipPercent, roundUp)
        assertEquals(actualTip, expectedTip)
    }
}