package com.example.networkapplication.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.networkapplication.MainActivity;
import com.example.networkapplication.R;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private LoginPresenter mLoginPresenter;

    private EditText mUserEmail;
    private EditText mUserPassword;
    private Button mUserLogin;

    private SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mSharedPreferences = getSharedPreferences("login", MODE_PRIVATE);

        if (mSharedPreferences.getBoolean("logged", false)) {
            startMain(this);
            finish();
        }

        mUserEmail = (EditText) findViewById(R.id.user_login_email);
        mUserPassword = (EditText) findViewById(R.id.user_login_password);
        mUserLogin = (Button) findViewById(R.id.user_login_button);

        mLoginPresenter = new LoginPresenter(this);
        mUserLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoginPresenter.authorizeUser(mUserEmail.getText().toString(),
                        mUserPassword.getText().toString());
                mSharedPreferences.edit().putBoolean("logged", true).apply();
                finish();
            }
        });
    }

    @Override
    public void loginSuccess() {
        startMain(this);
    }

    @Override
    public void loginError() {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
    }

    public static void startMain(Context context) {
        Intent starter = new Intent(context, MainActivity.class);
        context.startActivity(starter);
    }
}
