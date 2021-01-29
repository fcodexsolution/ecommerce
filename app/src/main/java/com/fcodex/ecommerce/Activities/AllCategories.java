package com.fcodex.ecommerce.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fcodex.ecommerce.R;
import com.fcodex.ecommerce.databinding.ActivityAllCategoriesBinding;

public class AllCategories extends AppCompatActivity {
    ActivityAllCategoriesBinding binding;
    private ImageView homeback,actionBarRightImage;
    private TextView acionbarnametitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAllCategoriesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        id();
        oncategoryclick();

        acionbarnametitle.setText("Categories");
        actionBarRightImage.setImageResource(R.drawable.ic_baseline_notifications_none_24);
    }


    private void oncategoryclick() {
        binding.manCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AllCategories.this, CategoriesActivity.class));
                finish();
            }
        });
        binding.womenCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AllCategories.this, CategoriesActivity.class));
                finish();
            }
        });
        binding.kidsCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AllCategories.this, CategoriesActivity.class));
                finish();
            }
        });
        binding.bridalCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AllCategories.this, CategoriesActivity.class));
                finish();
            }
        });
        actionBarRightImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AllCategories.this, NotificationActivity.class));
                finish();
            }
        });
    }
    private void id() {
        homeback=findViewById(R.id.homeback);
        acionbarnametitle=findViewById(R.id.acionbarnametitle);
        actionBarRightImage=findViewById(R.id.actionBarRightImage);
    }
}