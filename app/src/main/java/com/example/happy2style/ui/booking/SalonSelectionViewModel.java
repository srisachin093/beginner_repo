package com.example.happy2style.ui.booking;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.happy2style.R;
import com.example.happy2style.ui.Model.Salon;


import java.util.ArrayList;

public class SalonSelectionViewModel extends ViewModel {

    private ArrayList<Salon> mSalonSelectionList;
    private MutableLiveData<ArrayList<Salon>>mLiveSalonSelectionList;

    public SalonSelectionViewModel(){
        mSalonSelectionList=new ArrayList<>();
        mLiveSalonSelectionList=new MutableLiveData<>();
        //dummy data for Hair Salon
        mSalonSelectionList.add(new Salon(R.drawable.ic_account_circle_black_24dp, "Hari Salon1", "ghaziabad", 4));
        mSalonSelectionList.add(new Salon(R.drawable.ic_account_circle_black_24dp, "Hari Salon2", "ghaziabad", 4));
        mSalonSelectionList.add(new Salon(R.drawable.ic_account_circle_black_24dp, "Hari Salon3", "ghaziabad", 4));
        mSalonSelectionList.add(new Salon(R.drawable.ic_account_circle_black_24dp, "Hari Salon4", "ghaziabad", 4));

        mLiveSalonSelectionList.setValue(mSalonSelectionList);

    }
    public LiveData<ArrayList<Salon>> getLiveSalonSelectionList(){
        return mLiveSalonSelectionList;
    }
}
