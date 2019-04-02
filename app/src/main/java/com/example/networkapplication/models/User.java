package com.example.networkapplication.models;

public class User {

    private int mId;

    private String mNickName;

    private String mFirstName;

    private String mLastName;

    private String mEmail;

    private String mPassword;

    private double mProgress;

    private double mRating;

    public User() {
    }

    public User(int id, String nickName, String firstName, String lastName, String email,
                String password, double progress, double rating) {
        mId = id;
        mNickName = nickName;
        mFirstName = firstName;
        mLastName = lastName;
        mEmail = email;
        mPassword = password;
        mProgress = progress;
        mRating = rating;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getNickName() {
        return mNickName;
    }

    public void setNickName(String nickName) {
        mNickName = nickName;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    public double getProgress() {
        return mProgress;
    }

    public void setProgress(double progress) {
        mProgress = progress;
    }

    public double getRating() {
        return mRating;
    }

    public void setRating(double rating) {
        mRating = rating;
    }
}
