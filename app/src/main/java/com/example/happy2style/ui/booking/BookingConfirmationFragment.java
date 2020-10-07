package com.example.happy2style.ui.booking;

import androidx.lifecycle.ViewModelProvider;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.happy2style.R;

public class BookingConfirmationFragment extends Fragment {

    private BookingConfirmationViewModel mViewModel;

    static  BookingConfirmationFragment instance;

    public static BookingConfirmationFragment newInstance() {
        if(instance==null)
            instance=new BookingConfirmationFragment();
        return instance;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.booking_confirmation_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel =  new ViewModelProvider(this).get(BookingConfirmationViewModel.class);
        // TODO: Use the ViewModel
    }

}
