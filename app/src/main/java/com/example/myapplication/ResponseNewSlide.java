package com.example.myapplication;

import com.google.gson.annotations.SerializedName;

public class ResponseNewSlide {
    @SerializedName("id")
    private String id;
    @SerializedName("images")
    private String images;
    @SerializedName("status")
    private String status;
    @SerializedName("time")
    private String time;
    @SerializedName("message")
    private String message;

    public String getId() {
        return id;
    }

    public String getImages() {
        return images;
    }

    public String getStatus() {
        return status;
    }

    public String getTime() {
        return time;
    }

    public String getMessage() {
        return message;
    }
}
