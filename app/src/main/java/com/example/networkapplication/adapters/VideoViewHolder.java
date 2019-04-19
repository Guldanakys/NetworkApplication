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

public class VideoViewHolder extends RecyclerView.ViewHolder {

    private TextView mVideoTitle;
    private ImageView mVideoImage;
    private Video mVideo;

    public VideoViewHolder(@NonNull View itemView) {
        super(itemView);

        mVideoTitle = (TextView) itemView.findViewById(R.id.video_title);
        mVideoImage = (ImageView) itemView.findViewById(R.id.video_image);
    }

    public void bind(Video video, final OnItemClickListener itemClickListener, Context context) {
        mVideo = video;
        mVideoTitle.setText(mVideo.getTitle());
        Glide.with(context).load(mVideo.getImage()).into(mVideoImage);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClick(getAdapterPosition(), mVideo.getId());
            }
        });
    }
}
