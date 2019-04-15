package com.example.networkapplication.chapters;

import android.app.ActionBar;
import android.icu.text.UnicodeSetSpanner;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.networkapplication.R;
import com.example.networkapplication.adapters.ChapterAdapter;
import com.example.networkapplication.models.Chapter;
import com.example.networkapplication.models.Post;
import com.example.networkapplication.service.ClientService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChapterListActivity extends AppCompatActivity implements ChapterView {

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
   }

    @Override
    public void showChapterList(List<Chapter> chapterList) {
        mChapterList.addAll(chapterList);
        mChapterAdapter = new ChapterAdapter(mChapterList);
        mRecyclerView.setAdapter(mChapterAdapter);
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
}
