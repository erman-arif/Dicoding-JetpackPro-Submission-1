package com.erman.moviegallery.ui.tvshow;

import androidx.lifecycle.ViewModel;

import com.erman.moviegallery.data.TvshowEntity;
import com.erman.moviegallery.utils.DataDummy;

import java.util.ArrayList;

public class DetailTvshowViewModel extends ViewModel {

    private String tvshowId;

    public void setSelectedTvshow(String tvshowId) {
        this.tvshowId = tvshowId;
    }

    public TvshowEntity getTvshow() {

        TvshowEntity tvshow = null;
        ArrayList<TvshowEntity> tvshowEntities = (ArrayList<TvshowEntity>) DataDummy.generateDummyTvshows();

        for (TvshowEntity tvshowEntity : tvshowEntities) {
            if (tvshowEntity.getTvshowId().equals(tvshowId)) {
                tvshow = tvshowEntity;
            }
        }
        return tvshow;
    }
}
