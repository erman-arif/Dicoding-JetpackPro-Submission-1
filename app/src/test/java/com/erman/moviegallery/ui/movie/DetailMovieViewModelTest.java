package com.erman.moviegallery.ui.movie;

import com.erman.moviegallery.data.MovieEntity;
import com.erman.moviegallery.utils.DataDummy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DetailMovieViewModelTest {

    private DetailMovieViewModel viewModel;
    private MovieEntity dummyMovie = DataDummy.generateDummyMovies().get(0);
    private String movieId = dummyMovie.getMovieId();

    @Before
    public void setUp() {
        viewModel = new DetailMovieViewModel();
        viewModel.setSelectedMovie(movieId);
    }

    @Test
    public void getMovie() {
        viewModel.setSelectedMovie(dummyMovie.getMovieId());
        MovieEntity movieEntity = viewModel.getMovie();

        assertNotNull(movieEntity);
        assertEquals(dummyMovie.getMovieId(), movieEntity.getMovieId());
        assertEquals(dummyMovie.getTitle(), movieEntity.getTitle());
        assertEquals(dummyMovie.getGenre(), movieEntity.getGenre());
        assertEquals(dummyMovie.getReleaseDate(), movieEntity.getReleaseDate());
        assertEquals(dummyMovie.getPopularity(), movieEntity.getPopularity());
        assertEquals(dummyMovie.getVoteCount(), movieEntity.getVoteCount());
        assertEquals(dummyMovie.getBackdropPath(), movieEntity.getBackdropPath());
        assertEquals(dummyMovie.getPosterPath(), movieEntity.getPosterPath());
        assertEquals(dummyMovie.getOverview(), movieEntity.getOverview());
    }
}