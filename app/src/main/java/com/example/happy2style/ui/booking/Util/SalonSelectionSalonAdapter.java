package com.example.happy2style.ui.booking.Util;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.happy2style.R;
import com.example.happy2style.ui.Model.Salon;


import java.util.ArrayList;

public class SalonSelectionSalonAdapter extends RecyclerView.Adapter<SalonSelectionSalonAdapter.SalonSelectionSalonViewHolder> {

    private static final String TAG = "SalonSelectionSalonAdapter";
    private ArrayList<Salon> mSalonList;

    private SalonSelectionSalonAdapter.OnItemClickListener mOnItemClickListener;





    public interface OnItemClickListener{
        void onItemClick(int position);

    }
    public void setOnItemCliclListener(SalonSelectionSalonAdapter.OnItemClickListener mListner){
        mOnItemClickListener=mListner;
    }


    public static class SalonSelectionSalonViewHolder extends RecyclerView.ViewHolder{
        public ImageView mSS_SalonImg; // SS: SalonSelection
        public TextView mSS_SalonName;
        public TextView mSS_SalonAddress;
        public TextView mSS_SalonRating;


        public SalonSelectionSalonViewHolder(@NonNull View itemView,final OnItemClickListener mListner) {
            super(itemView);
            mSS_SalonImg=itemView.findViewById(R.id.ss_salon_img);
            mSS_SalonName=itemView.findViewById(R.id.ss_salon_name);
            mSS_SalonAddress=itemView.findViewById(R.id.ss_salon_address);
            mSS_SalonRating=itemView.findViewById(R.id.ss_salon_rating);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mListner !=null){
                        int position=getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            mListner.onItemClick(position);


                        }
                    }
                }
            });

        }
    }

    public SalonSelectionSalonAdapter(ArrayList<Salon> mSalonList) {
        this.mSalonList = mSalonList;
    }

    @NonNull
    @Override
    public SalonSelectionSalonAdapter.SalonSelectionSalonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.salon_selection_fragment_cardview,parent,false);
        final SalonSelectionSalonViewHolder salonSelectionSalonViewHolder=new SalonSelectionSalonViewHolder(view,mOnItemClickListener);
        return salonSelectionSalonViewHolder ;
    }

    @Override
    public void onBindViewHolder(@NonNull SalonSelectionSalonAdapter.SalonSelectionSalonViewHolder holder, int position) {
        Salon currentSalon=mSalonList.get(position);
        holder.mSS_SalonImg.setImageResource(currentSalon.getSalon_img_url());
        holder.mSS_SalonName.setText(currentSalon.getSalon_name());
        holder.mSS_SalonAddress.setText((currentSalon.getSalon_address()));

        holder.mSS_SalonRating.setText(Integer.toString(currentSalon.getRating()));

    }

    @Override
    public int getItemCount() {
        return mSalonList.size();
    }
}
