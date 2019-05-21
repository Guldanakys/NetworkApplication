package com.example.networkapplication.quizes;

import com.example.networkapplication.DataLab;
import com.example.networkapplication.models.Quiz;

import java.util.ArrayList;
import java.util.List;

public class QuizPresenter {

    private static final String TAG = "QuizPresenter";

    private QuizView mQuizView;

    private List<Quiz> mQuizList;

    public QuizPresenter(QuizView quizView) {
        mQuizView = quizView;
    }

    public void getQuizes() {
        mQuizList = new ArrayList<>();
        mQuizList = DataLab.get().getQuizList();
        mQuizView.showQuizList(mQuizList);
    }
}
