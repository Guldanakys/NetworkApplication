package com.example.networkapplication.models;

public class StandardDevice {

    private int mId;

    private String mTitle;

    private int mImageId;

    public StandardDevice() {
    }

    public StandardDevice(int id, String title, int imageId) {
        mId = id;
        mTitle = title;
        mImageId = imageId;
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

    public int getImageId() {
        return mImageId;
    }

    public void setImageId(int imageId) {
        mImageId = imageId;
    }
}
