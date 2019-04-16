package com.example.networkapplication.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.networkapplication.OnItemClickListener;
import com.example.networkapplication.R;
import com.example.networkapplication.models.Chapter;

public class ChapterViewHolder extends RecyclerView.ViewHolder {

    private TextView mChapterNumber;
    private TextView mChapterTitle;
    private Chapter mChapter;

    public ChapterViewHolder(@NonNull View itemView) {
        super(itemView);
        mChapterNumber = (TextView) itemView.findViewById(R.id.chapter_number);
        mChapterTitle = (TextView) itemView.findViewById(R.id.chapter_title);
    }

    public void bind(Chapter chapter, int i, final OnItemClickListener itemClickListener) {
        mChapter = chapter;
        String chapterNumber = "Chapter " + i;
        mChapterNumber.setText(chapterNumber);
        mChapterTitle.setText(mChapter.getTitle());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClick(getAdapterPosition(), mChapter.getId());
            }
        });
    }
}
