package com.example.networkapplication.models;

public abstract class Device {

    private int mId;

    private String mName;

    private int mImageId;

    public Device() {
    }

    public Device(int id, String name, int imageId) {
        mId = id;
        mName = name;
        mImageId = imageId;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getImageId() {
        return mImageId;
    }

    public void setImageId(int imageId) {
        mImageId = imageId;
    }
}
