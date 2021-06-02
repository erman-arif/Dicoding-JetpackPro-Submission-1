package com.erman.moviegallery.ui.tvshow;

import com.erman.moviegallery.data.TvshowEntity;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TvshowViewModelTest {

    private TvshowViewModel viewModel;

    @Before
    public void setUp() {
        viewModel = new TvshowViewModel();
    }

    @Test
    public void getTvshows() {
        List<TvshowEntity> tvshowEntities = viewModel.getTvshows();

        // Test jumlah data TV Show tidak null
        assertNotNull(tvshowEntities);

        // Test jumlah data TV Show sebanyak 12 data
        assertEquals(12, tvshowEntities.size());
    }
}