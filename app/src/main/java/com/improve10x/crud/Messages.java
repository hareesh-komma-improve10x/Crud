package com.improve10x.crud;

import com.google.gson.annotations.SerializedName;

public class Messages {
    @SerializedName("_id")
    public String id;
    @SerializedName("name")
    public String name;
    @SerializedName("phoneNumber")
    public String phoneNumber;
    @SerializedName("messageText")
    public String message;

}
