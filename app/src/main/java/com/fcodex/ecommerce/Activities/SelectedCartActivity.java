package com.fcodex.ecommerce.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fcodex.ecommerce.NavFragments.HomeFragment;
import com.fcodex.ecommerce.R;
import com.fcodex.ecommerce.SharedPreference.Sharedpreference;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class SelectedCartActivity extends AppCompatActivity {

    private TextView acionbarnametitle, quantity_text,Positive, negative;
    private MaterialButton confirm_cart;
    private ImageView home_back, actionBarRightImage,delete_cart;
    private CardView selectedCart;

    Sharedpreference sharedpreference;
    int add = 1;

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
        setContentView(R.layout.activity_selected_cart);
        getSupportActionBar().hide();

        id();
        home_back.setImageResource(R.drawable.ic_close);
        actionBarRightImage.setImageResource(R.drawable.ic_home);
        acionbarnametitle.setText("Selected Cart");
        onclick();

    }

    private void onclick() {
        //delete the cart
        delete_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedCart.setVisibility(View.INVISIBLE);
            }
        });

        //increase the quantity
        Positive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add = add + 1;
                quantity_text.setText(" " + add);
            }
        });
        //decrease the quantity
        negative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (add != 0) {
                    add = add - 1;
                    quantity_text.setText(" " + add);
                } else {
                    Toast.makeText(getApplicationContext(), "Please select atleast one", Toast.LENGTH_SHORT).show();
                }
            }
        });

        actionBarRightImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SelectedCartActivity.this, MainActivity.class));
                finish();
            }
        });

        home_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });
        //alert dialogue box
        confirm_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MaterialAlertDialogBuilder(SelectedCartActivity.this)
                        .setTitle("Payment Method")
                        .setMessage("Please select your payment method")
                        .setPositiveButton("Hand Cash", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(new Intent(SelectedCartActivity.this, AddressActivity.class));
                                finish();

                            }
                        })
                        .setNegativeButton("ATM Card", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                AlertDialog.Builder alertDialog = new AlertDialog.Builder(SelectedCartActivity.this);
                                alertDialog.setTitle("Select Method");
                                String[] items = {"Jazz Cash","EasyPaisa","Google Pay","PayPal","Payoneer", "Visa/Masterd Card"};
                                int checkedItem = 1;
                                alertDialog.setSingleChoiceItems(items, checkedItem, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        switch (which) {
                                            case 0:
                                                startActivity(new Intent(SelectedCartActivity.this, CardPaymentActivity.class));
                                                break;
                                            case 1:
                                                startActivity(new Intent(SelectedCartActivity.this, CardPaymentActivity.class));
                                                break;
                                            case 2:
                                                startActivity(new Intent(SelectedCartActivity.this, CardPaymentActivity.class));
                                                break;
                                            case 3:
                                                startActivity(new Intent(SelectedCartActivity.this, CardPaymentActivity.class));
                                                break;
                                            case 4:
                                                startActivity(new Intent(SelectedCartActivity.this, CardPaymentActivity.class));
                                                break;

                                            case 5:
                                                startActivity(new Intent(SelectedCartActivity.this, CardPaymentActivity.class));
                                                break;
                                        }
                                    }
                                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        onBackPressed();
                                    }
                                });
                                AlertDialog alert = alertDialog.create();
                                alert.setCanceledOnTouchOutside(false);
                                alert.show();
                            }
                        })
                        .show();
            }
        });
    }

    private void id() {
        confirm_cart = findViewById(R.id.confirm_cart);
        negative = findViewById(R.id.negative);
        Positive = findViewById(R.id.Positive);
        quantity_text = findViewById(R.id.quantity_text);
        home_back = findViewById(R.id.homeback);
        actionBarRightImage = findViewById(R.id.actionBarRightImage);
        acionbarnametitle = findViewById(R.id.acionbarnametitle);
        delete_cart=findViewById(R.id.delete_cart);
        selectedCart=findViewById(R.id.selectedCart);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(SelectedCartActivity.this, CartActivity.class));
        finish();
    }
}