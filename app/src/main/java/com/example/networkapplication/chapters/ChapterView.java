package com.example.networkapplication.chapters;

import com.example.networkapplication.models.Chapter;

import java.util.List;

public interface ChapterView {

    void showChapterList(List<Chapter> chapterList);

    void showError();
}
