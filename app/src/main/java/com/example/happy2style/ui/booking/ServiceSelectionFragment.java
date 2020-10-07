package com.example.happy2style.ui.booking;

import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.happy2style.MainActivity;
import com.example.happy2style.R;
import com.example.happy2style.ui.booking.Util.ExpandableServiceListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class ServiceSelectionFragment extends Fragment {


    private TextView mtext1;
    private Button mCancel;
    private Button mBook;
    private ExpandableListView mServiceList;

    private ExpandableServiceListAdapter mExpandableServiceListAdapter;

    private ServiceSelectionViewModel mViewModel;
    static ServiceSelectionFragment instance;

    private static final String TAG = "ServiceSelectionFragmen";
    private String salon_ID;
    private List<String> ServiceListHeader;
    private HashMap<String,List<String>> ServiceListItem;


    public static ServiceSelectionFragment newInstance() {
        Log.d(TAG, "newInstance: ofServiceSelectionFragmentCalled");
        if(instance==null)
            instance=new ServiceSelectionFragment();
        return instance;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.service_selection_fragment, container, false);
        mtext1=root.findViewById(R.id.selected_salon_name);
        mServiceList=root.findViewById(R.id.service_list);
        mBook=root.findViewById(R.id.btn_book);
        mCancel=root.findViewById(R.id.btn_cancel1);

        return  root;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //ViewModel
        mViewModel = new ViewModelProvider(this).get(ServiceSelectionViewModel.class);

        Bundle serviceSelectionArgs=this.getArguments();
        if(serviceSelectionArgs!=null){
            salon_ID=serviceSelectionArgs.getString(SalonSelectionFragment.SALON_ID);
        }
        mtext1.setText(salon_ID);





        mViewModel.getLiveServiceListItem().observe(getViewLifecycleOwner(), new Observer<HashMap<String, List<String>>>() {
            @Override
            public void onChanged(HashMap<String, List<String>> stringListHashMap) {
                ServiceListHeader=new ArrayList<>(stringListHashMap.keySet());
                ServiceListItem=stringListHashMap;

                mExpandableServiceListAdapter = new ExpandableServiceListAdapter(getContext(),ServiceListHeader , ServiceListItem);
                mServiceList.setAdapter(mExpandableServiceListAdapter);
            }
        });








        onClickBook();
        onClickCancel();

    }

    private void onClickBook(){
        mBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SlotSelectionFragment slotSelectionFragment=SlotSelectionFragment.newInstance();
                FragmentTransaction transaction=getParentFragmentManager().beginTransaction().replace(R.id.booking_fragment_container,slotSelectionFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }

    private void onClickCancel(){
        mCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext(),R.style.AlertDialogTheme);
                builder.setTitle("Cancel Booking");
                builder.setMessage("Do you want cancel booking");
                builder.setCancelable(true);

                builder.setPositiveButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                Intent intent=new Intent(getContext(), MainActivity.class);  //prone to error
                                startActivity(intent);

                            }
                        });

                builder.setNegativeButton(
                        "No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert = builder.create();
                alert.show();

            }
        });

    }

}
