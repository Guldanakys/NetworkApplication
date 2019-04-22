package com.example.networkapplication.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.networkapplication.OnItemClickListener;
import com.example.networkapplication.R;
import com.example.networkapplication.models.Video;

public class VideoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private TextView mVideoTitle;
    private ImageView mVideoImage;
    private Video mVideo;
    private OnItemClickListener mItemClickListener;

    public VideoViewHolder(@NonNull View itemView) {
        super(itemView);

        mVideoTitle = (TextView) itemView.findViewById(R.id.video_title);
        mVideoImage = (ImageView) itemView.findViewById(R.id.video_image);

        itemView.setOnClickListener(this);
    }

    public void bind(Video video, final OnItemClickListener itemClickListener, Context context) {
        mVideo = video;
        mVideoTitle.setText(mVideo.getTitle());
        Glide.with(context).load(mVideo.getImage()).into(mVideoImage);
        mItemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {
        mItemClickListener.onItemClick(getAdapterPosition(), mVideo.getId());
    }
}
