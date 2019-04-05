package com.example.networkapplication.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.networkapplication.R;
import com.example.networkapplication.models.Question;

public class QuestionListActivity extends AppCompatActivity {

    private Question mQuestion;

    private Button mOptionOne;
    private Button mOptionTwo;
    private Button mOptionThree;
    private Button mOptionFour;
    private TextView mQuestionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_list);
    }
}
