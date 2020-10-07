package com.example.happy2style.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.happy2style.BookingActivity;
import com.example.happy2style.R;
import com.example.happy2style.ui.Model.Salon;
import com.example.happy2style.ui.home.Util.SalonAdapter;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private static final String TAG = "HomeFragment";
    public static final String SERVICE_TYPE="com.example.happy2style.ui.home.SERVICE_TYPE";
    public static  final String SALON_NAME="com.example.happy2style.ui.home.SALON_NAME";
    public static  final String SALON_ADDRESS="com.example.happy2style.ui.home.SALON_ADDRESS";




    private HomeViewModel homeViewModel;

    //Top Rated Recyclerview
    private RecyclerView mRecyclerview1;
    private RecyclerView mRecyclerview2;
    private RecyclerView mRecyclerview3;


    //CardView
    private CardView mBeautySalonCard;
    private CardView mHairSalonCard;
    private CardView mSpaCard;
    private CardView mBarberShopCard;
    private CardView mMassageCard;
    private CardView mTherapyCenterCard;
    private CardView mNailSalon;


    //context
    private Context mContext;
    //adapter
    private SalonAdapter mSalonAdapter;




    public View onCreateView(@NonNull final LayoutInflater inflater,
                             final ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        //RecyclerView
        mRecyclerview1 = root.findViewById(R.id.top_hairsalon);
        mRecyclerview2 = root.findViewById(R.id.top_beautysalon);
        mRecyclerview3 = root.findViewById(R.id.top_spa);



        //CardViews
        mBeautySalonCard=root.findViewById(R.id.beauty_salon);
        mHairSalonCard=root.findViewById(R.id.hair_salon);
        mSpaCard=root.findViewById(R.id.spa);
        mBarberShopCard=root.findViewById(R.id.barbershop);
        mMassageCard=root.findViewById(R.id.massage);
        mTherapyCenterCard=root.findViewById(R.id.therapy_center);
        mNailSalon=root.findViewById(R.id.nail_salon);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Context
        mContext=getContext();

        //ViewModel
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);


        //OnClickListener on CardViews
        mBeautySalonCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext, BookingActivity.class);
                intent.putExtra(SERVICE_TYPE,getString(R.string.beauty_salon));
                startActivity(intent);
            }
        });

        mHairSalonCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext, BookingActivity.class);
                intent.putExtra(SERVICE_TYPE,getString(R.string.hair_salon));
                startActivity(intent);
            }
        });

        mSpaCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext, BookingActivity.class);
                intent.putExtra(SERVICE_TYPE,getString(R.string.spa));
                startActivity(intent);
            }
        });

        mBarberShopCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext, BookingActivity.class);
                intent.putExtra(SERVICE_TYPE,getString(R.string.barbershop));
                startActivity(intent);
            }
        });

        mMassageCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext, BookingActivity.class);
                intent.putExtra(SERVICE_TYPE,getString(R.string.massage));
                startActivity(intent);
            }
        });

        mTherapyCenterCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext, BookingActivity.class);
                intent.putExtra(SERVICE_TYPE,getString(R.string.therapy_center));
                startActivity(intent);
            }
        });

        mNailSalon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext, BookingActivity.class);
                intent.putExtra(SERVICE_TYPE,getString(R.string.nail_salon));
                startActivity(intent);
            }
        });




        homeViewModel.getLiveHairSalon().observe(getViewLifecycleOwner(), new Observer<ArrayList<Salon>>() {
            @Override
            public void onChanged(final ArrayList<Salon> salons) {

                mSalonAdapter=new SalonAdapter(salons);
                LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
                mRecyclerview1.setLayoutManager(manager);

                mRecyclerview1.setAdapter(mSalonAdapter);
                mSalonAdapter.setOnItemCliclListener(new SalonAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        Intent intent=new Intent(mContext,BookingActivity.class);
                        intent.putExtra(SALON_NAME,salons.get(position).getSalon_name());
                        intent.putExtra(SALON_ADDRESS,salons.get(position).getSalon_address());
                        startActivity(intent);
                    }
                });

            }
        });

        homeViewModel.getLiveBeautySalon().observe(getViewLifecycleOwner(), new Observer<ArrayList<Salon>>() {
            @Override
            public void onChanged(final ArrayList<Salon> salons) {


                mSalonAdapter=new SalonAdapter(salons);
                LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
                mRecyclerview2.setLayoutManager(manager);

                mRecyclerview2.setAdapter(mSalonAdapter);
                mSalonAdapter.setOnItemCliclListener(new SalonAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        Intent intent=new Intent(mContext,BookingActivity.class);
                        intent.putExtra(SALON_NAME,salons.get(position).getSalon_name());
                        intent.putExtra(SALON_ADDRESS,salons.get(position).getSalon_address());
                        startActivity(intent);
                    }
                });

            }
        });

        homeViewModel.getLiveSpa().observe(getViewLifecycleOwner(), new Observer<ArrayList<Salon>>() {
            @Override
            public void onChanged(final ArrayList<Salon> salons) {

                mSalonAdapter=new SalonAdapter(salons);
                LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
                mRecyclerview3.setLayoutManager(manager);

                mRecyclerview3.setAdapter(mSalonAdapter);
                mSalonAdapter.setOnItemCliclListener(new SalonAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        Intent intent=new Intent(mContext,BookingActivity.class);
                        intent.putExtra(SALON_NAME,salons.get(position).getSalon_name());
                        intent.putExtra(SALON_ADDRESS,salons.get(position).getSalon_address());
                        startActivity(intent);
                    }
                });

            }
        });

    }
}
