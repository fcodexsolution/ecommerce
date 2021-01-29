package com.fcodex.ecommerce.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fcodex.ecommerce.R;
import com.fcodex.ecommerce.SharedPreference.Sharedpreference;
import com.fcodex.ecommerce.databinding.ActivityCategoriesBinding;

public class CategoriesActivity extends AppCompatActivity {
    ActivityCategoriesBinding binding;
    Sharedpreference sharedpreference;
    private ImageView home_back,actionbarrightimage;
    private CardView category_card;
    private TextView actionbartittle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCategoriesBinding.inflate(getLayoutInflater());
        sharedpreference=new Sharedpreference(this);
        if (sharedpreference.LoadDarkMode()){

            setTheme(R.style.Theme_AppCompat);
        }
        else
        {
            setTheme(R.style.Theme_AppCompat_DayNight);
        }
        setContentView(R.layout.activity_categories);
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        id();
        actionbartittle.setText("Categories Items");
        actionbarrightimage.setVisibility(View.INVISIBLE);
        onclick();
    }

    private void onclick() {
        // for back to home screen
        home_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });
        // for cardview
        category_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CategoriesActivity.this, CartActivity.class));
            }
        });
        //for favourite click
        binding.unFavourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.unFavourite.setVisibility(View.INVISIBLE);
                binding.favourite.setVisibility(View.VISIBLE);
            }
        });
        binding.favourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.favourite.setVisibility(View.INVISIBLE);
                binding.unFavourite.setVisibility(View.VISIBLE);
            }
        });
    }

    private void id() {
        home_back=findViewById(R.id.homeback);
        category_card=findViewById(R.id.category_card);
        actionbarrightimage=findViewById(R.id.actionBarRightImage);
        actionbartittle=findViewById(R.id.acionbarnametitle);
    }
    }