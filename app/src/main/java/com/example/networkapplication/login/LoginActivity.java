package com.example.networkapplication.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.networkapplication.MainActivity;
import com.example.networkapplication.R;
import com.example.networkapplication.models.User;
import com.example.networkapplication.register.RegisterActivity;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private LoginPresenter mLoginPresenter;

    private EditText mUserEmail;
    private EditText mUserPassword;
    private Button mUserLogin;
    private TextView mSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mUserEmail = (EditText) findViewById(R.id.user_login_email);
        mUserPassword = (EditText) findViewById(R.id.user_login_password);
        mUserLogin = (Button) findViewById(R.id.user_login_button);
        mSignUp = (TextView) findViewById(R.id.user_login_registration);

        mLoginPresenter = new LoginPresenter(this);
        mUserLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoginPresenter.authorizeUser(new User("dana@gmail.com", "123!@#qweQWE"));
            }
        });

        mSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void loginSuccess(String token) {
        Toast.makeText(this, token, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void loginError() {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
    }

}
