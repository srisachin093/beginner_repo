package com.example.happy2style;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;


import com.example.happy2style.ui.booking.SalonSelectionFragment;
import com.example.happy2style.ui.home.HomeFragment;
import com.shuhart.stepview.StepView;

import java.util.ArrayList;
import java.util.List;

public class BookingActivity extends FragmentActivity {

    //widgets
    private StepView mStepView;
    //adapter




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        Intent intent=getIntent();
        String SERVICE_TYPE= intent.getStringExtra(HomeFragment.SERVICE_TYPE);
        String SALON_NAME=intent.getStringExtra(HomeFragment.SALON_NAME);
        String SALON_ADDRESS=intent.getStringExtra(HomeFragment.SALON_ADDRESS);

        mStepView=findViewById(R.id.step_view);
        setupStepView();
        if (findViewById(R.id.booking_fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }


            SalonSelectionFragment salonSelectionFragment = SalonSelectionFragment.newInstance();

            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            //SalonSelectionFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.booking_fragment_container, salonSelectionFragment).commit();
        }






    }


    private void setupStepView(){
        List<String> Steps=new ArrayList<>();
        Steps.add("Select Salon");
        Steps.add("Select Services");
        Steps.add("Select Slot");
        Steps.add("Confirmation");
        mStepView.setSteps(Steps);
    }


}
