package com.erman.moviegallery.ui.movie;

import com.erman.moviegallery.data.MovieEntity;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MovieViewModelTest {

    private MovieViewModel viewModel;

    @Before
    public void setUp() {
        viewModel = new MovieViewModel();
    }

    @Test
    public void getMovies() {
        List<MovieEntity> movieEntities = viewModel.getMovies();

        // Test jumlah data movie tidak null
        assertNotNull(movieEntities);

        // Test jumlah data movie sebanyak 12 data
        assertEquals(12, movieEntities.size());
    }
}