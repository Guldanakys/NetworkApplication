package com.example.networkapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.networkapplication.models.User;

public class ProfileFragment extends Fragment {

    private User mUser;
    private TextView mNickName;
    private TextView mFullName;
    private TextView mProgress;
    private TextView mRating;
    private TextView mEmail;

    public ProfileFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        mNickName = (TextView) view.findViewById(R.id.user_nick_name);
        mProgress = (TextView) view.findViewById(R.id.user_progress);
        mRating = (TextView) view.findViewById(R.id.user_rating);
        mFullName = (TextView) view.findViewById(R.id.user_full_name);
        mEmail = (TextView) view.findViewById(R.id.user_email);

        return view;
    }

}
