package com.improve10x.crud.templates;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Template implements Serializable {
    @SerializedName("_id")
    String id;
    @SerializedName("messageText")
    String messageText;
}
