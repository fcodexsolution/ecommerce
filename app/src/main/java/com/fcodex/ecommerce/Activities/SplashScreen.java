package com.fcodex.ecommerce.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.fcodex.ecommerce.SharedPreference.Sharedpreference;
import com.fcodex.ecommerce.R;
import com.google.android.material.button.MaterialButton;

public class SplashScreen extends AppCompatActivity {


    private Sharedpreference sharedpreference;
int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Hide status bar
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        sharedpreference = new Sharedpreference(this);
        if (sharedpreference.LoadDarkMode()) {
            setTheme(R.style.Theme_AppCompat_NoActionBar);

//            //setTheme(R.style.Theme_AppCompat_NoActionBar);
        }
        else {
            setTheme(R.style.Theme_AppCompat_DayNight_NoActionBar);

            //setTheme(R.style.Theme_AppCompat_DayNight_NoActionBar);
        }
        setContentView(R.layout.activity_splash_screen);

        Handler handler = new Handler();
        handler.postDelayed(() -> {
            startActivity(new Intent(SplashScreen.this, LoginAndRegister.class));
            finish();
        },2000);
    }
}