package com.fcodex.ecommerce.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.arlib.floatingsearchview.FloatingSearchView;
import com.fcodex.ecommerce.R;
import com.fcodex.ecommerce.SharedPreference.Sharedpreference;
import com.fcodex.ecommerce.databinding.ActivitySearchBinding;

public class SearchActivity extends AppCompatActivity {

    ActivitySearchBinding binding;
    Sharedpreference sharedpreference;
    private ImageView homeback,actionBarRightImage;
    private TextView acionbarnametitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySearchBinding.inflate(getLayoutInflater());
        sharedpreference=new Sharedpreference(this);
        if (sharedpreference.LoadDarkMode()){

            setTheme(R.style.Theme_AppCompat);
        }
        else
        {
            setTheme(R.style.Theme_AppCompat_DayNight);
        }
        setContentView(R.layout.activity_search);
        setContentView(binding.getRoot());
        getSupportActionBar().hide();


        id();
        acionbarnametitle.setText("Search");
        actionBarRightImage.setVisibility(View.GONE);
       onsearchclick();
    }

    private void onsearchclick() {
        binding.floatingsearchview.setOnQueryChangeListener(new FloatingSearchView.OnQueryChangeListener() {
            @Override
            public void onSearchTextChanged(String oldQuery, final String newQuery) {

                //get suggestions based on newQuery

                //pass them on to the search view
                // floating_search_view.swapSuggestions(newSuggestions);
            }
        });
        // clicking on back arrow
        homeback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SearchActivity.this, MainActivity.class));
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