package com.wwdevelopers.dateme.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wwdevelopers.dateme.R;
import com.wwdevelopers.dateme.adapters.GalleyPictureAdapter;
import com.wwdevelopers.dateme.models.UserModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserFullDetailsActivity extends AppCompatActivity {


    UserModel userModel;
    Activity mActivity;

    @BindView(R.id.activity_user_full_details_background_img) ImageView user_full_details_background_img;
    @BindView(R.id.activity_user_full_details_user_img) ImageView user_full_details_user_img;
    @BindView(R.id.activity_user_full_details_user_status_indicator) ImageView user_status_indicator;

    @BindView(R.id.activity_user_full_details_user_text_view) TextView user_full_details_user_text_view;
    @BindView(R.id.activity_user_full_details_bio_text_view) TextView user_full_details_bio_text_view;
    @BindView(R.id.activity_user_full_details_distance_text_view) TextView user_full_details_distance_text_view;

    @BindView(R.id.activity_user_full_details_searching_for_text_view) TextView user_full_details_searching_for_text_view;
    @BindView(R.id.activity_user_full_details_languages_text_view) TextView user_full_details_languages_text_view;
    @BindView(R.id.activity_user_full_details_drinking_habit_text_view) TextView user_full_details_drinking_habit_text_view;
    @BindView(R.id.activity_user_full_details_smoking_habit_text_view) TextView user_full_details_smoking_habit_text_view;

    @BindView(R.id.activity_user_full_details_gallery_picture_recycler_view) RecyclerView user_full_details_gallery_picture_recycler_view;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_full_details);


        userModel = (UserModel) getIntent().getSerializableExtra("user");

        mActivity = UserFullDetailsActivity.this;
        ButterKnife.bind(mActivity);

        //FULL DETAILS BACKGROUND IMAGE
        Picasso.get().load(userModel.getCover_picture_url()).placeholder(R.drawable.logo).into(user_full_details_background_img);
        Picasso.get().load(userModel.getPicture_url()).placeholder(R.drawable.logo).into(user_full_details_user_img);

        user_full_details_user_text_view.setText(userModel.getFirst_name()+", "+userModel.getAge());
        user_full_details_bio_text_view.setText(userModel.getBio());
        user_full_details_distance_text_view.setText(userModel.getDistance());

        if(userModel.isOnline()) {
            user_status_indicator.setBackgroundColor(mActivity.getResources().getColor(R.color.colorOnline));
        }else {
            user_status_indicator.setBackgroundColor(mActivity.getResources().getColor(R.color.colorOffline));
        }


        user_full_details_searching_for_text_view.setText("I'm looking for "+userModel.getSearching_for());
        user_full_details_languages_text_view.setText("I speak "+userModel.getLanguageModelListString());
        user_full_details_drinking_habit_text_view.setText("I drink "+userModel.getDrinkingHabit());
        user_full_details_smoking_habit_text_view.setText("I smoke "+userModel.getSmokingHabit());

        GalleyPictureAdapter galleyPictureAdapter = new GalleyPictureAdapter(mActivity, userModel.getGalleryPicturesUrl());
        user_full_details_gallery_picture_recycler_view.setAdapter(galleyPictureAdapter);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        user_full_details_gallery_picture_recycler_view.setLayoutManager(linearLayoutManager);




    }




}
