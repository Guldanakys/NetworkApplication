package com.example.networkapplication.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.example.networkapplication.R;

public class LoadingViewHolder extends RecyclerView.ViewHolder {

    private ProgressBar mProgressBar;

    public LoadingViewHolder(@NonNull View itemView) {
        super(itemView);
        mProgressBar = (ProgressBar) itemView.findViewById(R.id.progress_bar);
    }

    private void showLoadingView(LoadingViewHolder viewHolder, int position) {
    }
}
