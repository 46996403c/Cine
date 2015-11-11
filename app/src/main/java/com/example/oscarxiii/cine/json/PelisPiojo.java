package com.example.oscarxiii.cine.json;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PelisPiojo implements Parcelable {

    private int page;
    private List<Result> results = new ArrayList<Result>();
    private int totalPages;
    private int totalResults;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public static final Parcelable.Creator<PelisPiojo> CREATOR = new Parcelable.Creator<PelisPiojo>() {
        public PelisPiojo createFromParcel(Parcel source) {
            return new PelisPiojo(source);
        }
        public PelisPiojo[] newArray(int size) {
            return new PelisPiojo[size];
        }
    };
    public PelisPiojo() {
    }

    protected PelisPiojo(Parcel in) {
        this.results = in.createTypedArrayList(Result.CREATOR);
    }

    /**
     *
     * @return
     * The page
     */
    public int getPage() {
        return page;
    }

    /**
     *
     * @param page
     * The page
     */
    public void setPage(int page) {
        this.page = page;
    }

    /**
     *
     * @return
     * The results
     */
    public List<Result> getResults() {
        return results;
    }

    /**
     *
     * @param results
     * The results
     */
    public void setResults(List<Result> results) {
        this.results = results;
    }

    /**
     *
     * @return
     * The totalPages
     */
    public int getTotalPages() {
        return totalPages;
    }

    /**
     *
     * @param totalPages
     * The total_pages
     */
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    /**
     *
     * @return
     * The totalResults
     */
    public int getTotalResults() {
        return totalResults;
    }

    /**
     *
     * @param totalResults
     * The total_results
     */
    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(results);
    }
}