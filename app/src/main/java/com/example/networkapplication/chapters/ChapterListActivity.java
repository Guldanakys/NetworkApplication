package com.example.networkapplication.chapters;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.networkapplication.OnItemClickListener;
import com.example.networkapplication.R;
import com.example.networkapplication.adapters.ChapterAdapter;
import com.example.networkapplication.chapters.details.ChapterDetailsActivity;
import com.example.networkapplication.models.Chapter;

import java.util.ArrayList;
import java.util.List;


public class ChapterListActivity extends AppCompatActivity implements ChapterView, OnItemClickListener {

    private ChapterPresenter mChapterPresenter;
    private ChapterAdapter mChapterAdapter;
    private RecyclerView mRecyclerView;
    private List<Chapter> mChapterList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_list);

        mChapterPresenter = new ChapterPresenter(this);

        initUI();

        mChapterPresenter.getChapters();
    }


   private void initUI() {
       mRecyclerView = (RecyclerView) findViewById(R.id.chapter_recycler);
       mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
       mChapterList = new ArrayList<>();
       mChapterAdapter = new ChapterAdapter(mChapterList);
       mChapterAdapter.setItemClickListener(this);
       mRecyclerView.setAdapter(mChapterAdapter);
   }

    @Override
    public void showChapterList(List<Chapter> chapterList) {
        mChapterList.addAll(chapterList);
        mChapterAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError() {
        Toast.makeText(this, "Network failure", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onSupportNavigateUp() {
       finish();
       return true;
    }

    @Override
    public void onItemClick(View view, int position, int id) {
        Intent intent = new Intent(this, ChapterDetailsActivity.class);
        intent.putExtra("chapterId", id);
        startActivity(intent);
    }
}
