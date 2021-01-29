package com.fcodex.ecommerce.Activities;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fcodex.ecommerce.R;
import com.fcodex.ecommerce.SharedPreference.Sharedpreference;
import com.google.android.material.button.MaterialButton;

public class NewAddressActivity extends AppCompatActivity {

    private ImageView home_back,actionBarRightImage;
    private TextView acionbarnametitle;
    Sharedpreference sharedpreference;
    private MaterialButton addnewaddress;

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
        setContentView(R.layout.activity_new_address);
        getSupportActionBar().hide();
        id();
        home_back.setImageResource(R.drawable.ic_close);
        actionBarRightImage.setVisibility(View.GONE);
        acionbarnametitle.setText("New Address");
        onclick();
    }

    private void onclick() {
        home_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NewAddressActivity.this, AddressActivity.class));
                finish();
            }
        });

        addnewaddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NewAddressActivity.this, AddressActivity.class));
                finish();
            }
        });
    }

    private void id() {
        home_back=findViewById(R.id.homeback);
        actionBarRightImage=findViewById(R.id.actionBarRightImage);
        acionbarnametitle=findViewById(R.id.acionbarnametitle);
        addnewaddress=findViewById(R.id.addnewaddress);

    }
}