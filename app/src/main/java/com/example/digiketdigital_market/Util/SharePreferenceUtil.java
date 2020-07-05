package com.example.digiketdigital_market.Util;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.digiketdigital_market.MyApp;

import java.util.Calendar;

public class SharePreferenceUtil {

    private static String PREFERENCE_NAME = "digiket";
    private static SharePreferenceUtil sharePreferenceUtil;
    private SharedPreferences sharedPreferences;

    private SharePreferenceUtil(Context context){
        PREFERENCE_NAME = PREFERENCE_NAME + context.getPackageName();
        this.sharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    public static SharePreferenceUtil getInstance(){
        if(sharePreferenceUtil == null){
        sharePreferenceUtil = new SharePreferenceUtil(MyApp.getContext());
    }
        return sharePreferenceUtil;
    }

    //login response userid 1234
    public void saveString(String key, String value){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public String getString(String key, String defaultValue){
        return sharedPreferences.getString(key, defaultValue);
    }
    public String getString(String key){
        return sharedPreferences.getString(key, "");
    }

}


