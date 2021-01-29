package com.fcodex.ecommerce.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fcodex.ecommerce.SharedPreference.Sharedpreference;
import com.fcodex.ecommerce.R;

public class ForgetPassword extends AppCompatActivity {

    private ImageView home_back, actionBarRightImage;
    private TextView acionbarnametitle;
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
        setContentView(R.layout.activity_forget_password);

        getSupportActionBar().hide();
        id();
        acionbarnametitle.setText("Forget Password");
        acionbarnametitle.setTextColor(getResources().getColor(R.color.dark_gray));
        actionBarRightImage.setVisibility(View.INVISIBLE);
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

    private void id()
    {
        home_back=findViewById(R.id.homeback);
        acionbarnametitle=findViewById(R.id.acionbarnametitle);
        actionBarRightImage=findViewById(R.id.actionBarRightImage);
    }
}