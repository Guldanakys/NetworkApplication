package com.example.networkapplication.chapters.details;

import android.util.Log;

import com.example.networkapplication.models.Chapter;
import com.example.networkapplication.service.ClientService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChapterDetailsPresenter {

    private static final String TAG = "ChapterDetailsPresenter";

    private ChapterDetailsView mChapterDetailsView;

    private ClientService mClientService;

    private Chapter mChapter;

    public ChapterDetailsPresenter(ChapterDetailsView chapterDetailsView) {
        mChapterDetailsView = chapterDetailsView;

        if (mClientService == null) {
            mClientService = new ClientService();
        }
    }

    public void getChapter(int id) {
        mClientService.getApi().getChapter(id).enqueue(new Callback<Chapter>() {
            @Override
            public void onResponse(Call<Chapter> call, Response<Chapter> response) {
                if (response.isSuccessful()) {
                    mChapter = response.body();
                } else {
                    Log.d(TAG, response.errorBody().toString());
                }
                mChapterDetailsView.showChapter(mChapter);
            }

            @Override
            public void onFailure(Call<Chapter> call, Throwable t) {
                mChapterDetailsView.showError();
            }
        });
    }

}
