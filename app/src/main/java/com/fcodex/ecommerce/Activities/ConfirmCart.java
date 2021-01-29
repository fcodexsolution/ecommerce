package com.fcodex.ecommerce.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fcodex.ecommerce.R;
import com.fcodex.ecommerce.databinding.ActivityCartBinding;
import com.fcodex.ecommerce.databinding.ActivityConfirmCartBinding;

public class ConfirmCart extends AppCompatActivity {

    ActivityConfirmCartBinding binding;
    private ImageView homeback,actionbarrightimage;
    private TextView actionbartittle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityConfirmCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        id();
        actionbartittle.setText("Confirm Cart");
        actionbarrightimage.setImageResource(R.drawable.ic_home);
        onclick();
    }

    private void id() {
        actionbarrightimage=findViewById(R.id.actionBarRightImage);
        actionbartittle=findViewById(R.id.acionbarnametitle);
        homeback=findViewById(R.id.homeback);

    }

    private void onclick() {
        //toolbar
        homeback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });
        actionbarrightimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ConfirmCart.this, MainActivity.class));
                finish();
            }
        });
        binding.confirmCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ConfirmCart.this, FinishActivity.class));
                finish();
            }
        });
    }
}