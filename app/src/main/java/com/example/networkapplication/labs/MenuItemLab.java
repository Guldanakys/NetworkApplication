package com.example.networkapplication.labs;

import com.example.networkapplication.models.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MenuItemLab {

    private static MenuItemLab sMenuItemLab;

    private List<MenuItem> mMenuItemList;

    public static MenuItemLab get() {
        if (sMenuItemLab == null) {
            sMenuItemLab = new MenuItemLab();
        }
        return sMenuItemLab;
    }

    private MenuItemLab() {
        mMenuItemList = new ArrayList<>();
        mMenuItemList.add(new MenuItem(1, "Chapters", "ic_personal_desktop"));
        mMenuItemList.add(new MenuItem(2, "Videos", "ic_video_library"));
        mMenuItemList.add(new MenuItem(3, "Quiz", "ic_pen"));
        mMenuItemList.add(new MenuItem(4, "Simulation", "ic_router"));
    }

    public List<MenuItem> getMenuItemList() {
        return mMenuItemList;
    }

}