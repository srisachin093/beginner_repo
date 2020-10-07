package com.example.happy2style.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.happy2style.R;
import com.example.happy2style.ui.Model.Salon;


import java.util.ArrayList;

public class HomeViewModel extends ViewModel {

    private ArrayList<Salon> mHairSalonList;
    private ArrayList<Salon> mBeautySalonList;
    private ArrayList<Salon> mSpaList;

    private MutableLiveData<ArrayList<Salon>> mLiveHairSalon;
    private MutableLiveData<ArrayList<Salon>> mLiveBeautySalon;
    private MutableLiveData<ArrayList<Salon>> mLiveSpa;


    public HomeViewModel() {
        mHairSalonList = new ArrayList<>();
        mBeautySalonList = new ArrayList<>();
        mSpaList = new ArrayList<>();

        mLiveHairSalon = new MutableLiveData<>();
        mLiveBeautySalon = new MutableLiveData<>();
        mLiveSpa = new MutableLiveData<>();


        //dummy data for Hair Salon
        mHairSalonList.add(new Salon(R.drawable.ic_launcher_background, "Hari Salon1", "ghaziabad", 4));
        mHairSalonList.add(new Salon(R.drawable.ic_launcher_background, "Hari Salon2", "ghaziabad", 4));
        mHairSalonList.add(new Salon(R.drawable.ic_launcher_background, "Hari Salon3", "ghaziabad", 4));
        mHairSalonList.add(new Salon(R.drawable.ic_launcher_background, "Hari Salon4", "ghaziabad", 4));
        //dummy data for Hair Salon
        mBeautySalonList.add(new Salon(R.drawable.ic_launcher_background, "Vivek Salon", "ghaziabad", 4));
        mBeautySalonList.add(new Salon(R.drawable.ic_launcher_background, "Vivek Salon2", "ghaziabad", 4));
        mBeautySalonList.add(new Salon(R.drawable.ic_launcher_background, "Vivek Salon3", "ghaziabad", 4));
        mBeautySalonList.add(new Salon(R.drawable.ic_launcher_background, "Vivek salon4", "ghaziabad", 4));
        //dummy data for Spa
        mSpaList.add(new Salon(R.drawable.ic_launcher_background, "Sumit Spa1", "ghaziabad", 4));
        mSpaList.add(new Salon(R.drawable.ic_launcher_background, "Sumit Spa2", "ghaziabad", 4));
        mSpaList.add(new Salon(R.drawable.ic_launcher_background, "Sumit Spa3", "ghaziabad", 4));
        mSpaList.add(new Salon(R.drawable.ic_launcher_background, "Sumit Spa4", "ghaziabad", 4));

        //Setting Mutable Live data
        mLiveHairSalon.setValue(mHairSalonList);
        mLiveBeautySalon.setValue(mBeautySalonList);
        mLiveSpa.setValue(mSpaList);
    }


    public  LiveData<ArrayList<Salon>> getLiveHairSalon() {
        return mLiveHairSalon;
    }

    public LiveData<ArrayList<Salon>> getLiveBeautySalon() {
        return mLiveBeautySalon;
    }

    public LiveData<ArrayList<Salon>> getLiveSpa() {
        return mLiveSpa;
    }
}