package com.example.networkapplication.chapters;

import android.util.Log;

import com.example.networkapplication.models.Chapter;
import com.example.networkapplication.service.ClientService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChapterPresenter {

    private static final String TAG = "ChapterPresenter";

    private ChapterView mChapterView;

    private List<Chapter> mChapterList;

    public ChapterPresenter(ChapterView chapterView) {
        mChapterView = chapterView;
    }

    public void getChapters() {
        mChapterList = new ArrayList<>();
        ClientService.getInstance().getClientApi().getChapters().enqueue(new Callback<List<Chapter>>() {
            @Override
            public void onResponse(Call<List<Chapter>> call, Response<List<Chapter>> response) {
                if (response.isSuccessful()) {
                    mChapterList = response.body();
                } else {
                    Log.d(TAG, response.errorBody().toString());
                }
                mChapterView.showChapterList(mChapterList);
            }

            @Override
            public void onFailure(Call<List<Chapter>> call, Throwable t) {
                mChapterView.showError();
            }
        });
    }
}
