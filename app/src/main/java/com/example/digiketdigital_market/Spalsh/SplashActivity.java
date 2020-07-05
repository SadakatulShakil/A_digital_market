package com.example.digiketdigital_market.Spalsh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.example.digiketdigital_market.Home.HomeActivity;
import com.example.digiketdigital_market.Login.SignInActivity;
import com.example.digiketdigital_market.R;
import com.example.digiketdigital_market.Util.SharePreferenceUtil;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
            init();
    }

    public void init(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //if registered than
                //Go to home else
                //show login screen
                //key registered_user
                if(SharePreferenceUtil.getInstance().getString("registered_user").equalsIgnoreCase("")){
                    //login page
                    Intent intent = new Intent(SplashActivity.this, SignInActivity.class);
                    startActivity(intent);
                }else{
                    //Go to Home page
                    Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                    startActivity(intent);
                }
                finish();

            }
        }, 4000);
    }
}
