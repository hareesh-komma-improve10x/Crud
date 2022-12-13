package com.improve10x.crud.messages;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Message implements Serializable {
    @SerializedName("_id")
    String id;
    @SerializedName("name")
    String name;
    @SerializedName("phoneNumber")
    String phoneNumber;
    @SerializedName("messageText")
    String messageText;
}
