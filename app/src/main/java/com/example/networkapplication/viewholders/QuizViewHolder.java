package com.example.networkapplication.viewholders;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.networkapplication.OnItemClickListener;
import com.example.networkapplication.R;
import com.example.networkapplication.models.Quiz;

public class QuizViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView mQuizModule;
    private TextView mQuizTitle;
    private Quiz mQuiz;
    private OnItemClickListener mItemClickListener;

    public QuizViewHolder(@NonNull View itemView) {
        super(itemView);

        mQuizModule = (TextView) itemView.findViewById(R.id.quiz_module);
        mQuizTitle = (TextView) itemView.findViewById(R.id.quiz_title);

        itemView.setOnClickListener(this);
    }

    public void bind(Quiz quiz, final OnItemClickListener itemClickListener) {
        mQuiz = quiz;
        mQuizModule.setText(mQuiz.getModule());
        mQuizTitle.setText(mQuiz.getTitle());
        mItemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {
        mItemClickListener.onItemClick(getAdapterPosition(), mQuiz.getId());
    }
}
