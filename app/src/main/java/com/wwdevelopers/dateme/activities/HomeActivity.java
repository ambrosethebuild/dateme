package com.wwdevelopers.dateme.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

import com.wwdevelopers.dateme.R;
import com.wwdevelopers.dateme.adapters.UsersAdapter;
import com.wwdevelopers.dateme.interfaces.RecyclerClickListener;
import com.wwdevelopers.dateme.models.LanguageModel;
import com.wwdevelopers.dateme.models.UserModel;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.Duration;
import com.yuyakaido.android.cardstackview.StackFrom;
import com.yuyakaido.android.cardstackview.SwipeAnimationSetting;
import com.yuyakaido.android.cardstackview.SwipeableMethod;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity implements CardStackListener {


    Activity mActivity;
    @BindView(R.id.card_stack_view) CardStackView users_card_stack_view;
    private CardStackLayoutManager manager;

    UsersAdapter usersAdapter;
    List<UserModel> userModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        mActivity = HomeActivity.this;
        ButterKnife.bind(mActivity);

        setupCardStackView();

    }

    @Override
    public void onBackPressed() {
        finishAffinity();
        super.onBackPressed();
    }





    public void setupCardStackView(){


        userModels = getUsers();

        usersAdapter = new UsersAdapter(mActivity,userModels,userClickListener);

        manager = new CardStackLayoutManager(mActivity,this);
        manager.setStackFrom(StackFrom.Bottom);
        manager.setVisibleCount(4);
        manager.setTranslationInterval(8.0f);
        manager.setScaleInterval(0.95f);
        manager.setSwipeThreshold(0.3f);
        manager.setMaxDegree(20.0f);
        manager.setDirections(Direction.HORIZONTAL);
        manager.setCanScrollHorizontal(true);
        manager.setCanScrollVertical(true);
        manager.setSwipeableMethod(SwipeableMethod.AutomaticAndManual);
        manager.setOverlayInterpolator(new LinearInterpolator());


        users_card_stack_view.setLayoutManager(manager);
        users_card_stack_view.setAdapter(usersAdapter);




    }

    private RecyclerClickListener userClickListener = new RecyclerClickListener() {
        @Override
        public void onItemClick(View v, int position) {

            Intent intent = new Intent(mActivity,UserFullDetailsActivity.class);
            intent.putExtra("user",userModels.get(position));
            startActivity(intent);

        }
    };

    private List<UserModel> getUsers() {


        //Languages
        List<LanguageModel> langauges = new ArrayList<>();
        LanguageModel languageModel = new LanguageModel();
        languageModel.setName("English");
        langauges.add(languageModel);

        languageModel = new LanguageModel();
        languageModel.setName("Spanish");
        langauges.add(languageModel);

        //Pictures
        List<String> profileGallery = new ArrayList<>();
        profileGallery.add("https://images.pexels.com/photos/247878/pexels-photo-247878.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500");
        profileGallery.add("https://images.unsplash.com/photo-1513207565459-d7f36bfa1222?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80");
        profileGallery.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR9sILVyHDvTygSBON_VnvQnmWhQ--S-aqFEwHUyTyrZohm3r8LHw");
        profileGallery.add("https://images.pexels.com/photos/638700/pexels-photo-638700.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500");
        profileGallery.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSAr2dlRI_nP_cbe2c7tC4d5Vn4UMj-JlyX0Z7BIkGdVozAKXqaqA");


        List<UserModel> userModels = new ArrayList<>();

        for(int i=0; i<5; i++) {

            UserModel userModel = new UserModel();
            userModel.setBio("I would love you meet you.");
            userModel.setSearching_for("Hookup");
            userModel.setFirst_name("Jenny");
            userModel.setLast_name("Mary");
            userModel.setDate_of_birth("1999-01-20");
            userModel.setAge("20");
            userModel.setPicture_url("https://images.unsplash.com/photo-1529626455594-4ff0802cfb7e?ixlib=rb-1.2.1&auto=format&fit=crop&w=1000&q=80");
            userModel.setCover_picture_url("https://cdn.pixabay.com/photo/2016/01/19/18/00/city-1150026_960_720.jpg");
            userModel.setOnline(true);
            userModel.setDistance("20km");
            userModel.setDrinkingHabit("Socially");
            userModel.setSmokingHabit("Once In A While");
            userModel.setLanguageModelList(langauges);
            userModel.setGalleryPicturesUrl(profileGallery);
            userModels.add(userModel);


            userModel = new UserModel();
            userModel.setBio("I would love you meet you.");
            userModel.setSearching_for("Relationship");
            userModel.setFirst_name("Jenny");
            userModel.setLast_name("Mary");
            userModel.setDate_of_birth("1999-01-20");
            userModel.setAge("20");
            userModel.setPicture_url("https://static.boredpanda.com/blog/wp-content/uploads/2018/07/worlds-most-beautiful-nigerian-girl-jare-but-mofe-fb__700-png.jpg");
            userModel.setCover_picture_url("https://cdn.pixabay.com/photo/2016/01/19/18/00/city-1150026_960_720.jpg");
            userModel.setOnline(true);
            userModel.setDistance("20km");
            userModel.setDrinkingHabit("None");
            userModel.setSmokingHabit("Never");
            userModel.setLanguageModelList(langauges);
            userModel.setGalleryPicturesUrl(profileGallery);
            userModels.add(userModel);


            userModel = new UserModel();
            userModel.setBio("I would love you meet you.");
            userModel.setSearching_for("Relationship");
            userModel.setFirst_name("Jenny");
            userModel.setLast_name("Mary");
            userModel.setDate_of_birth("1997-01-20");
            userModel.setAge("22");
            userModel.setPicture_url("https://images.pexels.com/photos/160699/girl-dandelion-yellow-flowers-160699.jpeg?cs=srgb&dl=beautiful-beauty-dandelion-160699.jpg&fm=jpg");
            userModel.setCover_picture_url("https://cdn.pixabay.com/photo/2016/01/19/18/00/city-1150026_960_720.jpg");
            userModel.setOnline(false);
            userModel.setDistance("20km");
            userModel.setDrinkingHabit("Once In A While");
            userModel.setSmokingHabit("Socially");
            userModel.setLanguageModelList(langauges);
            userModel.setGalleryPicturesUrl(profileGallery);
            userModels.add(userModel);

        }

        return userModels;

    }








    @OnClick(R.id.activity_home_skip_user_fab)
    public void skipUser(){

        SwipeAnimationSetting setting = new SwipeAnimationSetting.Builder()
                .setDirection(Direction.Left)
                .setDuration(Duration.Normal.duration)
                .setInterpolator(new AccelerateInterpolator())
                .build();
        manager.setSwipeAnimationSetting(setting);
        users_card_stack_view.swipe();

        //YOU CAN DO WHATEVER YOU LIKE AFTER USER DISLIKE THE CURRENT VIEWED USER

    }

    @OnClick(R.id.activity_home_super_love_user_fab)
    public void superLoveUser(){

        SwipeAnimationSetting setting = new SwipeAnimationSetting.Builder()
                .setDirection(Direction.Top)
                .setDuration(Duration.Slow.duration)
                .setInterpolator(new AccelerateInterpolator())
                .build();
        manager.setSwipeAnimationSetting(setting);
        users_card_stack_view.swipe();


        //YOU CAN DO WHATEVER YOU LIKE AFTER USER SUPER LOVE THE CURRENT VIEWED USER

    }

    @OnClick(R.id.activity_home_love_user_fab)
    public void loveUser(){

        SwipeAnimationSetting setting = new SwipeAnimationSetting.Builder()
                .setDirection(Direction.Right)
                .setDuration(Duration.Normal.duration)
                .setInterpolator(new AccelerateInterpolator())
                .build();
        manager.setSwipeAnimationSetting(setting);
        users_card_stack_view.swipe();


        //YOU CAN DO WHATEVER YOU LIKE AFTER USER LOVE THE CURRENT VIEWED USER

    }



    // START OF LISTENER FOR CARD STACK SWIPE

    @Override
    public void onCardDragging(Direction direction, float ratio) {

    }

    @Override
    public void onCardSwiped(Direction direction) {


        Log.d("CardStackView", "onCardSwiped: p = ${manager.topPosition}, d = $direction");
//        if (manager.topPosition == adapter.itemCount - 5) {
//            //paginate();
//        }


    }

    @Override
    public void onCardRewound() {

    }

    @Override
    public void onCardCanceled() {

    }

    @Override
    public void onCardAppeared(View view, int position) {

    }

    @Override
    public void onCardDisappeared(View view, int position) {

    }



    // END OF LISTENER FOR CARD STACK SWIPE


}
