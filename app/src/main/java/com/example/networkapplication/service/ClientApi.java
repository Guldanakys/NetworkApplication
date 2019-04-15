package com.example.networkapplication.service;

import com.example.networkapplication.models.Chapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ClientApi {

    @GET("/api/chapters")
    Call<List<Chapter>> getChapters();
}
