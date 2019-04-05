package com.example.networkapplication.login;

import com.example.networkapplication.labs.DataLab;
import com.example.networkapplication.models.User;

import java.util.ArrayList;
import java.util.List;

public class LoginPresenter {

    private LoginView mLoginView;

    private List<User> mUserList;
    private User mUser;

    public LoginPresenter(LoginView loginView) {
        mLoginView = loginView;
        mUserList = new ArrayList<>();
    }

    public void authorizeUser(String email, String password) {
        mUserList = DataLab.get().getUserList();
        for (User user : mUserList) {
            if (user.getEmail().equals(email) &&
                user.getPassword().equals(password)) {
                mUser = user;
            }
        }
        if (mUser != null)
            mLoginView.loginSuccess();
        else
            mLoginView.loginError();
    }
}
