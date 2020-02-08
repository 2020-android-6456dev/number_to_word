package com.converter.numbertoword

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {

    @get:Rule
    val rule = ActivityTestRule(MainActivity::class.java, false, true)

    var activity: MainActivity? = null

    @Before
    fun setUp() {
        activity = rule.activity

    }

    @Test
    fun testViewPresent() {
        Espresso.onView(ViewMatchers.withId(R.id.et_number_input))
            .check(ViewAssertions.doesNotExist())
        Espresso.onView(ViewMatchers.withId(R.id.tv_number_in_words))
            .check(ViewAssertions.doesNotExist())
    }

    @After
    fun tearDown() {
        activity?.finish()
    }
}