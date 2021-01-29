package com.fcodex.ecommerce.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fcodex.ecommerce.Adapters.ImageSliderAdapter;
import com.fcodex.ecommerce.NavFragments.HomeFragment;
import com.fcodex.ecommerce.R;
import com.fcodex.ecommerce.SharedPreference.Sharedpreference;
import com.google.android.material.button.MaterialButton;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

public class CartActivity extends AppCompatActivity {

    private SliderView imageSlider;
    private ImageView home_back,actionBarRightImage;
    private TextView quantity_text,acionbarnametitle;
    private TextView negative, positive;
    private MaterialButton cart_button;
    Sharedpreference sharedpreference;
    int add=1;

    int[] images = {R.drawable.category_woman, R.drawable.completed};

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
        setContentView(R.layout.activity_cart);
        getSupportActionBar().hide();

        id();
        home_back.setImageResource(R.drawable.ic_close);
        actionBarRightImage.setImageResource(R.drawable.ic_home);
        acionbarnametitle.setText("Select Cart");
        onclick();
        cartslider();
    }

    private void onclick() {
        //for back screen
        home_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });
        // to move notification activity
        actionBarRightImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CartActivity.this, MainActivity.class));
                finish();
            }
        });

        //increase the quantity
        positive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add=add+1;
                quantity_text.setText(" " + add);
            }
        });
        //decrease the quantity
        negative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(add!=1) {
                    add = add -1;
                    quantity_text.setText(" " + add);
                }
                else if(add==1){
                    Toast.makeText(getApplicationContext(), "Please select atleast one", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //submit cart
        cart_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              startActivity(new Intent(CartActivity.this, SelectedCartActivity.class));
                finish();
            }
        });
    }

    private void cartslider() {

        ImageSliderAdapter adapter = new ImageSliderAdapter(this, images);
        imageSlider.setSliderAdapter(adapter);
        imageSlider.setIndicatorAnimation(IndicatorAnimationType.WORM);
        imageSlider.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        imageSlider.startAutoCycle();
    }

    private void id() {
        imageSlider=findViewById(R.id.imageSlider);
        home_back=findViewById(R.id.homeback);
        actionBarRightImage=findViewById(R.id.actionBarRightImage);
        quantity_text=findViewById(R.id.quantity_text);
        acionbarnametitle=findViewById(R.id.acionbarnametitle);
        cart_button=findViewById(R.id.cart_button);
        negative=findViewById(R.id.negative);
        positive=findViewById(R.id.Positive);
    }
}