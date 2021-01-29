package com.fcodex.ecommerce.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.fcodex.ecommerce.NavFragments.HomeFragment;
import com.fcodex.ecommerce.R;
import com.fcodex.ecommerce.SharedPreference.Sharedpreference;
import com.google.android.material.button.MaterialButton;

public class AddressActivity extends AppCompatActivity {

    private MaterialButton confirm;
    private RadioButton address_one, address_two;
    private ImageView home_back, actionBarRightImage;
    private TextView acionbarnametitle;
    Sharedpreference sharedpreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedpreference = new Sharedpreference(this);
        if (sharedpreference.LoadDarkMode()) {

            setTheme(R.style.Theme_AppCompat);
        } else {
            setTheme(R.style.Theme_AppCompat_DayNight);
        }
        setContentView(R.layout.activity_address);

        setContentView(R.layout.activity_address);

        getSupportActionBar().hide();

        id();
        home_back.setImageResource(R.drawable.ic_close);
        actionBarRightImage.setImageResource(R.drawable.ic_add);
        acionbarnametitle.setText("Shipping Location");
        onclick();
    }

    private void onclick() {

        home_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddressActivity.this, MainActivity.class));
                finish();
            }
        });

        actionBarRightImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddressActivity.this, NewAddressActivity.class));
                finish();
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddressActivity.this, ConfirmCart.class));
                finish();
            }
        });
    }

    private void id() {
        address_one = findViewById(R.id.address_one);
        address_two = findViewById(R.id.address_two);
        confirm = findViewById(R.id.confirm);
        home_back = findViewById(R.id.homeback);
        actionBarRightImage = findViewById(R.id.actionBarRightImage);
        acionbarnametitle = findViewById(R.id.acionbarnametitle);

    }
}