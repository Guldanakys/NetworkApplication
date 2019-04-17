package com.example.networkapplication.service;

import com.example.networkapplication.models.Chapter;
import com.example.networkapplication.models.User;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ClientApi {

    @GET("/api/chapters")
    Call<List<Chapter>> getChapters();

    @GET("/api/chapters/{id}")
    Call<Chapter> getChapter(@Path("id") int id);

    @POST("/api/users/register")
    Call<User> registerUser(@Body User user);
}
