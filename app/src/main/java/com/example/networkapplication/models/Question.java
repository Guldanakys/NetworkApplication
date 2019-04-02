package com.example.networkapplication.models;

public class Question {

    private int mId;

    private String mQuestion;

    private String mOptionOne;

    private String mOptionTwo;

    private String mOptionThree;

    private String mOptionFour;

    private String mAnswer;

    public Question() {
    }

    public Question(int id, String question, String optionOne, String optionTwo,
                    String optionThree, String optionFour, String answer) {
        mId = id;
        mQuestion = question;
        mOptionOne = optionOne;
        mOptionTwo = optionTwo;
        mOptionThree = optionThree;
        mOptionFour = optionFour;
        mAnswer = answer;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getQuestion() {
        return mQuestion;
    }

    public void setQuestion(String question) {
        mQuestion = question;
    }

    public String getOptionOne() {
        return mOptionOne;
    }

    public void setOptionOne(String optionOne) {
        mOptionOne = optionOne;
    }

    public String getOptionTwo() {
        return mOptionTwo;
    }

    public void setOptionTwo(String optionTwo) {
        mOptionTwo = optionTwo;
    }

    public String getOptionThree() {
        return mOptionThree;
    }

    public void setOptionThree(String optionThree) {
        mOptionThree = optionThree;
    }

    public String getOptionFour() {
        return mOptionFour;
    }

    public void setOptionFour(String optionFour) {
        mOptionFour = optionFour;
    }

    public String getAnswer() {
        return mAnswer;
    }

    public void setAnswer(String answer) {
        mAnswer = answer;
    }
}
