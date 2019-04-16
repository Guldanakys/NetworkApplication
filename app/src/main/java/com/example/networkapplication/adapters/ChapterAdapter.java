package com.example.networkapplication.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.networkapplication.OnItemClickListener;
import com.example.networkapplication.R;
import com.example.networkapplication.models.Chapter;

import java.util.List;

public class ChapterAdapter extends RecyclerView.Adapter<ChapterViewHolder> {

    private List<Chapter> mChapterList;

    private OnItemClickListener mItemClickListener;

    public ChapterAdapter(List<Chapter> chapterList) {
        mChapterList = chapterList;
    }

    @NonNull
    @Override
    public ChapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.chapter_list_item, viewGroup, false);
        return new ChapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChapterViewHolder chapterViewHolder, int i) {
        Chapter chapter = mChapterList.get(i);
        chapterViewHolder.bind(chapter, i, mItemClickListener);
    }

    @Override
    public int getItemCount() {
        return mChapterList.size();
    }

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

}
