package com.example.networkapplication;

import com.example.networkapplication.models.MenuItem;
import com.example.networkapplication.models.Question;
import com.example.networkapplication.models.Quiz;
import com.example.networkapplication.models.StandardDevice;

import java.util.ArrayList;
import java.util.List;

public class DataLab {

    private static DataLab sDataLab;

    private List<MenuItem> mMenuItemList;

    private List<StandardDevice> mStandardDeviceList;

    private List<Quiz> mQuizList;

    private List<Question> mQuestionList;

    public static DataLab get() {
        if (sDataLab == null) {
            sDataLab = new DataLab();
        }
        return sDataLab;
    }

    private DataLab() {
        mMenuItemList = new ArrayList<>();
        mStandardDeviceList = new ArrayList<>();
        mQuizList = new ArrayList<>();
        mQuestionList = new ArrayList<>();
        fillMenuItemList();
        fillStandardDeviceList();
        fillQuizList();
        fillQuestionList();
    }

    public List<MenuItem> getMenuItemList() {
        return mMenuItemList;
    }

    public List<StandardDevice> getStandardDeviceList() {
        return mStandardDeviceList;
    }

    public List<Quiz> getQuizList() {
        return mQuizList;
    }

    public List<Question> getQuestionList() {
        return mQuestionList;
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

    private void fillQuizList() {
        mQuizList.add(new Quiz(1, "Module 1", "The OSI Reference Model"));
        mQuizList.add(new Quiz(2, "Module 2", "Ethernet Networking"));
        mQuizList.add(new Quiz(3, "Module 3", "Data Encapsulation"));
        mQuizList.add(new Quiz(4, "Module 4", "The Three-Layer Hierarchical Model"));
    }

    private void fillQuestionList() {
        mQuestionList.add(new Question(1,
                "This device breaks up collision domains and broadcast domains.",
                "Router",
                "Switch",
                "Hub",
                "Bridge",
                "Router"));
        mQuestionList.add(new Question(2,
                "What protocol is used to find the hardware address of a local device?",
                "RARP",
                "ARP",
                "IP",
                "ICMP",
                "ARP"));
        mQuestionList.add(new Question(3,
                "TCP is used in which layer?",
                "Session layer",
                "Transport layer",
                "Network layer",
                "Application layer",
                "Transport layer"));
        mQuestionList.add(new Question(4,
                "What type of RJ45 UTP cable is used between switches?",
                "Straight-through",
                "Crossover",
                "Console",
                "Rolled",
                "Crossover"));
        mQuestionList.add(new Question(5,
                "Segmentation of a data stream happens at which layer of the OSI model?",
                "Physical",
                "Data Link",
                "Network",
                "Transport",
                "Transport"));
    }
}
