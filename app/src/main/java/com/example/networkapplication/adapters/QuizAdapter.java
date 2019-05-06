package com.example.networkapplication.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.networkapplication.OnItemClickListener;
import com.example.networkapplication.R;
import com.example.networkapplication.models.Quiz;
import com.example.networkapplication.viewholders.QuizViewHolder;

import java.util.List;

public class QuizAdapter extends RecyclerView.Adapter<QuizViewHolder> {

    private List<Quiz> mQuizList;

    private Context mContext;

    private OnItemClickListener mItemClickListener;

    public QuizAdapter(List<Quiz> quizList, Context context) {
        mQuizList = quizList;
        mContext = context;
    }

    @NonNull
    @Override
    public QuizViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.quiz_list_item, viewGroup, false);
        return new QuizViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuizViewHolder quizViewHolder, int i) {
        Quiz quiz = mQuizList.get(i);
        quizViewHolder.bind(quiz, mItemClickListener);
    }

    @Override
    public int getItemCount() {
        return mQuizList.size();
    }

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }
}
