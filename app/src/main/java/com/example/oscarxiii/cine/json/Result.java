package com.example.oscarxiii.cine.json;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Result implements Parcelable {

    private boolean adult;
    private String backdrop_path;
    private List<Integer> genreIds = new ArrayList<Integer>();
    private int id;
    private String original_language;
    private String original_title;
    private String overview;
    private String release_date;
    private String poster_path;
    private double popularity;
    private String title;
    private boolean video;
    private double voteAverage;
    private int voteCount;
    private Map<String, Object> additional_properties = new HashMap<String, Object>();

    public static final Parcelable.Creator<Result> CREATOR = new Parcelable.Creator<Result>() {
        public Result createFromParcel(Parcel source) {
            return new Result(source);
        }

        public Result[] newArray(int size) {
            return new Result[size];
        }
    };
    public Result(){

    }
    protected Result(Parcel in) {
        this.release_date = in.readString();
        this.popularity=(Double) in.readValue(Double.class.getClassLoader());
        this.title=in.readString();
        this.voteAverage= (Double) in.readValue(Double.class.getClassLoader());
        this.voteCount= (Integer)in.readValue(Integer.class.getClassLoader());
    }

    /**
     *
     * @return
     * The adult
     */
    public boolean isAdult() {
        return adult;
    }

    /**
     *
     * @param adult
     * The adult
     */
    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    /**
     *
     * @return
     * The backdropPath
     */
    public String getBackdropPath() {
        return backdrop_path;
    }

    /**
     *
     * @param backdropPath
     * The backdrop_path
     */
    public void setBackdropPath(String backdropPath) {
        this.backdrop_path = backdropPath;
    }

    /**
     *
     * @return
     * The genreIds
     */
    public List<Integer> getGenreIds() {
        return genreIds;
    }

    /**
     *
     * @param genreIds
     * The genre_ids
     */
    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }

    /**
     *
     * @return
     * The id
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The originalLanguage
     */
    public String getOriginalLanguage() {
        return original_language;
    }

    /**
     *
     * @param originalLanguage
     * The original_language
     */
    public void setOriginalLanguage(String originalLanguage) {
        this.original_language = originalLanguage;
    }

    /**
     *
     * @return
     * The originalTitle
     */
    public String getOriginalTitle() {
        return original_title;
    }

    /**
     *
     * @param originalTitle
     * The original_title
     */
    public void setOriginalTitle(String originalTitle) {
        this.original_title = originalTitle;
    }

    /**
     *
     * @return
     * The overview
     */
    public String getOverview() {
        return overview;
    }

    /**
     *
     * @param overview
     * The overview
     */
    public void setOverview(String overview) {
        this.overview = overview;
    }

    /**
     *
     * @return
     * The releaseDate
     */
    public String getReleaseDate() {
        return release_date;
    }

    /**
     *
     * @param releaseDate
     * The release_date
     */
    public void setReleaseDate(String releaseDate) {
        this.release_date = releaseDate;
    }

    /**
     *
     * @return
     * The posterPath
     */
    public String getPosterPath() {
        return poster_path;
    }

    /**
     *
     * @param posterPath
     * The poster_path
     */
    public void setPosterPath(String posterPath) {
        this.poster_path = posterPath;
    }

    /**
     *
     * @return
     * The popularity
     */
    public double getPopularity() {
        return popularity;
    }

    /**
     *
     * @param popularity
     * The popularity
     */
    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The video
     */
    public boolean isVideo() {
        return video;
    }

    /**
     *
     * @param video
     * The video
     */
    public void setVideo(boolean video) {
        this.video = video;
    }

    /**
     *
     * @return
     * The voteAverage
     */
    public double getVoteAverage() {
        return voteAverage;
    }

    /**
     *
     * @param voteAverage
     * The vote_average
     */
    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    /**
     *
     * @return
     * The voteCount
     */
    public int getVoteCount() {
        return voteCount;
    }

    /**
     *
     * @param voteCount
     * The vote_count
     */
    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additional_properties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additional_properties.put(name, value);
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(this.title);
        dest.writeString(this.release_date);
        dest.writeValue(this.popularity);
        dest.writeValue(this.voteAverage);
        dest.writeValue(this.voteCount);
    }
}