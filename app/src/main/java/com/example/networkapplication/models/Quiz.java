package com.example.networkapplication.models;

public class Quiz {

    private int mId;

    private String mModule;

    private String mTitle;

    public Quiz() {
    }

    public Quiz(int id, String module, String title) {
        mId = id;
        mTitle = title;
        mModule = module;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getModule() {
        return mModule;
    }

    public void setModule(String module) {
        mModule = module;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
