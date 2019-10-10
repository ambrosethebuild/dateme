package com.wwdevelopers.dateme.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.wwdevelopers.dateme.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity {

    Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mActivity = RegisterActivity.this;
        ButterKnife.bind(mActivity);

    }


    @OnClick(R.id.activity_register_register_btn)
    public void processRegistration(){

        //THIS IS WHERE YOU HANDLE ON SIGNUP NOW BUTTON CLICK EVENT


    }



    @OnClick(R.id.activity_register_login_btn)
    public void loginUser(){
        finish();
    }





}
