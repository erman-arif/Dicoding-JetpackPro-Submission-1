package com.erman.moviegallery.ui.tvshow;

import com.erman.moviegallery.data.TvshowEntity;
import com.erman.moviegallery.utils.DataDummy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DetailTvshowViewModelTest {

    private DetailTvshowViewModel viewModel;
    private TvshowEntity dummyTvshow = DataDummy.generateDummyTvshows().get(0);
    private String TvshowId = dummyTvshow.getTvshowId();

    @Before
    public void setUp() {
        viewModel = new DetailTvshowViewModel();
        viewModel.setSelectedTvshow(TvshowId);
    }
    
    @Test
    public void getTvshow() {
        viewModel.setSelectedTvshow(dummyTvshow.getTvshowId());
        TvshowEntity TvshowEntity = viewModel.getTvshow();

        assertNotNull(TvshowEntity);
        assertEquals(dummyTvshow.getTvshowId(), TvshowEntity.getTvshowId());
        assertEquals(dummyTvshow.getName(), TvshowEntity.getName());
        assertEquals(dummyTvshow.getGenre(), TvshowEntity.getGenre());
        assertEquals(dummyTvshow.getFirstAirDate(), TvshowEntity.getFirstAirDate());
        assertEquals(dummyTvshow.getPopularity(), TvshowEntity.getPopularity());
        assertEquals(dummyTvshow.getVoteCount(), TvshowEntity.getVoteCount());
        assertEquals(dummyTvshow.getBackdropPath(), TvshowEntity.getBackdropPath());
        assertEquals(dummyTvshow.getPosterPath(), TvshowEntity.getPosterPath());
        assertEquals(dummyTvshow.getOverview(), TvshowEntity.getOverview());
    }
}