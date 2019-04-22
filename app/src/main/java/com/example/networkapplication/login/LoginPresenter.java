package com.example.networkapplication.login;

import android.util.Log;

import com.example.networkapplication.models.User;
import com.example.networkapplication.service.ClientService;
import com.example.networkapplication.models.MyResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter {

    private static final String TAG = "LoginPresenter";

    private LoginView mLoginView;

    private ClientService mClientService;

    private MyResponse mResponse;

    public LoginPresenter(LoginView loginView) {
        mLoginView = loginView;

        if (mClientService == null) {
            mClientService = new ClientService();
        }

    }

    public void authorizeUser(User user) {
        mClientService.getApi().logUser(user).enqueue(new Callback<MyResponse>() {
            @Override
            public void onResponse(Call<MyResponse> call, Response<MyResponse> response) {
                if (response.isSuccessful()) {
                    mResponse = response.body();
                }
                mLoginView.loginSuccess(mResponse.getToken());
            }

            @Override
            public void onFailure(Call<MyResponse> call, Throwable t) {
                Log.d(TAG, "Error connection");
            }
        });
    }

    public void authUser(String email, String password) {
        mClientService.getApi().loginUser(email, password).enqueue(new Callback<MyResponse>() {
            @Override
            public void onResponse(Call<MyResponse> call, Response<MyResponse> response) {
                if (response.isSuccessful()) {
                    mResponse = response.body();
                }
                mLoginView.loginSuccess(mResponse.getToken());
            }

            @Override
            public void onFailure(Call<MyResponse> call, Throwable t) {
                Log.d(TAG, "Error connection");
            }
        });
    }
}
