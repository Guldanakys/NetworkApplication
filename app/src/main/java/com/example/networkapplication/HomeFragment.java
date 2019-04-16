package com.example.networkapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.networkapplication.adapters.MenuItemAdapter;
import com.example.networkapplication.chapters.ChapterListActivity;
import com.example.networkapplication.labs.MenuItemLab;
import com.example.networkapplication.models.MenuItem;
import com.example.networkapplication.quiz.QuestionListActivity;

import java.util.List;

public class HomeFragment extends Fragment implements OnItemClickListener {

    private MenuItemLab mMenuItemLab;
    private List<MenuItem> mMenuItems;
    private RecyclerView mRecyclerView;
    private MenuItemAdapter mMenuItemAdapter;

    public HomeFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initUI(view);
        return view;
    }

    private void initUI(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.menu_recycler);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mMenuItemLab = MenuItemLab.get();
        mMenuItems = mMenuItemLab.getMenuItemList();
        mMenuItemAdapter = new MenuItemAdapter(getActivity(), mMenuItems);
        mMenuItemAdapter.setClickListener(this);
        mRecyclerView.setAdapter(mMenuItemAdapter);
    }

    @Override
    public void onItemClick(View view, int position, int id) {
        final Intent intent;
        switch (position) {
            case 1:
                intent = new Intent(getActivity(), ChapterListActivity.class);
                break;
            default:
                intent = new Intent(getActivity(), QuestionListActivity.class);
        }
        startActivity(intent);
    }
}
