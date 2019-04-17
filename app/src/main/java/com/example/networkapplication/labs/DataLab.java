package com.example.networkapplication.labs;

import com.example.networkapplication.models.Question;
import com.example.networkapplication.models.User;

import java.util.ArrayList;
import java.util.List;

public class DataLab {

    private static DataLab sDataLab;

    private List<User> mUserList;
    private List<Question> mQuestionList;

    public static DataLab get() {
        if (sDataLab == null) {
            sDataLab = new DataLab();
        }
        return sDataLab;
    }

    private DataLab() {
        mUserList = new ArrayList<>();
        mQuestionList = new ArrayList<>();
        mUserList.add(new User(1, "IronMan", "Tony", "Stark",
                "tony@gmail.com", "123hello", "123hello"));
        mQuestionList.add(new Question(1, "One MB is equal to?",
                "1024 Byte", "1024 KB", "1000 KB",
                "1024 GB", "1024 KB"));
        mQuestionList.add(new Question(2, "What is used to make computer chips?",
                "Copper", "Steel", "Silicon",
                "Iron", "Silicon"));
    }

    public List<User> getUserList() {
        return mUserList;
    }

    public User getUser(int id) {
        for (User user : mUserList) {
            if (user.getId() == id)
                return user;
        }
        return null;
    }

    public List<Question> getQuestionList() {
        return mQuestionList;
    }

    public Question getQuestion(int id) {
        for (Question question : mQuestionList) {
            if (question.getId() == id)
                return question;
        }
        return null;
    }
}
