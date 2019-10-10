package com.wwdevelopers.dateme.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

import com.wwdevelopers.dateme.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ForgotPasswordActivity extends AppCompatActivity {


    Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        mActivity = ForgotPasswordActivity.this;
        ButterKnife.bind(mActivity);

    }



    @OnClick(R.id.activity_reset_password_reset_btn)
    public void processAccountForgotPassword(){

        //THIS IS WHERE YOU HANDLE ON FORGOT PASSWORD NOW BUTTON CLICK EVENT



    }




}
