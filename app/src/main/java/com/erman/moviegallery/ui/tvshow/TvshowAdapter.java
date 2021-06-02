package com.erman.moviegallery.ui.tvshow;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.erman.moviegallery.R;
import com.erman.moviegallery.data.TvshowEntity;
import com.erman.moviegallery.databinding.ItemTvshowBinding;

import java.util.ArrayList;
import java.util.List;

public class TvshowAdapter extends RecyclerView.Adapter<TvshowAdapter.TvshowViewHolder>{
    private final List<TvshowEntity> listTvshows = new ArrayList<>();

    void setTvshows(List<TvshowEntity> listTvshows) {
        if (listTvshows == null) return;
        this.listTvshows.clear();
        this.listTvshows.addAll(listTvshows);
    }

    @NonNull
    @Override
    public TvshowAdapter.TvshowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemTvshowBinding binding = ItemTvshowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new TvshowAdapter.TvshowViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TvshowAdapter.TvshowViewHolder holder, int position) {
        TvshowEntity tvshow = listTvshows.get(position);
        holder.bind(tvshow);
    }

    @Override
    public int getItemCount() {
        return listTvshows.size();
    }

    static class TvshowViewHolder extends RecyclerView.ViewHolder {

        private final ItemTvshowBinding binding;

        TvshowViewHolder(ItemTvshowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(TvshowEntity tvshow) {
            final String baseUrlTvshow = "https://www.themoviedb.org/t/p/w500/";

            binding.tvWideTvshowName.setText(tvshow.getName());
            binding.tvWideTvshowGenre.setText(tvshow.getGenre());
            binding.tvListTvshowFirstairdate.setText(tvshow.getFirstAirDate());
            binding.tvListTvshowPopularity.setText(Double.toString(tvshow.getPopularity()));
            binding.tvListTvshowVoteCount.setText(Integer.toString(tvshow.getVoteCount()));

            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), DetailTvshowActivity.class);
                intent.putExtra(DetailTvshowActivity.EXTRA_TVSHOW, tvshow.getTvshowId());
                itemView.getContext().startActivity(intent);
            });

            Glide.with(itemView.getContext())
                    .load(baseUrlTvshow + tvshow.getBackdropPath())
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading_backdrop).error(R.drawable.ic_error_backdrop))
                    .into(binding.ivWideTvshowPoster);
        }
    }
}
