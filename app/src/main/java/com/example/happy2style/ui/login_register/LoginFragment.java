package com.example.happy2style.ui.login_register;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.happy2style.R;
import com.google.firebase.auth.FirebaseAuth;


public class LoginFragment extends Fragment {
    private static final String TAG = "LoginFragment";
    public static final String LOGIN_PNO="LoginPhoneNumber";

    //widgets
    private TextView mLoginCountryCode;
    private EditText mLoginPhoneNumber;
    private Button mLoginGetOtp;
    private TextView mRegister;

    private String mNumber;
    private String mCountryCode;
    private String mPhoneNumber;


    static LoginFragment instance;

    public static LoginFragment newInstance(){
        if(instance==null){
            instance=new LoginFragment();
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View root=inflater.inflate(R.layout.login_fragment,container,false);
      mLoginCountryCode=root.findViewById(R.id.login_country_code);
      mLoginPhoneNumber=root.findViewById(R.id.login_phone_number);
      mRegister=root.findViewById(R.id.register);
      mLoginGetOtp=root.findViewById(R.id.btn_get_otp);
      return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mLoginGetOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            mNumber=mLoginPhoneNumber.getText().toString().trim();
            mCountryCode=mLoginCountryCode.getText().toString().trim();
            if(mNumber.isEmpty()||mNumber.length()<10){
                mLoginPhoneNumber.setError("Enter Correct Number");
                mLoginPhoneNumber.requestFocus();
                return;
            }
            mPhoneNumber=mCountryCode+mNumber;
            OtpVerificationFragment otpVerificationFragment=OtpVerificationFragment.newInstance();
            Bundle args=new Bundle();
            args.putString(LOGIN_PNO,mPhoneNumber);
            otpVerificationFragment.setArguments(args);
                FragmentTransaction transaction=getParentFragmentManager().beginTransaction().replace(R.id.login_fragment_container,otpVerificationFragment);
                transaction.commit();

            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        if(FirebaseAuth.getInstance().getCurrentUser()!=null){
            Toast.makeText(getContext(), "abc", Toast.LENGTH_SHORT).show();
        }
    }
}
