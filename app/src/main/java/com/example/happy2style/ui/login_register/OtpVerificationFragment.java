package com.example.happy2style.ui.login_register;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.happy2style.R;

public class OtpVerificationFragment extends Fragment {

    static OtpVerificationFragment instance;

    //widgets
    private TextView mUserPhoneNo;
    private EditText mOTP;
    private TextView mUserPhoneUpdate;
    private TextView mResendOTP;


    private String mUserPhone;

    public static OtpVerificationFragment newInstance(){
        if(instance==null){
            instance=new OtpVerificationFragment();
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View root=inflater.inflate(R.layout.otpverification_fragment,container,false);
       mUserPhoneNo=root.findViewById(R.id.user_phone);
       mUserPhoneUpdate=root.findViewById(R.id.user_phone_update);
       mOTP=root.findViewById(R.id.user_otp);
       mResendOTP=root.findViewById(R.id.user_resendOTP);
       return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle OtpVerificationAgrs=this.getArguments();
        if(OtpVerificationAgrs!=null){
            mUserPhone=OtpVerificationAgrs.getString(LoginFragment.LOGIN_PNO);
        }


    }
}
