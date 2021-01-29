package com.fcodex.ecommerce.NavFragments;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.fcodex.ecommerce.R;

public class FavouriteFragment extends Fragment {

    private ImageView favourite,unFavourite;
    private CardView category_card;
    View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_favourite, container, false);
        id();
        onclick();
        return view;
    }

    private void onclick() {
        favourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                favourite.setVisibility(View.INVISIBLE);
                unFavourite.setVisibility(View.VISIBLE);
                category_card.setVisibility(View.INVISIBLE);
            }
        });
        unFavourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unFavourite.setVisibility(View.INVISIBLE);
                favourite.setVisibility(View.VISIBLE);

            }
        });
    }

    private void id() {
        favourite=view.findViewById(R.id.favourite);
        unFavourite=view.findViewById(R.id.unFavourite);
        category_card=view.findViewById(R.id.category_card);
    }
}