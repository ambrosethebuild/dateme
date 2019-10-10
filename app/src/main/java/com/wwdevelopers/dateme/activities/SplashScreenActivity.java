package com.wwdevelopers.dateme.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.wwdevelopers.dateme.R;

public class SplashScreenActivity extends AppCompatActivity {


    Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        mActivity = SplashScreenActivity.this;


        //Wait for like 2secs before checking if your is loggedin or not
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //IF LOGGED IN CHECK SHOULD BE DONE HERE

                Intent login = new Intent(mActivity,LoginActivity.class);
                startActivity(login);

            }
        },2000);
    }



}
