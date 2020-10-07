package com.example.happy2style.ui.booking.Util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.happy2style.R;
import com.example.happy2style.ui.booking.Model.TimeSlot;


import java.util.ArrayList;
import java.util.List;

public class SlotSelectionSlotAdapter extends RecyclerView.Adapter<SlotSelectionSlotAdapter.SlotSelectionSlotViewHolder> {

    private Context mContext;
    private List<TimeSlot> mTimeSlotList;
    private List<String> mSlotList;

    public SlotSelectionSlotAdapter(Context mContext) {
        this.mContext = mContext;
        this.mTimeSlotList=new ArrayList<>();
    }

    public SlotSelectionSlotAdapter(Context mContext, List<TimeSlot> mTimeSlotList) {
        this.mContext = mContext;
        this.mTimeSlotList = mTimeSlotList;
    }

    public  static class SlotSelectionSlotViewHolder extends RecyclerView.ViewHolder{
        CardView mTimeSlotCard;
        TextView mSlotTime;
        TextView mSlotDescription;

        public SlotSelectionSlotViewHolder(@NonNull View itemView) {
            super(itemView);
            mTimeSlotCard=itemView.findViewById(R.id.time_slot_card);
            mSlotTime=itemView.findViewById(R.id.text_time_slot);
            mSlotDescription=itemView.findViewById(R.id.text_time_slot_desc);

        }
    }

    @NonNull
    @Override
    public SlotSelectionSlotAdapter.SlotSelectionSlotViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.slot_selection_fragment_cardview,parent,false);
        SlotSelectionSlotViewHolder slotSelectionSlotViewHolder=new SlotSelectionSlotViewHolder(view);
        return slotSelectionSlotViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SlotSelectionSlotViewHolder holder, int position) {
        mSlotList=getSlotList();
        holder.mSlotTime.setText(mSlotList.get(position));
        if(mTimeSlotList.size()==0) {    //when no Time Slot got selected
            holder.mSlotDescription.setText("Available");
            holder.mSlotDescription.setTextColor(mContext.getColor(R.color.colorGreen));
            holder.mSlotTime.setTextColor(mContext.getColor(R.color.colorBlack));
            holder.mTimeSlotCard.setCardBackgroundColor(mContext.getColor(R.color.colorWhite));

        }
        else{
            for(TimeSlot slotValue:mTimeSlotList){

            }
        }

    }

    @Override
    public int getItemCount() {
        return 48;
    }

    public  static  List<String> getSlotList(){
        List<String> slot;
        slot=new ArrayList<>();

        for (int i=9;i<21;i++){
            for (int j=0;j<=45; ){
                if(j==0){
                    slot.add(i+":"+j+j+" - "+i+":"+(j=j+15));
                }
                else{
                    slot.add(i+":"+j+" - "+i+":"+(j=j+15));
                }
            }
        }
      return slot;
    }

}
