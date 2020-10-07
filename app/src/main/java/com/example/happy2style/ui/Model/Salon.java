package com.example.happy2style.ui.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Salon {
    private int salon_img_url;
    private String salon_name;
    private String salon_address;
    private int rating;

    public Salon(int salon_img_url, String salon_name, String salon_address, int rating) {
        this.salon_img_url = salon_img_url;
        this.salon_name = salon_name;
        this.salon_address = salon_address;
        this.rating = rating;
    }

    public int getSalon_img_url() {
        return salon_img_url;
    }

    public void setSalon_img_url(int salon_img_url) {
        this.salon_img_url = salon_img_url;
    }

    public String getSalon_name() {
        return salon_name;
    }

    public void setSalon_name(String salon_name) {
        this.salon_name = salon_name;
    }

    public String getSalon_address() {
        return salon_address;
    }

    public void setSalon_address(String salon_address) {
        this.salon_address = salon_address;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

}