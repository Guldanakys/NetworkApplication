package com.example.networkapplication.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClientService {

    private static ClientService mInstance;

    private static final String BASE_URL = "https://computernetworkslearningapp20190414112246.azurewebsites.net";

    private Retrofit mRetrofit;

    private ClientService() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ClientService getInstance() {

        if (mInstance == null) {
            mInstance = new ClientService();
        }
        return mInstance;
    }

    public ClientApi getClientApi() {
        return mRetrofit.create(ClientApi.class);
    }
}
