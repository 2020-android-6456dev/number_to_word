package com.converter.utils;

import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Test
import java.lang.Exception


class ConverterUtilsTest {

    @Test
    fun checkNegativeNumber() {
        try {
            getNumberInWords(-9)
            Assert.fail()
        } catch (e: Exception) {
            if (e !is java.lang.IllegalArgumentException){
                Assert.fail()
            }
        }
    }

    @Test
    fun checkMaxLimit() {
        try {
            getNumberInWords(999999999)
            Assert.fail()
        } catch (e: Exception) {
            if (e !is java.lang.IllegalArgumentException){
                Assert.fail()
            }
        }
    }

    @Test
    fun checkForFraction() {
        try {
            getDecimalFromString("22.6")
            Assert.fail()
        } catch (e: Exception) {
            if (e !is java.lang.IllegalArgumentException){
                Assert.fail()
            }
        }
    }

    @Test
    fun checkForSpace() {
        try {
            getDecimalFromString("9 9")
            Assert.fail()
        } catch (e: Exception) {
            if (e !is java.lang.IllegalArgumentException){
                Assert.fail()
            }
        }
    }

    @Test
    fun checkNumberInput() {
        try {
            getDecimalFromString("A3")
            Assert.fail()
        } catch (e: Exception) {
            if (e !is java.lang.IllegalArgumentException){
                Assert.fail()
            }
        }
    }

    @Test
    fun checkNumberToWord() {
        assertEquals("Nine Hundred Twelve", getNumberInWords(912))
        assertEquals("Two Thousand Four Hundred Sixty Seven", getNumberInWords(2467))
        assertEquals(
            "Nine Lakh Ninety Eight Thousand Four Hundred Twenty Four",
            getNumberInWords(998424)
        )
    }

}