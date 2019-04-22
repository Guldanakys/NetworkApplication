package com.example.networkapplication.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.networkapplication.OnItemClickListener;
import com.example.networkapplication.R;
import com.example.networkapplication.models.Chapter;

public class ChapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView mChapterNumber;
    private TextView mChapterTitle;
    private ImageView mChapterImage;
    private Chapter mChapter;
    private OnItemClickListener mItemClickListener;

    public ChapterViewHolder(@NonNull View itemView) {
        super(itemView);
        mChapterNumber = (TextView) itemView.findViewById(R.id.chapter_item_number);
        mChapterTitle = (TextView) itemView.findViewById(R.id.chapter_item_title);
        mChapterImage = (ImageView) itemView.findViewById(R.id.chapter_item_image);

        itemView.setOnClickListener(this);
    }

    public void bind(Chapter chapter, int i, final OnItemClickListener itemClickListener, Context context) {
        mChapter = chapter;
        String chapterNumber = "Chapter " + i;
        mChapterNumber.setText(chapterNumber);
        mChapterTitle.setText(mChapter.getTitle());
        Glide.with(context).load(chapter.getImage()).into(mChapterImage);
        mItemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {
        mItemClickListener.onItemClick(getAdapterPosition(), mChapter.getId());
    }
}
