package com.erman.moviegallery.ui.tvshow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.MenuItem;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.erman.moviegallery.R;
import com.erman.moviegallery.data.TvshowEntity;
import com.erman.moviegallery.databinding.ActivityDetailTvshowBinding;
import com.erman.moviegallery.utils.DataDummy;

public class DetailTvshowActivity extends AppCompatActivity {

    public static final String EXTRA_TVSHOW = "extra_tvshow";
    private ActivityDetailTvshowBinding activityDetailTvshowBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Binding layout resource
        activityDetailTvshowBinding = ActivityDetailTvshowBinding.inflate(getLayoutInflater());
        setContentView(activityDetailTvshowBinding.getRoot());

        // Set Back button and title
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(getResources().getString(R.string.tvshow));
        }

        // ViewModel
        DetailTvshowViewModel viewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(DetailTvshowViewModel.class);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            String tvshowId = extras.getString(EXTRA_TVSHOW);
            if (tvshowId != null) {
                viewModel.setSelectedTvshow(tvshowId);
                populateTvshow(viewModel.getTvshow());

                for (int i = 0; i < DataDummy.generateDummyTvshows().size(); i++) {
                    TvshowEntity tvshowEntity = DataDummy.generateDummyTvshows().get(i);
                    if (tvshowEntity.getTvshowId().equals(tvshowId)) {
                        populateTvshow(tvshowEntity);
                    }
                }
            }
        }

    }

    /**
     * Populate TV Show Data
     * Binding TV Show data to layout
     */
    private void populateTvshow(TvshowEntity tvshowEntity) {
        final String baseUrlTvshow = "https://www.themoviedb.org/t/p/w500/";

        activityDetailTvshowBinding.tvDtlTvshowName.setText(tvshowEntity.getName());
        activityDetailTvshowBinding.tvDtlTvshowGenre.setText(tvshowEntity.getGenre());
        activityDetailTvshowBinding.tvDtlTvshowFirstairdate.setText(tvshowEntity.getFirstAirDate());
        activityDetailTvshowBinding.tvDtlTvshowPopularity.setText(Double.toString(tvshowEntity.getPopularity()));
        activityDetailTvshowBinding.tvDtlTvshowVotecount.setText(Integer.toString(tvshowEntity.getVoteCount()));
        activityDetailTvshowBinding.tvDtlTvshowOverview.setText(tvshowEntity.getOverview());

        Glide.with(this)
                .load(baseUrlTvshow + tvshowEntity.getPosterPath())
                .transform(new RoundedCorners(20))
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading_poster).error(R.drawable.ic_error_poster))
                .into(activityDetailTvshowBinding.ivDtlTvshowPoster);
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