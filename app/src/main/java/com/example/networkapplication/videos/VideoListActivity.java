package com.example.networkapplication.videos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.networkapplication.OnItemClickListener;
import com.example.networkapplication.R;
import com.example.networkapplication.adapters.VideoAdapter;
import com.example.networkapplication.models.Video;

import java.util.ArrayList;
import java.util.List;

public class VideoListActivity extends AppCompatActivity implements VideoView, OnItemClickListener {

    private VideoPresenter mVideoPresenter;
    private VideoAdapter mVideoAdapter;
    private RecyclerView mRecyclerView;
    private List<Video> mVideoList;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_list);

        mVideoPresenter = new VideoPresenter(this);

        initUI();

        mVideoPresenter.getVideos();
    }

    private void initUI() {
        mProgressBar = (ProgressBar) findViewById(R.id.video_list_progress);
        mRecyclerView = (RecyclerView) findViewById(R.id.video_recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mVideoList = new ArrayList<>();
        mVideoAdapter = new VideoAdapter(mVideoList, this);
        mVideoAdapter.setItemClickListener(this);
        mRecyclerView.setAdapter(mVideoAdapter);
        showProgress();
    }

    private void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgress() {
        mProgressBar.setVisibility(View.GONE);
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showVideoList(List<Video> videoList) {
        mVideoList.addAll(videoList);
        mVideoAdapter.notifyDataSetChanged();
        hideProgress();
    }

    @Override
    public void showError() {
        Toast.makeText(this, "Network failure", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(int position, int id) {
        Intent intent = new Intent(this, VideoActivity.class);
        String url = "";
        for (Video video : mVideoList) {
            if (video.getId() == id) {
                url = video.getUrl();
            }
        }
        intent.putExtra("video_url", url);
        startActivity(intent);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
