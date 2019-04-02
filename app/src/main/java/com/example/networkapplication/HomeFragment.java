package com.example.networkapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import com.example.networkapplication.adapters.MenuItemAdapter;
import com.example.networkapplication.models.MenuItem;

import java.util.List;

public class HomeFragment extends Fragment {

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

        mRecyclerView = (RecyclerView) view.findViewById(R.id.menu_recycler);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mMenuItemLab = MenuItemLab.get();
        mMenuItems = mMenuItemLab.getMenuItemList();
        mMenuItemAdapter = new MenuItemAdapter(getActivity(), mMenuItems);
        mRecyclerView.setAdapter(mMenuItemAdapter);
        return view;
    }

}
