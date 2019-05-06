package com.example.networkapplication.quizes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.networkapplication.OnItemClickListener;
import com.example.networkapplication.R;
import com.example.networkapplication.adapters.QuizAdapter;
import com.example.networkapplication.models.Quiz;

import java.util.ArrayList;
import java.util.List;

public class QuizListActivity extends AppCompatActivity implements QuizView, OnItemClickListener {

    private QuizPresenter mQuizPresenter;
    private QuizAdapter mQuizAdapter;
    private RecyclerView mRecyclerView;
    private List<Quiz> mQuizList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_list);

        mQuizPresenter = new QuizPresenter(this);

        initUI();

        mQuizPresenter.getQuizes();

    }

    private void initUI() {
        mRecyclerView = (RecyclerView) findViewById(R.id.quiz_recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mQuizList = new ArrayList<>();
        mQuizAdapter = new QuizAdapter(mQuizList, this);
        mQuizAdapter.setItemClickListener(this);
        mRecyclerView.setAdapter(mQuizAdapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    public void showQuizList(List<Quiz> quizList) {
        mQuizList.addAll(quizList);
        mQuizAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError() {

    }

    @Override
    public void onItemClick(int position, int id) {
        Intent intent = new Intent(QuizListActivity.this, QuestionListActivity.class);
        startActivity(intent);
    }
}
