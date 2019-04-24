package com.example.networkapplication.profile;

import com.example.networkapplication.service.ClientService;

public class ProfilePresenter {

    private static final String TAG = "ProfilePresenter";

    private ProfileView mProfileView;

    private ClientService mClientService;

    public  ProfilePresenter(ProfileView profileView) {
        mProfileView = profileView;

        if (mClientService == null) {
            mClientService = new ClientService();
        }
    }

    public void getUser(int id) {

    }
}
