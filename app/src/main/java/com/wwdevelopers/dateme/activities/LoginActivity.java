package com.wwdevelopers.dateme.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.wwdevelopers.dateme.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {


    Activity mActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        mActivity = LoginActivity.this;
        ButterKnife.bind(mActivity);


    }


    @OnClick(R.id.activity_login_login_btn)
    public void loginUser(){

        //THIS IS WHERE YOU HANDLE ON LOGIN NOW BUTTON CLICK EVENT
        Intent home = new Intent(mActivity,HomeActivity.class);
        startActivity(home);


    }


    @OnClick(R.id.activity_login_register_btn)
    public void openSignup(){

        Intent register = new Intent(mActivity,RegisterActivity.class);
        startActivity(register);

    }


    @OnClick(R.id.activity_login_forgot_password_btn)
    public void openForgotPassword(){

        Intent forgot = new Intent(mActivity,ForgotPasswordActivity.class);
        startActivity(forgot);

    }


    @Override
    public void onBackPressed() {
        finishAffinity();
        super.onBackPressed();
    }



}
