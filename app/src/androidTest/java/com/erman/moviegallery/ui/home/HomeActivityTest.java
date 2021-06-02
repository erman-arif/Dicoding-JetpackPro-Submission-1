package com.erman.moviegallery.ui.home;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.erman.moviegallery.R;
import com.erman.moviegallery.data.MovieEntity;
import com.erman.moviegallery.data.TvshowEntity;
import com.erman.moviegallery.utils.DataDummy;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.List;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HomeActivityTest {

    private final List<MovieEntity> dummyMovie = DataDummy.generateDummyMovies();
    private final List<TvshowEntity> dummyTvshow = DataDummy.generateDummyTvshows();

    @Rule
    public ActivityScenarioRule activityRule = new ActivityScenarioRule<>(HomeActivity.class);

    /**
     * Test load list Movie into recyclerView in fragment
     */
    @Test
    public void t1LoadMovies() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition(dummyMovie.size()));
    }

    /**
     * Test load detail Movie into activity
     */
    @Test
    public void t2LoadDetailMovie() {
        // Test display recyclerview
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        // Test title
        onView(withId(R.id.tv_dtl_movie_title)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_dtl_movie_title)).check(matches(withText(dummyMovie.get(0).getTitle())));
        // Test genre
        onView(withId(R.id.tv_dtl_movie_genre)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_dtl_movie_genre)).check(matches(withText(dummyMovie.get(0).getGenre())));
        // Test release date
        onView(withId(R.id.tv_dtl_movie_releasedate)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_dtl_movie_releasedate)).check(matches(withText(dummyMovie.get(0).getReleaseDate())));
        // Test popularity
        onView(withId(R.id.tv_dtl_movie_popularity)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_dtl_movie_popularity)).check(matches(withText(Double.toString(dummyMovie.get(0).getPopularity()))));
        // Test vote count
        onView(withId(R.id.tv_dtl_movie_votecount)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_dtl_movie_votecount)).check(matches(withText(Integer.toString(dummyMovie.get(0).getVoteCount()))));
        // Test overview
        onView(withId(R.id.tv_dtl_movie_overview)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_dtl_movie_overview)).check(matches(withText(dummyMovie.get(0).getOverview())));

        // Test Poster
        onView(withId(R.id.iv_dtl_movie_poster)).check(matches(isDisplayed()));
    }

    /**
     * Test load list TV Show into recyclerView in fragment
     */
    @Test
    public void t3LoadTvshows() {
        onView(withText("TV SHOWS")).perform(click());

        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.scrollToPosition(dummyTvshow.size()));
    }

    /**
     * Test load detail TV Show into activity
     */
    @Test
    public void t4LoadDetailTvshow() {
        onView(withText("TV SHOWS")).perform(click());

        // Test display recyclerview
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        // Test name
        onView(withId(R.id.tv_dtl_tvshow_name)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_dtl_tvshow_name)).check(matches(withText(dummyTvshow.get(0).getName())));
        // Test genre
        onView(withId(R.id.tv_dtl_tvshow_genre)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_dtl_tvshow_genre)).check(matches(withText(dummyTvshow.get(0).getGenre())));
        // Test first air date
        onView(withId(R.id.tv_dtl_tvshow_firstairdate)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_dtl_tvshow_firstairdate)).check(matches(withText(dummyTvshow.get(0).getFirstAirDate())));
        // Test popularity
        onView(withId(R.id.tv_dtl_tvshow_popularity)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_dtl_tvshow_popularity)).check(matches(withText(Double.toString(dummyTvshow.get(0).getPopularity()))));
        // Test vote count
        onView(withId(R.id.tv_dtl_tvshow_votecount)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_dtl_tvshow_votecount)).check(matches(withText(Integer.toString(dummyTvshow.get(0).getVoteCount()))));
        // Test overview
        onView(withId(R.id.tv_dtl_tvshow_overview)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_dtl_tvshow_overview)).check(matches(withText(dummyTvshow.get(0).getOverview())));

        // Test Poster
        onView(withId(R.id.iv_dtl_tvshow_poster)).check(matches(isDisplayed()));
    }

}