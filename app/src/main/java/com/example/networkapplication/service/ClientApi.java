package com.example.networkapplication.service;

import com.example.networkapplication.models.Chapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ClientApi {

    @GET("/api/chapters")
    Call<List<Chapter>> getChapters();

    @GET("/api/chapters/{id}")
    Call<Chapter> getChapter(@Path("id") int id);
}
