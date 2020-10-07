package com.example.happy2style.ui.booking;

import android.content.IntentFilter;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class ServiceSelectionViewModel extends ViewModel {
    private static final String TAG = "ServiceSelectionViewMod";
    private List<String> ServiceListHeader;
    private HashMap<String,List<String>> ServiceListItem;
    private MutableLiveData<List<String>> mLiveServiceListHeader;
    private MutableLiveData<HashMap<String,List<String>>> mLiveServiceListItem;

    public ServiceSelectionViewModel(){
        Log.d(TAG, "ServiceSelectionViewModel:Viewmodel innitialized ");
        ServiceListHeader=new ArrayList<>();
        ServiceListItem=new HashMap<>();
        mLiveServiceListHeader=new MutableLiveData<>();
        mLiveServiceListItem=new MutableLiveData<>();

        //Dummy Data creation
       ServiceListHeader.add("Beauty Services");
       ServiceListHeader.add("Hair Services");
       ServiceListHeader.add("Spa");
       ServiceListHeader.add("Barber Services");
       ServiceListHeader.add("Massage");
       ServiceListHeader.add("Therapy");
       ServiceListHeader.add("Nail Services");

       for(String ServiceHeader : ServiceListHeader){

           List<String> x=new ArrayList<>();
           for (int i=0;i<4;++i){
               x.add("Service"+i);
           }
           ServiceListItem.put(ServiceHeader,x);

       }

        //Setting Mutable Live data
        mLiveServiceListHeader.setValue(ServiceListHeader);
       mLiveServiceListItem.setValue(ServiceListItem);
    }
    public LiveData<List<String>> getLiveServiceListHeader(){
        return mLiveServiceListHeader;
    }
    public  LiveData<HashMap<String,List<String>>> getLiveServiceListItem(){
        return mLiveServiceListItem;
    }
}
