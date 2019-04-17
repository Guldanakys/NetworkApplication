package com.example.networkapplication.register;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.networkapplication.R;
import com.example.networkapplication.models.User;

public class RegisterActivity extends AppCompatActivity implements RegisterView {

    private RegisterPresenter mRegisterPresenter;

    private EditText mUserNickName;
    private EditText mUserFirstName;
    private EditText mUserLastName;
    private EditText mUserEmail;
    private EditText mUserPassword;
    private Button mRegister;
    private User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mRegisterPresenter = new RegisterPresenter(this);

        initUI();

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkCredentials();
                mRegisterPresenter.registerUser(mUser);
            }
        });

    }

    private void initUI() {
        mUserNickName = (EditText) findViewById(R.id.user_register_nickname);
        mUserFirstName = (EditText) findViewById(R.id.user_register_first_name);
        mUserLastName = (EditText) findViewById(R.id.user_register_last_name);
        mUserEmail = (EditText) findViewById(R.id.user_register_email);
        mUserPassword = (EditText) findViewById(R.id.user_register_password);
        mRegister = (Button) findViewById(R.id.user_register_button);
    }

    private void checkCredentials() {
        mUser = new User(1, mUserNickName.getText().toString(),
                mUserFirstName.getText().toString(),
                mUserLastName.getText().toString(),
                mUserEmail.getText().toString(),
                "123!@#qweQWE", "123!@#qweQWE");
    }

    @Override
    public void registerSuccess() {
        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void registerError() {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onNavigateUp() {
        finish();
        return true;
    }
}
