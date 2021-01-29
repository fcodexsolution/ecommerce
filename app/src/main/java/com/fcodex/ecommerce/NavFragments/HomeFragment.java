package com.fcodex.ecommerce.NavFragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.fcodex.ecommerce.Activities.AllCategories;
import com.fcodex.ecommerce.Activities.CartActivity;
import com.fcodex.ecommerce.Activities.CategoriesActivity;
import com.fcodex.ecommerce.Activities.FeaturedActivity;
import com.fcodex.ecommerce.Adapters.ImageSliderAdapter;
import com.fcodex.ecommerce.R;
import com.fcodex.ecommerce.databinding.FragmentHomeBinding;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;


public class HomeFragment extends Fragment {

    int[] images = {R.drawable.d_slider1, R.drawable.d_slider_1};

    FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        View root = binding.getRoot();
        slider();
        onclick();
        return root;
    }


    private void onclick() {
        //for best selling products
        binding.seeallbestselling.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), FeaturedActivity.class);
            startActivity(intent);
        });
        //for featured
        binding.featuredall.setOnClickListener(v -> startActivity(new Intent(getContext(), FeaturedActivity.class)));
        //for categories
        binding.categriesseeall.setOnClickListener(v -> startActivity(new Intent(getContext(), AllCategories.class)));
        // for mens category
        binding.menscard.setOnClickListener(v -> startActivity(new Intent(getContext(), CategoriesActivity.class)));
        //for women category
        binding.womencard.setOnClickListener(v -> startActivity(new Intent(getContext(), CategoriesActivity.class)));
        //for kids category
        binding.kidscard.setOnClickListener(v -> startActivity(new Intent(getContext(), CategoriesActivity.class)));
        //for featured items
        binding.featured1.setOnClickListener(v -> startActivity(new Intent(getContext(), CartActivity.class)));
        //selling item
        binding.selling1.setOnClickListener(v -> startActivity(new Intent(getContext(), CartActivity.class)));
        //discount See All Item
        binding.seeAllDiscount.setOnClickListener(v -> {
            Toast.makeText(getActivity(), "discoubt", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getActivity(), FeaturedActivity.class);
            startActivity(intent);
        });
        //discount item
        binding.discount1.setOnClickListener(v -> startActivity(new Intent(getContext(), CartActivity.class)));
    }

    private void slider() {
        ImageSliderAdapter adapter = new ImageSliderAdapter(getContext(), images);
        binding.imageSlider.setSliderAdapter(adapter);
        binding.imageSlider.setIndicatorAnimation(IndicatorAnimationType.WORM);
        binding.imageSlider.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        binding.imageSlider.startAutoCycle();
    }
}