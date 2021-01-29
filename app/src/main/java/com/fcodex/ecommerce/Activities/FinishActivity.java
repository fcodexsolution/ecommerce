package com.fcodex.ecommerce.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.fcodex.ecommerce.NavFragments.HomeFragment;
import com.fcodex.ecommerce.R;
import com.fcodex.ecommerce.SharedPreference.Sharedpreference;
import com.google.android.material.button.MaterialButton;

public class FinishActivity extends AppCompatActivity {

    Sharedpreference sharedpreference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedpreference=new Sharedpreference(this);
        if (sharedpreference.LoadDarkMode()){

            setTheme(R.style.Theme_AppCompat);
        }
        else
        {
            setTheme(R.style.Theme_AppCompat_DayNight);
        }

        setContentView(R.layout.activity_finish);
        getSupportActionBar().hide();
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(FinishActivity.this, MainActivity.class));
                finish();
            }
        },1000);

    }
    }
