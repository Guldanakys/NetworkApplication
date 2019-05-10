package com.example.networkapplication.profile;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.networkapplication.R;
import com.example.networkapplication.models.User;

public class ProfileFragment extends Fragment {

    public ProfileFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        initUI(view);



        return view;
    }

    private void initUI(View view) {
    }

}
