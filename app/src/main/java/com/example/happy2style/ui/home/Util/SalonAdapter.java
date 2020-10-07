package com.example.happy2style.ui.home.Util;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.happy2style.R;
import com.example.happy2style.ui.Model.Salon;

import java.util.ArrayList;

public class SalonAdapter extends RecyclerView.Adapter<SalonAdapter.SalonViewHolder> {
    private static final String TAG = "SalonAdapter";
    private ArrayList<Salon> mSalonList;
    private OnItemClickListener mOnItemClickListener;



    public interface OnItemClickListener{
        void onItemClick(int position);

    }
    public void setOnItemCliclListener(OnItemClickListener mListner){
        mOnItemClickListener=mListner;
    }


    public static class SalonViewHolder extends RecyclerView.ViewHolder {



        public ImageView mSalon_Img;
        public TextView  mSalon_Name;
        public TextView  mSalon_Address;
        public TextView  mSalon_Rating;


        public SalonViewHolder(@NonNull View itemView, final OnItemClickListener mListner) {
            super(itemView);

            mSalon_Img=itemView.findViewById(R.id.salon_img);
            mSalon_Name=itemView.findViewById(R.id.salon_name);
            mSalon_Address=itemView.findViewById(R.id.salon_address);
            mSalon_Rating=itemView.findViewById(R.id.salon_rating);

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

    public SalonAdapter(ArrayList<Salon> msalonList) {
        this.mSalonList = msalonList;
    }

    @NonNull
    @Override
    public SalonAdapter.SalonViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.top_rated_h,parent,false);
        final SalonViewHolder salonViewHolder=new SalonViewHolder(view,mOnItemClickListener);

        return salonViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SalonAdapter.SalonViewHolder holder, int position) {
        Salon currentSalon=mSalonList.get(position);
        holder.mSalon_Img.setImageResource(currentSalon.getSalon_img_url());
        holder.mSalon_Name.setText(currentSalon.getSalon_name());
        holder.mSalon_Address.setText((currentSalon.getSalon_address()));
        holder.mSalon_Rating.setText(Integer.toString(currentSalon.getRating()));
    }

    @Override
    public int getItemCount() {
        return mSalonList.size();
    }




}
