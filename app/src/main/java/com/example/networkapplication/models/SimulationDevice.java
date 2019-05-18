package com.example.networkapplication.models;

public class SimulationDevice {

    private int mId;

    private String mName;

    private int mImageId;

    private String mIpAddress;

    private float mXLeft;

    private float mYTop;

    public SimulationDevice() {
    }

    public SimulationDevice(int id, String name, int imageId, String ipAddress, float XLeft, float YTop) {
        mId = id;
        mName = name;
        mImageId = imageId;
        mIpAddress = ipAddress;
        mXLeft = XLeft;
        mYTop = YTop;
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

    public float getXLeft() {
        return mXLeft;
    }

    public void setXLeft(float XLeft) {
        mXLeft = XLeft;
    }

    public float getYTop() {
        return mYTop;
    }

    public void setYTop(float YTop) {
        mYTop = YTop;
    }
}
