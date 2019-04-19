package com.example.networkapplication.videos;

import com.example.networkapplication.models.Video;

import java.util.ArrayList;
import java.util.List;

public class VideoPresenter {

    private static final String TAG = "VideoPresenter";

    private VideoView mVideoView;

    private List<Video> mVideoList;

    public VideoPresenter(VideoView videoView) {
        mVideoView = videoView;
    }

    public void getVideos() {
        mVideoList = new ArrayList<>();
        mVideoList.add(new Video(1, "OSI Model Explained",
                "https://img.youtube.com/vi/vv4y_uOneC0/maxresdefault.jpg",
                "https://www.youtube.com/watch?v=vv4y_uOneC0"));
        mVideoList.add(new Video(2, "What is Ethernet?",
                "https://img.youtube.com/vi/HLziLmaYsO0/maxresdefault.jpg",
                "https://www.youtube.com/watch?v=HLziLmaYsO0"));
        mVideoView.showVideoList(mVideoList);
    }
}
