package com.example.networkapplication.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.networkapplication.OnItemClickListener;
import com.example.networkapplication.R;
import com.example.networkapplication.models.StandardDevice;
import com.example.networkapplication.viewholders.StandardDeviceViewHolder;

import java.util.List;

public class StandardDeviceAdapter extends RecyclerView.Adapter<StandardDeviceViewHolder> {

    private List<StandardDevice> mStandardDeviceList;

    private OnItemClickListener mItemClickListener;

    public StandardDeviceAdapter(List<StandardDevice> standardDeviceList) {
        mStandardDeviceList = standardDeviceList;
    }

    @NonNull
    @Override
    public StandardDeviceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.standard_device_list_item, viewGroup,false);
        return new StandardDeviceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StandardDeviceViewHolder deviceViewHolder, int i) {
        StandardDevice standardDevice = mStandardDeviceList.get(i);
        deviceViewHolder.bind(standardDevice, mItemClickListener);
    }

    @Override
    public int getItemCount() {
        return mStandardDeviceList.size();
    }

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }
}
