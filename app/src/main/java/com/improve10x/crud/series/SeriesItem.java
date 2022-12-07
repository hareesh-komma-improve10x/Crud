package com.improve10x.crud.series;

import com.google.gson.annotations.SerializedName;

public class SeriesItem {
    @SerializedName("_id")
    String Id;
    String seriesId;
    @SerializedName("title")
    String title;
    @SerializedName("imageUrl")
    String imageUrl;
}
