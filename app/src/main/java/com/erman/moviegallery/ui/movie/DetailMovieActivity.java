package com.erman.moviegallery.ui.movie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.MenuItem;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.erman.moviegallery.R;
import com.erman.moviegallery.data.MovieEntity;
import com.erman.moviegallery.databinding.ActivityDetailMovieBinding;
import com.erman.moviegallery.utils.DataDummy;

public class DetailMovieActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";
    private ActivityDetailMovieBinding activityDetailMovieBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Binding layout resource
        activityDetailMovieBinding = ActivityDetailMovieBinding.inflate(getLayoutInflater());
        setContentView(activityDetailMovieBinding.getRoot());

        // Set Back button and title
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(getResources().getString(R.string.movie));
        }

        // ViewModel
        DetailMovieViewModel viewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(DetailMovieViewModel.class);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            String movieId = extras.getString(EXTRA_MOVIE);
            if (movieId != null) {
                viewModel.setSelectedMovie(movieId);
                populateMovie(viewModel.getMovie());

                for (int i = 0; i < DataDummy.generateDummyMovies().size(); i++) {
                    MovieEntity movieEntity = DataDummy.generateDummyMovies().get(i);
                    if (movieEntity.getMovieId().equals(movieId)) {
                        populateMovie(movieEntity);
                    }
                }
            }
        }

    }

    /**
     * Populate Movie Data
     * Binding Movie data to layout
     */
    private void populateMovie(MovieEntity movieEntity) {
        final String baseUrlMovie = "https://www.themoviedb.org/t/p/w500/";

        activityDetailMovieBinding.tvDtlMovieTitle.setText(movieEntity.getTitle());
        activityDetailMovieBinding.tvDtlMovieGenre.setText(movieEntity.getGenre());
        activityDetailMovieBinding.tvDtlMovieReleasedate.setText(movieEntity.getReleaseDate());
        activityDetailMovieBinding.tvDtlMoviePopularity.setText(Double.toString(movieEntity.getPopularity()));
        activityDetailMovieBinding.tvDtlMovieVotecount.setText(Integer.toString(movieEntity.getVoteCount()));
        activityDetailMovieBinding.tvDtlMovieOverview.setText(movieEntity.getOverview());

        Glide.with(this)
                .load(baseUrlMovie + movieEntity.getPosterPath())
                .transform(new RoundedCorners(20))
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading_poster).error(R.drawable.ic_error_poster))
                .into(activityDetailMovieBinding.ivDtlMoviePoster);
    }


    /**
     * Handle back button press
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}