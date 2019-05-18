package com.example.networkapplication;

import com.example.networkapplication.models.MenuItem;
import com.example.networkapplication.models.StandardDevice;

import java.util.ArrayList;
import java.util.List;

public class DataLab {

    private static DataLab sDataLab;

    private List<MenuItem> mMenuItemList;

    private List<StandardDevice> mStandardDeviceList;

    public static DataLab get() {
        if (sDataLab == null) {
            sDataLab = new DataLab();
        }
        return sDataLab;
    }

    private DataLab() {
        mMenuItemList = new ArrayList<>();
        mStandardDeviceList = new ArrayList<>();
        fillMenuItemList();
        fillStandardDeviceList();
    }

    public List<MenuItem> getMenuItemList() {
        return mMenuItemList;
    }

    public List<StandardDevice> getStandardDeviceList() {
        return mStandardDeviceList;
    }

    private void fillMenuItemList() {
        mMenuItemList.add(new MenuItem(1, "Chapters", "ic_chapters"));
        mMenuItemList.add(new MenuItem(2, "Videos", "ic_videos"));
        mMenuItemList.add(new MenuItem(3, "Quiz", "ic_quiz"));
        mMenuItemList.add(new MenuItem(4, "Simulation", "ic_simulation"));
    }

    private void  fillStandardDeviceList() {
        mStandardDeviceList.add(new StandardDevice(1, "Laptop", R.drawable.ic_laptop));
        mStandardDeviceList.add(new StandardDevice(2, "Switch", R.drawable.ic_switch));
        mStandardDeviceList.add(new StandardDevice(3, "Router", R.drawable.ic_router));
    }
}
