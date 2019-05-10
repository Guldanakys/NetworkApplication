package com.example.networkapplication.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.networkapplication.OnItemClickListener;
import com.example.networkapplication.R;
import com.example.networkapplication.models.Device;

public class DeviceViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView mDeviceName;
    private ImageView mDeviceImage;
    private Device mDevice;
    private OnItemClickListener mItemClickListener;

    public DeviceViewHolder(@NonNull View itemView) {
        super(itemView);

        mDeviceName = (TextView) itemView.findViewById(R.id.device_name);
        mDeviceImage = (ImageView) itemView.findViewById(R.id.device_image);

        itemView.setOnClickListener(this);
    }

    public void bind(Device device, OnItemClickListener itemClickListener) {
        mDevice = device;
        mDeviceName.setText(mDevice.getName());
        mDeviceImage.setImageResource(mDevice.getImageId());
        mItemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {
        mItemClickListener.onItemClick(getAdapterPosition(), mDevice.getId());
    }
}
