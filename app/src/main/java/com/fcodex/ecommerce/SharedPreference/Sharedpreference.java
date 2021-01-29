package com.fcodex.ecommerce.SharedPreference;

import android.content.Context;
import android.content.SharedPreferences;

public class Sharedpreference {

    public SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;

    public Sharedpreference(Context context){
        sharedPreferences= context.getSharedPreferences("Theme", Context.MODE_PRIVATE);
    }

    // Dark Theme
    public void SetDarkMode(Boolean state){
        editor=sharedPreferences.edit();
        editor.putBoolean("DarkTheme", state);
        editor.apply();
    }

    public boolean LoadDarkMode(){
        return sharedPreferences.getBoolean("DarkTheme", false);
    }
    // End Dark Theme

}
