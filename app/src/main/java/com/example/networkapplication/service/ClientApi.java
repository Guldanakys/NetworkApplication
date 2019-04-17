package com.example.networkapplication.service;

import com.example.networkapplication.models.Chapter;
import com.example.networkapplication.models.MyResponse;
import com.example.networkapplication.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
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

    @FormUrlEncoded
    @POST("/api/users/login")
    Call<MyResponse> loginUser(@Field("email") String email,
                               @Field("password") String password);

    @POST("/api/users/login")
    Call<MyResponse> logUser(@Body User user);
}
