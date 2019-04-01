package com.example.networkapplication.models;

public class MenuItem {

    private int mId;

    private String mName;

    public MenuItem() {
    }

    public MenuItem(int id, String name) {
        mId = id;
        mName = name;
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
}
