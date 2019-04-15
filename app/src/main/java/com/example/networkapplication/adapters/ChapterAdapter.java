package com.example.networkapplication.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.networkapplication.R;
import com.example.networkapplication.models.Chapter;

import java.util.List;

public class ChapterAdapter extends RecyclerView.Adapter<ChapterAdapter.ChapterHolder> {

    private List<Chapter> mChapterList;

    public ChapterAdapter(List<Chapter> chapterList) {
        mChapterList = chapterList;
    }

    @NonNull
    @Override
    public ChapterHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.chapter_list_item, viewGroup, false);
        return new ChapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChapterHolder chapterHolder, int i) {
        Chapter chapter = mChapterList.get(i);
        chapterHolder.bind(chapter);
    }

    @Override
    public int getItemCount() {
        return mChapterList.size();
    }

    public class ChapterHolder extends RecyclerView.ViewHolder {

        private TextView mChapterNumber;
        private TextView mChapterTitle;
        private Chapter mChapter;

        public ChapterHolder(@NonNull View itemView) {
            super(itemView);

            mChapterNumber = (TextView) itemView.findViewById(R.id.chapter_number);
            mChapterTitle = (TextView) itemView.findViewById(R.id.chapter_title);
        }

        public void bind(Chapter chapter) {
            mChapter = chapter;
            String chapterNumber = "Chapter " + mChapter.getId();
            mChapterNumber.setText(chapterNumber);
            mChapterTitle.setText(mChapter.getTitle());
        }
    }
}
