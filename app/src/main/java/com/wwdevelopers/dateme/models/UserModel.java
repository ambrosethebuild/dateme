package com.wwdevelopers.dateme.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserModel implements Serializable {

    private String id;
    private String first_name;
    private String last_name;
    private String email_address;
    private String phone_number;
    private String bio;
    private String searching_for;
    private String date_of_birth;
    private String picture_url;
    private String cover_picture_url;
    private List<LanguageModel> languageModelList = new ArrayList<>();
    private List<String> galleryPicturesUrl = new ArrayList<>();
    private String drinkingHabit;
    private String smokingHabit;
    private String distance;
    private String age;
    private boolean online;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public List<LanguageModel> getLanguageModelList() {
        return languageModelList;
    }

    public void setLanguageModelList(List<LanguageModel> languageModelList) {
        this.languageModelList = languageModelList;
    }

    public String getDrinkingHabit() {
        return drinkingHabit;
    }

    public void setDrinkingHabit(String drinkingHabit) {
        this.drinkingHabit = drinkingHabit;
    }

    public String getSmokingHabit() {
        return smokingHabit;
    }

    public void setSmokingHabit(String smokingHabit) {
        this.smokingHabit = smokingHabit;
    }

    public String getFullname() {
        return this.first_name+" "+this.last_name;
    }

    public String getAge() {
        return "22";
    }


    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public String getPicture_url() {
        return picture_url;
    }

    public void setPicture_url(String picture_url) {
        this.picture_url = picture_url;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCover_picture_url() {
        return cover_picture_url;
    }

    public void setCover_picture_url(String cover_picture_url) {
        this.cover_picture_url = cover_picture_url;
    }

    public String getSearching_for() {
        return searching_for;
    }

    public void setSearching_for(String searching_for) {
        this.searching_for = searching_for;
    }

    public String getLanguageModelListString() {

        String languages = "";

        for(int i=0; i<this.languageModelList.size(); i++){

            if(i==0){
                languages = languageModelList.get(i).getName();
            }else {
                languages += ", "+languageModelList.get(i).getName();
            }

        }

        return languages;

    }


    public List<String> getGalleryPicturesUrl() {
        return galleryPicturesUrl;
    }

    public void setGalleryPicturesUrl(List<String> galleryPicturesUrl) {
        this.galleryPicturesUrl = galleryPicturesUrl;
    }
}
