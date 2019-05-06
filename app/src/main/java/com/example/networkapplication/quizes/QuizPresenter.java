package com.example.networkapplication.quizes;

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
        mQuizList.add(new Quiz(1, "Module 1", "asd"));
        mQuizList.add(new Quiz(2, "Module 2", "asd"));
        mQuizList.add(new Quiz(3, "Module 3", "asd"));
        mQuizView.showQuizList(mQuizList);
    }
}
