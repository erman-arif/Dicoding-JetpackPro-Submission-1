package com.erman.moviegallery.ui.movie;

import androidx.lifecycle.ViewModel;

import com.erman.moviegallery.data.MovieEntity;
import com.erman.moviegallery.utils.DataDummy;

import java.util.ArrayList;

public class DetailMovieViewModel extends ViewModel {

    private String movieId;

    public void setSelectedMovie(String movieId) {
        this.movieId = movieId;
    }

    public MovieEntity getMovie() {

        MovieEntity movie = null;
        ArrayList<MovieEntity> movieEntities = (ArrayList<MovieEntity>) DataDummy.generateDummyMovies();

        for (MovieEntity movieEntity : movieEntities) {
            if (movieEntity.getMovieId().equals(movieId)) {
                movie = movieEntity;
            }
        }
        return movie;
    }
}
