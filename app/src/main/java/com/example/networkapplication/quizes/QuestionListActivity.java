package com.example.networkapplication.quizes;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.networkapplication.DataLab;
import com.example.networkapplication.R;
import com.example.networkapplication.models.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionListActivity extends AppCompatActivity implements View.OnClickListener, QuizResultsDialogListener {

    private Question mQuestion;
    private TextView mQuestionTitle;
    private Button mOptionOne;
    private Button mOptionTwo;
    private Button mOptionThree;
    private Button mOptionFour;

    private List<Question> mQuestionList;
    private int mTotalCount = 0;
    private int mCorrectCount = 0;
    private int mIncorrectCount = 0;
    private TextView mTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_list);

        initUI();
        loadQuestions();
        updateQuestion();
        reverseTimer(60);
    }

    private void initUI() {
        mQuestionTitle = (TextView) findViewById(R.id.question_title);
        mOptionOne = (Button) findViewById(R.id.option_one);
        mOptionTwo = (Button) findViewById(R.id.option_two);
        mOptionThree = (Button) findViewById(R.id.option_three);
        mOptionFour = (Button) findViewById(R.id.option_four);
        mTimer = (TextView) findViewById(R.id.timer);
        mTimer.setText("00:00");
        mOptionOne.setOnClickListener(this);
        mOptionTwo.setOnClickListener(this);
        mOptionThree.setOnClickListener(this);
        mOptionFour.setOnClickListener(this);
        mQuestionList = new ArrayList<>();
    }

    private void loadQuestions() {
        mQuestionList = new ArrayList<>();
        mQuestionList = DataLab.get().getQuestionList();
    }

    private void updateQuestion() {
        enableButtons();
        if (mTotalCount >= mQuestionList.size()) {
            showResults();
        } else {
            mQuestion = mQuestionList.get(mTotalCount);
            mQuestionTitle.setText(mQuestion.getTitle());
            mOptionOne.setText(mQuestion.getOptionOne());
            mOptionTwo.setText(mQuestion.getOptionTwo());
            mOptionThree.setText(mQuestion.getOptionThree());
            mOptionFour.setText(mQuestion.getOptionFour());
        }
    }

    private void showResults() {
        QuizResultsDialog quizResultsDialog = new QuizResultsDialog();
        Bundle bundle = new Bundle();
        bundle.putString("correct", Integer.toString(mCorrectCount));
        bundle.putString("incorrect", Integer.toString(mIncorrectCount));
        quizResultsDialog.setArguments(bundle);
        quizResultsDialog.show(getSupportFragmentManager(), "results dialog");
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

    private void reverseTimer(int secondsGiven) {
        new CountDownTimer(secondsGiven * 1000 + 1000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                int seconds = (int) (millisUntilFinished / 1000);
                int minutes = seconds / 60;
                seconds = seconds % 60;
                String currentTimer = String.format("%02d", minutes) + ":" + String.format("%02d", seconds);
                mTimer.setText(currentTimer);
            }

            @Override
            public void onFinish() {
                mTimer.setText("Time is up!");
            }
        }.start();

    }

    @Override
    public void onClick(View v) {
        final Button pressed = (Button)v;
        if (pressed.getText().equals(mQuestion.getAnswer())) {
            mCorrectCount++;
            pressed.setBackgroundResource(R.drawable.green_quiz_background);
        } else {
            pressed.setBackgroundResource(R.drawable.red_quiz_background);
            mIncorrectCount++;
        }

        disableButtons();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mTotalCount++;
                pressed.setBackgroundResource(R.drawable.quiz_button_background);
                updateQuestion();
            }
        }, 1500);
    }

    @Override
    public void finishActivity() {
        finish();
    }
}
