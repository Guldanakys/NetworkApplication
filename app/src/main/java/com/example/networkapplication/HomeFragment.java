package com.example.networkapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.networkapplication.adapters.MenuItemAdapter;
import com.example.networkapplication.chapters.ChapterListActivity;
import com.example.networkapplication.models.MenuItem;
import com.example.networkapplication.quizes.QuizListActivity;
import com.example.networkapplication.simulation.SimulationActivity;
import com.example.networkapplication.videos.VideoActivity;
import com.example.networkapplication.videos.VideoListActivity;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements OnItemClickListener {

    private List<MenuItem> mMenuItemList;
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
        mMenuItemList = new ArrayList<>();
        mMenuItemList = DataLab.get().getMenuItemList();
        mMenuItemAdapter = new MenuItemAdapter(getActivity(), mMenuItemList);
        mMenuItemAdapter.setClickListener(this);
        mRecyclerView.setAdapter(mMenuItemAdapter);
    }

    @Override
    public void onItemClick(int position, int id) {
        final Intent intent;
        switch (id) {
            case 1:
                intent = new Intent(getActivity(), ChapterListActivity.class);
                break;
            case 2:
                intent = new Intent(getActivity(), VideoListActivity.class);
                break;
            case 3:
                intent = new Intent(getActivity(), QuizListActivity.class);
                break;
            case 4:
                intent = new Intent(getActivity(), SimulationActivity.class);
                break;
            default:
                intent = new Intent(getActivity(), ChapterListActivity.class);
                break;
        }
        startActivity(intent);
    }
}
