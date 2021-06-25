package com.septian.moviecataloguedummyver.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.septian.moviecataloguedummyver.R
import com.septian.moviecataloguedummyver.util.DataDummy
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {

    private val dummyMovie = DataDummy.generateMovies()


    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Test
    fun loadMovie() {
        Thread.sleep(2000)
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        Thread.sleep(2000)
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovie.size
            )
        )
        Thread.sleep(3000)
        onView(withId(R.id.view_pager)).perform(swipeLeft(), swipeDown(), swipeUp())





    }


    @Test
    fun loadDetailMovie() {
        Thread.sleep(3000)
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click())
        )

        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(dummyMovie[0].movieTitle)))

        onView(withId(R.id.tv_release_date)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_release_date)).check(matches(withText(dummyMovie[0].movieRelease)))
        onView(withId(R.id.tv_rating_item)).check(matches(isDisplayed()))
        Thread.sleep(1000)
        onView(withId(R.id.tv_description)).check(matches(isDisplayed()))

        onView(withId(R.id.iv_poster)).check(matches(isDisplayed()))

        onView(withId(R.id.iv_poster_background)).check(matches(isDisplayed()))

        onView(withId(R.id.btn_trailer)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_trailer)).perform(click())

    }




}