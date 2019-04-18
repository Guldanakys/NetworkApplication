package com.example.networkapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.networkapplication.login.LoginActivity;
import com.example.networkapplication.session.SaveSharedPreference;

public class NotificationsFragment extends Fragment {

    private Button mLogout;
    private Button mToken;

    public NotificationsFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view =  inflater.inflate(R.layout.fragment_notifications, container, false);

        mLogout = (Button) view.findViewById(R.id.user_logout);
        mToken = (Button) view.findViewById(R.id.user_token);

        mLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveSharedPreference.setLoggedIn(getActivity(), false);
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        mToken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = SaveSharedPreference.getUserToken(getActivity());
                Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

}
