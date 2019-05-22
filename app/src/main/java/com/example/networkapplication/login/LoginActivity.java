package com.example.networkapplication.login;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.networkapplication.MainActivity;
import com.example.networkapplication.R;
import com.example.networkapplication.session.SaveSharedPreference;
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

        mLoginPresenter = new LoginPresenter(this);

        initUI();

        checkSession();
    }

    private void initUI() {
        mUserEmail = (EditText) findViewById(R.id.user_login_email);
        mUserPassword = (EditText) findViewById(R.id.user_login_password);
        mUserLogin = (Button) findViewById(R.id.user_login_button);
        mSignUp = (TextView) findViewById(R.id.user_login_registration);
        mUserLogin.setOnClickListener(loginClickListener);
        mSignUp.setOnClickListener(signUpClickListener);
    }

    private void checkSession() {
        if (SaveSharedPreference.getLoggedStatus(getApplicationContext())) {
            startMain(this);
            finish();
        }
    }

    View.OnClickListener signUpClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startRegister(LoginActivity.this);
        }
    };

    View.OnClickListener loginClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mLoginPresenter.authorizeUser(new User(mUserEmail.getText().toString(), mUserPassword.getText().toString()));
        }
    };

    @Override
    public void loginSuccess(String token) {
        Toast.makeText(this, token, Toast.LENGTH_SHORT).show();
        SaveSharedPreference.setLoggedIn(getApplicationContext(), true);
        SaveSharedPreference.setUserToken(getApplicationContext(), token);
        startMain(this);
        finish();
    }

    @Override
    public void loginError() {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
    }

    public static void startMain(Context context) {
        Intent starter = new Intent(context, MainActivity.class);
        context.startActivity(starter);
    }

    public static void startRegister(Context context) {
        Intent starter = new Intent(context, RegisterActivity.class);
        context.startActivity(starter);
    }

}
