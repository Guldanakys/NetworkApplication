package com.example.networkapplication.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClientService {

    private static Retrofit sRetrofit = null;

    private static final String BASE_URL = "https://computernetworkslearningapp20190414112246.azurewebsites.net";

    public ClientApi getApi() {
        if (sRetrofit == null) {
            sRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return sRetrofit.create(ClientApi.class);
    }
}
