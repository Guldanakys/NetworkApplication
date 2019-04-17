package com.example.networkapplication.models;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id")
    private int mId;

    @SerializedName("nickName")
    private String mNickName;

    @SerializedName("firstName")
    private String mFirstName;

    @SerializedName("lastName")
    private String mLastName;

    @SerializedName("email")
    private String mEmail;

    @SerializedName("password")
    private String mPassword;

    @SerializedName("passwordConfirmation")
    private String mPasswordConfirmation;

    private double mProgress;

    private double mRating;

    public User() {
    }

    public User(String email, String password) {
        mEmail = email;
        mPassword = password;
    }

    public User(int id, String nickName, String firstName, String lastName, String email,
                String password, String passwordConfirmation) {
        mId = id;
        mNickName = nickName;
        mFirstName = firstName;
        mLastName = lastName;
        mEmail = email;
        mPassword = password;
        mPasswordConfirmation = passwordConfirmation;
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

    public String getPasswordConfirmation() {
        return mPasswordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        mPasswordConfirmation = passwordConfirmation;
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
