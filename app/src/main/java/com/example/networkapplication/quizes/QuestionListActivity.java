package com.example.networkapplication.quizes;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.networkapplication.R;
import com.example.networkapplication.models.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionListActivity extends AppCompatActivity implements View.OnClickListener {

    private Question mQuestion;
    private TextView mQuestionTitle;
    private Button mOptionOne;
    private Button mOptionTwo;
    private Button mOptionThree;
    private Button mOptionFour;

    private List<Question> mQuestionList;
    private int mTotalCount = 0;
    private int mCorrectCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_list);

        initUI();
        loadQuestions();
        updateQuestion();
    }

    private void initUI() {
        mQuestionTitle = (TextView) findViewById(R.id.question_title);
        mOptionOne = (Button) findViewById(R.id.option_one);
        mOptionTwo = (Button) findViewById(R.id.option_two);
        mOptionThree = (Button) findViewById(R.id.option_three);
        mOptionFour = (Button) findViewById(R.id.option_four);
        mOptionOne.setOnClickListener(this);
        mOptionTwo.setOnClickListener(this);
        mOptionThree.setOnClickListener(this);
        mOptionFour.setOnClickListener(this);
        mQuestionList = new ArrayList<>();
    }

    private void loadQuestions() {
        mQuestionList.add(new Question(1, "One MB is equal to?", "1024 Byte",
                "1024 KB","1000 KB","1024 GB","1024 KB"));
        mQuestionList.add(new Question(2, "What is used to make computer chips?", "Copper",
                "Steel","Silicon","Iron","Silicon"));
        mQuestionList.add(new Question(3, "TCP is used in which layer?", "Session layer",
                "Transport layer","Network layer","Application layer","Transport layer"));

    }

    private void updateQuestion() {
        enableButtons();
        if (mTotalCount >= mQuestionList.size()) {
            Toast.makeText(this, mTotalCount+"", Toast.LENGTH_SHORT).show();
        } else {
            mQuestion = mQuestionList.get(mTotalCount);
            mQuestionTitle.setText(mQuestion.getTitle());
            mOptionOne.setText(mQuestion.getOptionOne());
            mOptionTwo.setText(mQuestion.getOptionTwo());
            mOptionThree.setText(mQuestion.getOptionThree());
            mOptionFour.setText(mQuestion.getOptionFour());
        }
    }

    private void enableButtons() {
        mOptionOne.setEnabled(true);
        mOptionTwo.setEnabled(true);
        mOptionThree.setEnabled(true);
        mOptionFour.setEnabled(true);
    }

    private void disableButtons() {
        mOptionOne.setEnabled(false);
        mOptionTwo.setEnabled(false);
        mOptionThree.setEnabled(false);
        mOptionFour.setEnabled(false);
    }

    @Override
    public void onClick(View v) {
        final Button pressed = (Button)v;
        if (pressed.getText().equals(mQuestion.getAnswer())) {
            mCorrectCount++;
            pressed.setBackgroundColor(Color.GREEN);
        } else {
            pressed.setBackgroundColor(Color.RED);
        }

        disableButtons();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mTotalCount++;
                pressed.setBackgroundResource(R.color.colorPrimary);
                updateQuestion();
            }
        }, 1500);
    }
}
