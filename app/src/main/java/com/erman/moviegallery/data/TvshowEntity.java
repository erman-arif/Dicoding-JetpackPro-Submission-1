package com.erman.moviegallery.data;

import java.util.List;

public class TvshowEntity {

    //-------------------------------------------------------------------------------------------
    //    PROPERTIES
    //-------------------------------------------------------------------------------------------
    private String tvshowId;
    private String name;
    private String genre;
    private String firstAirDate;
    private Double popularity;
    private Integer voteCount;
    private String backdropPath;
    private String posterPath;
    private String overview;

    //-------------------------------------------------------------------------------------------
    //    CONSTRUCTOR
    //-------------------------------------------------------------------------------------------
    public TvshowEntity(String tvshowId, String name, String genre, String firstAirDate, Double popularity, Integer voteCount, String backdropPath, String posterPath, String overview) {
        this.tvshowId = tvshowId;
        this.name = name;
        this.genre = genre;
        this.firstAirDate = firstAirDate;
        this.popularity = popularity;
        this.voteCount = voteCount;
        this.backdropPath = backdropPath;
        this.posterPath = posterPath;
        this.overview = overview;
    }

    //-------------------------------------------------------------------------------------------
    //   GETTER & SETTER
    //-------------------------------------------------------------------------------------------

    public String getTvshowId() {
        return tvshowId;
    }

    public void setTvshowId(int id) {
        this.tvshowId = tvshowId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getFirstAirDate() {
        return firstAirDate;
    }

    public void setFirstAirDate(String firstAirDate) {
        this.firstAirDate = firstAirDate;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}
