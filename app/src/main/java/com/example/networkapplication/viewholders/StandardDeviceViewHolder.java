package com.example.networkapplication.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.networkapplication.OnItemClickListener;
import com.example.networkapplication.R;
import com.example.networkapplication.models.StandardDevice;

public class StandardDeviceViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView mStandardDeviceTitle;
    private ImageView mStandardDeviceImage;
    private StandardDevice mStandardDevice;
    private OnItemClickListener mItemClickListener;

    public StandardDeviceViewHolder(@NonNull View itemView) {
        super(itemView);

        mStandardDeviceTitle = (TextView) itemView.findViewById(R.id.device_name);
        mStandardDeviceImage = (ImageView) itemView.findViewById(R.id.device_image);

        itemView.setOnClickListener(this);
    }

    public void bind(StandardDevice standardDevice, OnItemClickListener itemClickListener) {
        mStandardDevice = standardDevice;
        mStandardDeviceTitle.setText(mStandardDevice.getTitle());
        mStandardDeviceImage.setImageResource(mStandardDevice.getImageId());
        mItemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {
        mItemClickListener.onItemClick(getAdapterPosition(), mStandardDevice.getId());
    }
}
