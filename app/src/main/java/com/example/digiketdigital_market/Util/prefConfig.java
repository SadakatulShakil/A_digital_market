package com.example.digiketdigital_market.Util;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.digiketdigital_market.MyApp;
import com.example.digiketdigital_market.R;

public class prefConfig {

  private SharedPreferences sharedPreferences;
  private Context context;

    public prefConfig(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(context.getString(R.string.pref_file), Context.MODE_PRIVATE);
    }

    public void writeLoginStatus(boolean status){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(context.getString(R.string.pref_login_status),status);
        editor.commit();
    }

    public boolean readLoginStatus(){

        return sharedPreferences.getBoolean(context.getString(R.string.pref_login_status),false);
    }
}


