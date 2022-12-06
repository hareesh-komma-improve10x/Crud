package com.improve10x.crud.series;

import com.google.gson.annotations.SerializedName;

public class SeriesItem {
    @SerializedName("_id")
    public String Id;
    public String seriesId;
    @SerializedName("title")
    public String title;
    @SerializedName("imageUrl")
    public String imageUrl;
}
