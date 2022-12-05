package messages;

import com.google.gson.annotations.SerializedName;

public class Message {
    @SerializedName("_id")
    public String id;
    @SerializedName("name")
    public String name;
    @SerializedName("phoneNumber")
    public String phoneNumber;
    @SerializedName("messageText")
    public String messageText;
}
