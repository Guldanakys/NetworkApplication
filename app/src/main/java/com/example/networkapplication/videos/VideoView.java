package com.example.networkapplication.videos;

import com.example.networkapplication.models.Video;

import java.util.List;

public interface VideoView {

    void showVideoList(List<Video> videoList);

    void showError();
}
