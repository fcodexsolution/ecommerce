package com.fcodex.ecommerce.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fcodex.ecommerce.R;
import com.fcodex.ecommerce.SharedPreference.Sharedpreference;
import com.fcodex.ecommerce.databinding.ActivityFeaturedBinding;

public class FeaturedActivity extends AppCompatActivity {

    ActivityFeaturedBinding binding;
    Sharedpreference sharedpreference;
    private TextView actionbarTittle;
    private ImageView homeback,actionbarImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityFeaturedBinding.inflate(getLayoutInflater());
        sharedpreference=new Sharedpreference(this);
        if (sharedpreference.LoadDarkMode()){

            setTheme(R.style.Theme_AppCompat);
        }
        else
        {
            setTheme(R.style.Theme_AppCompat_DayNight);
        }
        setContentView(R.layout.activity_featured);
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        id();
        actionbarImage.setImageResource(R.drawable.ic_home);
        actionbarTittle.setText("All Items");
        onclick();
    }

    private void onclick() {
        homeback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });

        actionbarImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FeaturedActivity.this, NotificationActivity.class));
                finish();
            }
        });
        binding.allItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FeaturedActivity.this, CartActivity.class));
            }
        });
    }

    private void id() {
        actionbarTittle=findViewById(R.id.acionbarnametitle);
        actionbarImage=findViewById(R.id.actionBarRightImage);
        homeback=findViewById(R.id.homeback);
    }
}