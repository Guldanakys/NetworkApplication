package com.example.networkapplication.chapters.details;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.networkapplication.R;
import com.example.networkapplication.models.Chapter;

public class ChapterDetailsActivity extends AppCompatActivity implements ChapterDetailsView {

    private int mChapterId;
    private ChapterDetailsPresenter mChapterDetailsPresenter;

    private ImageView mChapterImage;
    private TextView mChapterBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_details);

        mChapterId = getIntent().getIntExtra("chapterId", 0);
        mChapterDetailsPresenter = new ChapterDetailsPresenter(this);

        initUI();

        mChapterDetailsPresenter.getChapter(mChapterId);
    }

    private void initUI() {
        mChapterBody = (TextView) findViewById(R.id.chapter_body);
        mChapterImage = (ImageView) findViewById(R.id.chapter_image);
    }

    @Override
    public void showChapter(Chapter chapter) {
        mChapterBody.setText(chapter.getBody());
        Glide.with(this).load(chapter.getImage()).into(mChapterImage);
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
