package com.fcodex.ecommerce.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.fcodex.ecommerce.NavFragments.HomeFragment;
import com.fcodex.ecommerce.R;
import com.fcodex.ecommerce.SharedPreference.Sharedpreference;
import com.google.android.material.button.MaterialButton;

public class FailedActivity extends AppCompatActivity {

    private MaterialButton finish;

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
        setContentView(R.layout.activity_failed);

        getSupportActionBar().hide();

        id();
        onclick();
    }

    private void onclick() {

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FailedActivity.this, MainActivity.class));
                finish();
            }
        });
    }

    private void id() {
        finish=findViewById(R.id.finish);
    }
    }
