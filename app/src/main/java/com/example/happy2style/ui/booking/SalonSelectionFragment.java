package com.example.happy2style.ui.booking;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.happy2style.R;

import com.example.happy2style.ui.Model.Salon;
import com.example.happy2style.ui.booking.Util.SalonSelectionSalonAdapter;

import com.google.android.material.bottomsheet.BottomSheetDialog;




import java.util.ArrayList;

public class SalonSelectionFragment extends Fragment {

    private static final String TAG = "SalonSelectionFragment";

    public static final String SALON_ID="Salon_ID";



    private TextView mPreference1;
    private TextView mPreference2;
    private RecyclerView mSalonSelectionList;

    private SalonSelectionViewModel mViewModel;
    static  SalonSelectionFragment instance;

    private SalonSelectionSalonAdapter mSalonListAdapter;

    private LocalBroadcastManager mLocalBroadCastManager;

    private Context mContext;

    public static SalonSelectionFragment newInstance() {
        if(instance==null)
            instance=new SalonSelectionFragment();
        return instance;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.salon_selection_fragment, container, false);
        mPreference1=root.findViewById(R.id.preference1);
        mPreference2=root.findViewById(R.id.preference2);
        mSalonSelectionList=root.findViewById(R.id.salon_selection_list);
        mContext=getContext();

        mPreference1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final BottomSheetDialog mPreference1BottomSheetDialog=new BottomSheetDialog(getActivity(),R.style.BottomSheetDialogTheme);
                final View mBottomSheetView=LayoutInflater.from(getContext())
                        .inflate(R.layout.preference1bottomsheet,container,false);
                RadioGroup mRadioGroup=mBottomSheetView.findViewById(R.id.prefer1);
                Button mClose1=mBottomSheetView.findViewById(R.id.btn_close1);
                        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(RadioGroup group, int checkedId) {
                                RadioButton mRadioButton = (RadioButton) mBottomSheetView.findViewById(checkedId);
                                mPreference1.setText(mRadioButton.getText());
                                mPreference1BottomSheetDialog.dismiss();
                            }
                        });

                 mClose1.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         mPreference1BottomSheetDialog.dismiss();
                     }
                 });
                mPreference1BottomSheetDialog.setContentView(mBottomSheetView);
                mPreference1BottomSheetDialog.show();
            }
        });


        mPreference2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final BottomSheetDialog mPreference2BottomSheetDialog=new BottomSheetDialog(getActivity(),R.style.BottomSheetDialogTheme);
                final View mBottomSheetView=LayoutInflater.from(getContext())
                        .inflate(R.layout.preference2bottomsheet,container,false);
                RadioGroup mRadioGroup=mBottomSheetView.findViewById(R.id.prefer2);
                Button mClose2=mBottomSheetView.findViewById(R.id.btn_close2);
                mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        RadioButton mRadioButton = (RadioButton) mBottomSheetView.findViewById(checkedId);
                        mPreference2.setText(mRadioButton.getText());
                        mPreference2BottomSheetDialog.dismiss();
                    }
                });
                mClose2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mPreference2BottomSheetDialog.dismiss();
                    }
                });
                mPreference2BottomSheetDialog.setContentView(mBottomSheetView);
                mPreference2BottomSheetDialog.show();
            }
        });




        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(SalonSelectionViewModel.class);
        mViewModel.getLiveSalonSelectionList().observe(getViewLifecycleOwner(), new Observer<ArrayList<Salon>>() {
            @Override
            public void onChanged(final ArrayList<Salon> salons) {
                mSalonListAdapter=new SalonSelectionSalonAdapter(salons);
                LinearLayoutManager manager=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
                mSalonSelectionList.setLayoutManager(manager);
                mSalonSelectionList.setAdapter(mSalonListAdapter);
                mSalonListAdapter.setOnItemCliclListener(new SalonSelectionSalonAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        ServiceSelectionFragment serviceSelectionFragment=ServiceSelectionFragment.newInstance();
                        Bundle args=new Bundle();
                        args.putString(SalonSelectionFragment.SALON_ID,"\n" +
                                "Gorakhpur9596854233");
                        serviceSelectionFragment.setArguments(args);
                        FragmentTransaction transaction= getParentFragmentManager().beginTransaction().replace(R.id.booking_fragment_container,serviceSelectionFragment);
                        transaction.addToBackStack(null);
                        transaction.commit();

                    }
                });

            }
        });
            }


}
