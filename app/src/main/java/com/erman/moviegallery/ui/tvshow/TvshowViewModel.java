package com.erman.moviegallery.ui.tvshow;

import androidx.lifecycle.ViewModel;

import com.erman.moviegallery.data.TvshowEntity;
import com.erman.moviegallery.utils.DataDummy;

import java.util.List;

public class TvshowViewModel extends ViewModel {
    public List<TvshowEntity> getTvshows() {
        return DataDummy.generateDummyTvshows();
    }
}
