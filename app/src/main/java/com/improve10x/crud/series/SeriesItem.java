package com.improve10x.crud.series;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SeriesItem implements Serializable {
    @SerializedName("_id")
    String Id;
    String seriesId;
    @SerializedName("title")
    String title;
    @SerializedName("imageUrl")
    String imageUrl;
}
