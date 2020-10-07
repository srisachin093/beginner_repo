package com.example.happy2style.ui.booking;

import androidx.lifecycle.ViewModelProvider;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.happy2style.R;
import com.example.happy2style.ui.booking.Util.SlotSelectionSlotAdapter;

import java.util.Calendar;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.HorizontalCalendarView;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

public class SlotSelectionFragment extends Fragment {

    private SlotSelectionViewModel mViewModel;
    static  SlotSelectionFragment instance;

    //adapter
    SlotSelectionSlotAdapter mSlotSelectionSlotAdapter;

    //widgets
    private HorizontalCalendarView mCalendarView;
    private RecyclerView mTimeSlots;
    private Button mSlotCancel;
    private Button mSlotConfirm;

    //

    private Context mContext;

    public static SlotSelectionFragment newInstance() {
        if(instance==null)
            instance=new SlotSelectionFragment();
        return instance;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.slot_selection_fragment, container, false);
        //Widgets
        mCalendarView=root.findViewById(R.id.calendar_view);
        mTimeSlots=root.findViewById(R.id.time_slots);
        mSlotCancel=root.findViewById(R.id.btn_slot_cancel);
        mSlotConfirm=root.findViewById(R.id.btn_slot_confirm);
        mContext=container.getContext();
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel =  new ViewModelProvider(this).get(SlotSelectionViewModel.class);

        setupCalendar(view);
         mTimeSlots.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getActivity(),3);
        mTimeSlots.setLayoutManager(gridLayoutManager);
        mSlotSelectionSlotAdapter=new SlotSelectionSlotAdapter(mContext);
        mTimeSlots.setAdapter(mSlotSelectionSlotAdapter);

           }

    private void setupCalendar(View view){
        Calendar start_date=Calendar.getInstance();
        start_date.add(Calendar.DATE,0);
        Calendar end_date=Calendar.getInstance();
        end_date.add(Calendar.DATE,2);

        HorizontalCalendar horizontalCalendar=new HorizontalCalendar.Builder(view,R.id.calendar_view)
                .range(start_date,end_date)
                .datesNumberOnScreen(1)
                .mode(HorizontalCalendar.Mode.DAYS)
                .defaultSelectedDate(start_date)
                .build();

        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {
                Toast.makeText(getContext(), "Selected"+date, Toast.LENGTH_SHORT).show();
            }
        });

    }


}
