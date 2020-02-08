package com.converter.convert;

import org.junit.Assert.assertEquals
import org.junit.Test


class NumberToWordConverterTest {

    @Test
    fun checkNumberToWord(){
        assertEquals("Nine Hundred Twelve", getNumberInWords(912))
        assertEquals("Two Thousand Four Hundred Sixty Seven", getNumberInWords(2467))
        assertEquals("Nine Lakh Ninety Eight Thousand Four Hundred Twenty Four", getNumberInWords(998424))
    }

}