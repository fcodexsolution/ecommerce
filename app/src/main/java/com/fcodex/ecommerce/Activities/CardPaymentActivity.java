package com.fcodex.ecommerce.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.fcodex.ecommerce.R;
import com.fcodex.ecommerce.SharedPreference.Sharedpreference;
import com.google.android.material.button.MaterialButton;

import java.util.Calendar;

public class CardPaymentActivity extends AppCompatActivity {

    private ImageView home_back,actionBarRightImage,paypal_card_pic;
    private MaterialButton confrm_payment;
    private TextView actionbartittle;
    private EditText expiry_date;
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
        setContentView(R.layout.activity_card_payment);
        getSupportActionBar().hide();

        id();
        actionBarRightImage.setImageResource(R.drawable.ic_home);
        actionbartittle.setText("Online Payment");
        onclick();

    }

    private void onclick() {
        //confirm button click
        confrm_payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CardPaymentActivity.this, AddressActivity.class));
                finish();
            }
        });
        //home icon click
        home_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });
        //home icon
        actionBarRightImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CardPaymentActivity.this, MainActivity.class));
                finish();
            }
        });
        //ruff click on card
        paypal_card_pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CardPaymentActivity.this, FailedActivity.class));
            }
        });
        //click on calender
        expiry_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar=Calendar.getInstance();
                int year= calendar.get(Calendar.YEAR);
                int month= calendar.get(Calendar.MONTH);
                int day= calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog= new DatePickerDialog(CardPaymentActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        expiry_date.setText(year+"/"+(month+1)+"/"+dayOfMonth);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

    }

    private void id() {
        actionbartittle=findViewById(R.id.acionbarnametitle);
        home_back=findViewById(R.id.homeback);
        actionBarRightImage=findViewById(R.id.actionBarRightImage);
        confrm_payment=findViewById(R.id.confrm_payment);
        paypal_card_pic=findViewById(R.id.paypal_card_pic);
        expiry_date=findViewById(R.id.expiry_date);
    }
}