package com.example.networkapplication.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.networkapplication.OnItemClickListener;
import com.example.networkapplication.R;
import com.example.networkapplication.models.Video;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoViewHolder> {

    private List<Video> mVideoList;

    private Context mContext;

    private OnItemClickListener mItemClickListener;

    public VideoAdapter(List<Video> videoList, Context context) {
        mVideoList = videoList;
        mContext = context;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.video_list_item, viewGroup, false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder videoViewHolder, int i) {
        Video video = mVideoList.get(i);
        videoViewHolder.bind(video, mItemClickListener, mContext);
    }

    @Override
    public int getItemCount() {
        return mVideoList.size();
    }

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }
}
