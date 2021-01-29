package com.fcodex.ecommerce.NavFragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.fcodex.ecommerce.Activities.EditProfile;
import com.fcodex.ecommerce.Activities.FinishActivity;
import com.fcodex.ecommerce.Activities.MainActivity;
import com.fcodex.ecommerce.R;
import com.fcodex.ecommerce.SharedPreference.Sharedpreference;
import com.fcodex.ecommerce.databinding.FragmentProfileBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import static android.content.Context.MODE_PRIVATE;

public class ProfileFragment extends Fragment {


   FragmentProfileBinding binding;
   View root;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding=FragmentProfileBinding.inflate(getLayoutInflater());

        root = binding.getRoot();
        onclick();
        sharedpref();
        return root;
    }

    private void sharedpref() {
    }

    private void onclick() {

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), EditProfile.class));
            }
        });
    }


}