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

    private TextView mUserName;
    private TextView mEmail;
    private TextView mFullName;

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
        mUserName = (TextView) view.findViewById(R.id.profile_username);
        mEmail = (TextView) view.findViewById(R.id.profile_email);
        mFullName = (TextView) view.findViewById(R.id.profile_full_name);

        User user = new User(1, "Azorahai", "Arya", "Stark", "arya@gmail.com", "", "");
        mUserName.setText(user.getNickName());
        mEmail.setText(user.getEmail());
        mFullName.setText(user.getFirstName() + " " + user.getLastName());
    }

}
