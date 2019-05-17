package com.example.networkapplication.models;

public class Coordinate {

    private String mHostName;

    private float mXLeft;

    private float mYTop;

    public Coordinate() {
    }

    public Coordinate(String hostName, float XLeft, float YTop) {
        mHostName = hostName;
        mXLeft = XLeft;
        mYTop = YTop;
    }

    public String getHostName() {
        return mHostName;
    }

    public void setHostName(String hostName) {
        mHostName = hostName;
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
