package com.example.networkapplication.models;

import com.google.gson.annotations.SerializedName;

public class MyResponse {

    @SerializedName("token")
    private String mToken;

    @SerializedName("expiration")
    private String mExpiration;

    public MyResponse() {
    }

    public MyResponse(String token, String expiration) {
        mToken = token;
        mExpiration = expiration;
    }

    public String getToken() {
        return mToken;
    }

    public void setToken(String token) {
        mToken = token;
    }

    public String getExpiration() {
        return mExpiration;
    }

    public void setExpiration(String expiration) {
        mExpiration = expiration;
    }
}
