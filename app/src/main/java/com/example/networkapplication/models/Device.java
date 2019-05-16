package com.example.networkapplication.models;

public class Device {

    private int mId;

    private String mName;

    private int mImageId;

    private String mIpAddress;

    public Device() {
    }

    public Device(int id, String name, int imageId, String ipAddress) {
        mId = id;
        mName = name;
        mImageId = imageId;
        mIpAddress = ipAddress;
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

    public String getIpAddress() {
        return mIpAddress;
    }

    public void setIpAddress(String ipAddress) {
        mIpAddress = ipAddress;
    }
}
