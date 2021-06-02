package com.erman.moviegallery.ui.movie;

import androidx.lifecycle.ViewModel;

import com.erman.moviegallery.data.MovieEntity;
import com.erman.moviegallery.utils.DataDummy;

import java.util.List;

public class MovieViewModel extends ViewModel {
    public List<MovieEntity> getMovies() {
        return DataDummy.generateDummyMovies();
    }
}
