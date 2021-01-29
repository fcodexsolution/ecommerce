package com.fcodex.ecommerce.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.fcodex.ecommerce.R;
import com.fcodex.ecommerce.SharedPreference.Sharedpreference;

public class NotificationActivity extends AppCompatActivity {

    private ImageView home_back,actionrightimage;
    private TextView actionbartext;
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
        setContentView(R.layout.activity_notification);
        getSupportActionBar().hide();

        id();
        actionrightimage.setVisibility(View.INVISIBLE);
        actionbartext.setText("Notifications");
        onclick();
    }

    private void onclick() {
        home_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });
    }

    private void id() {

        home_back= findViewById(R.id.homeback);
        actionrightimage=findViewById(R.id.actionBarRightImage);
        actionbartext=findViewById(R.id.acionbarnametitle);
    }
}