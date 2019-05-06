package com.example.networkapplication.quizes;

import com.example.networkapplication.models.Quiz;

import java.util.List;

public interface QuizView {

    void showQuizList(List<Quiz> quizList);

    void showError();
}
