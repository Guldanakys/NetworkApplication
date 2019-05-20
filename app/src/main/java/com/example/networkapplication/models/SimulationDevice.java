package com.example.networkapplication.models;

public class SimulationDevice extends Device {

    private String mIpAddress;

    private String mSubnetMask;

    private String mGateway;

    private float mXLeft;

    private float mYTop;

    public SimulationDevice() {
    }

    public SimulationDevice(int id,
                            String name,
                            int imageId,
                            String ipAddress,
                            String subnetMask,
                            String gateway,
                            float XLeft,
                            float YTop) {
        super(id, name, imageId);
        mIpAddress = ipAddress;
        mSubnetMask = subnetMask;
        mGateway = gateway;
        mXLeft = XLeft;
        mYTop = YTop;
    }

    public String getIpAddress() {
        return mIpAddress;
    }

    public void setIpAddress(String ipAddress) {
        mIpAddress = ipAddress;
    }

    public String getSubnetMask() {
        return mSubnetMask;
    }

    public void setSubnetMask(String subnetMask) {
        mSubnetMask = subnetMask;
    }

    public String getGateway() {
        return mGateway;
    }

    public void setGateway(String gateway) {
        mGateway = gateway;
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
