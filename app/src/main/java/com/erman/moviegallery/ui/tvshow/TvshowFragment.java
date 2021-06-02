package com.erman.moviegallery.ui.tvshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.erman.moviegallery.data.TvshowEntity;
import com.erman.moviegallery.databinding.FragmentTvshowBinding;

import java.util.List;

public class TvshowFragment extends Fragment {

    private FragmentTvshowBinding fragmentTvshowBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentTvshowBinding = FragmentTvshowBinding.inflate(inflater, container, false);
        return fragmentTvshowBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getActivity() != null) {
            TvshowViewModel viewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(TvshowViewModel.class);
            List<TvshowEntity> tvshows = viewModel.getTvshows();

            TvshowAdapter tvshowAdapter = new TvshowAdapter();
            tvshowAdapter.setTvshows(tvshows);

            fragmentTvshowBinding.rvTvshow.setLayoutManager(new LinearLayoutManager(getContext()));
            fragmentTvshowBinding.rvTvshow.setHasFixedSize(true);
            fragmentTvshowBinding.rvTvshow.setAdapter(tvshowAdapter);
        }
    }
}