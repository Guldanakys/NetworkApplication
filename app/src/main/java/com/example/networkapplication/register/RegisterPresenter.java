package com.example.networkapplication.register;

import android.util.Log;

import com.example.networkapplication.models.User;
import com.example.networkapplication.service.ClientService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterPresenter {

    private static final String TAG = "RegisterPresenter";

    private RegisterView mRegisterView;

    private ClientService mClientService;

    public RegisterPresenter(RegisterView registerView) {
        mRegisterView = registerView;

        if (mClientService == null) {
            mClientService = new ClientService();
        }
    }

    public void registerUser(User user) {
        mClientService.getApi().registerUser(user).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    User u = response.body();
                } else {
                    Log.d(TAG, response.errorBody().toString());
                }
                mRegisterView.registerSuccess();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                mRegisterView.registerError();
            }
        });
    }


}
