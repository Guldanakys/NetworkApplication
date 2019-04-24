package com.example.networkapplication.videos;

import android.util.Log;

import com.example.networkapplication.models.Video;
import com.example.networkapplication.service.ClientService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VideoPresenter {

    private static final String TAG = "VideoPresenter";

    private VideoView mVideoView;

    private ClientService mClientService;

    private List<Video> mVideoList;

    public VideoPresenter(VideoView videoView) {
        mVideoView = videoView;

        if (mClientService == null) {
            mClientService = new ClientService();
        }
    }

    public void getVideos() {
        mVideoList = new ArrayList<>();
        mClientService.getApi().getVideos().enqueue(new Callback<List<Video>>() {
            @Override
            public void onResponse(Call<List<Video>> call, Response<List<Video>> response) {
                if (response.isSuccessful()) {
                    mVideoList = response.body();
                } else {
                    Log.d(TAG, response.errorBody().toString());
                }
                mVideoView.showVideoList(mVideoList);
            }

            @Override
            public void onFailure(Call<List<Video>> call, Throwable t) {
                mVideoView.showError();
            }
        });
        /*mVideoList.add(new Video(1, "OSI Model Explained",
                "https://img.youtube.com/vi/vv4y_uOneC0/maxresdefault.jpg",
                "https://www.youtube.com/watch?v=vv4y_uOneC0"));
        mVideoList.add(new Video(2, "What is Ethernet?",
                "https://img.youtube.com/vi/HLziLmaYsO0/maxresdefault.jpg",
                "https://www.youtube.com/watch?v=HLziLmaYsO0"));
        mVideoView.showVideoList(mVideoList);*/
    }
}
