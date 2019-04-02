package com.example.networkapplication.models;

public class MenuItem {

    private int mId;

    private String mName;

    private String mImage;

    public MenuItem() {
    }

    public MenuItem(int id, String name, String image) {
        mId = id;
        mName = name;
        mImage = image;
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

    public String getImage() {
        return mImage;
    }

    public void setImage(String image) {
        mImage = image;
    }
}
