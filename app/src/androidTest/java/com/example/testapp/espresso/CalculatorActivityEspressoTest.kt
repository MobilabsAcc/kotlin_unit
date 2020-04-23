package com.example.testapp.espresso

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.example.testapp.MainActivity
import com.example.testapp.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class CalculatorActivityEspressoTest {
    @get:Rule
    var mActivityRule =
        ActivityTestRule(MainActivity::class.java)

    @Test
    fun ensureTextChangesWork() {
        onView(withId(R.id.one))
            .perform(click())
        onView(withId(R.id.resultTextView)).check(matches(withText("1")))
    }

    @Test
    fun checkAdding() {
        onView(withId(R.id.one))
            .perform(click())
        onView(withId(R.id.plus))
            .perform(click())
        onView(withId(R.id.one))
            .perform(click())
        onView(withId(R.id.equals))
            .perform(click())
        onView(withId(R.id.resultTextView)).check(matches(withText("2")))
    }

    @Test
    fun checkManyOperations() {
        onView(withId(R.id.one))
            .perform(click())
        onView(withId(R.id.multiply))
            .perform(click())
        onView(withId(R.id.one))
            .perform(click())
        onView(withId(R.id.divide))
            .perform(click())
        onView(withId(R.id.one))
            .perform(click())
        onView(withId(R.id.minus))
            .perform(click())
        onView(withId(R.id.one))
            .perform(click())
        onView(withId(R.id.equals))
            .perform(click())
        onView(withId(R.id.resultTextView)).check(matches(withText("0")))
    }
}