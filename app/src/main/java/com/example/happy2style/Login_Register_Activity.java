package com.example.happy2style;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.example.happy2style.ui.login_register.LoginFragment;

public class Login_Register_Activity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);



        if(findViewById(R.id.login_fragment_container)!=null) {
            if (savedInstanceState != null) {
                return;
            }

            LoginFragment loginFragment=LoginFragment.newInstance();
            getSupportFragmentManager().beginTransaction().add(R.id.login_fragment_container,loginFragment).commit();
        }
    }
}