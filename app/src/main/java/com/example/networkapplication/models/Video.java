package com.example.networkapplication.models;

public class Video {

    private int mId;

    private String mTitle;

    private String mImage;

    private String mUrl;

    public Video() {
    }

    public Video(int id, String title, String image, String url) {
        mId = id;
        mTitle = title;
        mImage = image;
        mUrl = url;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getImage() {
        return mImage;
    }

    public void setImage(String image) {
        mImage = image;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }
}
