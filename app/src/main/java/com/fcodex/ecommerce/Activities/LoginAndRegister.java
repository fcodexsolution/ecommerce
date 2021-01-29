package com.fcodex.ecommerce.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.fcodex.ecommerce.R;
import com.fcodex.ecommerce.SharedPreference.Sharedpreference;

public class LoginAndRegister extends AppCompatActivity {

    private ImageView registration_icon;
    private TextView login_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Sharedpreference sharedpreference = new Sharedpreference(this);
        if (sharedpreference.LoadDarkMode()) {

            setTheme(R.style.Theme_AppCompat_NoActionBar);
        } else {
            setTheme(R.style.Theme_AppCompat_DayNight_NoActionBar);
        }
        setContentView(R.layout.activity_login_and_register);
        id();
        onclick();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    private void onclick() {
        registration_icon.setOnClickListener(v -> {
            startActivity(new Intent(LoginAndRegister.this, UserRegistration.class));
            finish();
        });
        login_text.setOnClickListener(v -> {
            startActivity(new Intent(LoginAndRegister.this, UserLogin.class));
            finish();
        });
    }

    private void id() {
        registration_icon = findViewById(R.id.registration_icon);
        login_text = findViewById(R.id.login_text);
    }
}