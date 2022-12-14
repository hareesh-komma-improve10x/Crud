package com.improve10x.crud.quotes;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Quote implements Serializable {
    @SerializedName("id")
    String id;
    @SerializedName("quote")
    String quoteText;
    @SerializedName("authorName")
    String authorName;
    @SerializedName("category")
    String category;
    @SerializedName("imageUrl")
    String imageUrl;
}
