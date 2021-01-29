package com.fcodex.ecommerce.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.fcodex.ecommerce.R;
import com.fcodex.ecommerce.SharedPreference.Sharedpreference;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class UserRegistration extends AppCompatActivity {

    private MaterialButton registeration_button;
    private TextInputEditText firstname,lastname,registration_email,registration_password,confirm_password;

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
        setContentView(R.layout.activity_user_registration);
        getSupportActionBar().hide();

        id();
        onclick();
    }

    private void onclick() {
        registeration_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    startActivity(new Intent(UserRegistration.this, UserLogin.class));
                  finish();
            }
        });
    }

    private void id() {

        registeration_button=findViewById(R.id.registeration_button);
    }
    }
