package com.example.networkapplication.models;

public class Chapter {

    private int mId;

    private String mTitle;

    private String mBody;

    private String mImage;

    private double mRating;

    public Chapter() {
    }

    public Chapter(int id, String title, String body, String image, double rating) {
        mId = id;
        mTitle = title;
        mBody = body;
        mImage = image;
        mRating = rating;
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

    public String getBody() {
        return mBody;
    }

    public void setBody(String body) {
        mBody = body;
    }

    public String getImage() {
        return mImage;
    }

    public void setImage(String image) {
        mImage = image;
    }

    public double getRating() {
        return mRating;
    }

    public void setRating(double rating) {
        mRating = rating;
    }
}
