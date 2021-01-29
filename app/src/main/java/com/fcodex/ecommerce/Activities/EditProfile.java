package com.fcodex.ecommerce.Activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.fcodex.ecommerce.R;
import com.fcodex.ecommerce.databinding.ActivityEditProfileBinding;

public class EditProfile extends AppCompatActivity {

    ActivityEditProfileBinding binding;
    public static final int Image = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityEditProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        onclick();
       // sharedpref();

    }

//    private void sharedpref() {
//        SharedPreferences sharedPreferences=getSharedPreferences("ProfileData", MODE_PRIVATE);
//        SharedPreferences.Editor editor=sharedPreferences.edit();
//        editor.putString("UserName", binding.userName.getEditText().getText().toString());
//        editor.putString("ProfileEmail", binding.userEmail.getEditText().getText().toString());
//        editor.putString("UserCity", binding.userCity.getEditText().getText().toString());
//        editor.putString("UserAddress", binding.useAddress.getEditText().getText().toString());
//        editor.putInt("UserNumber", Integer.parseInt(binding.userPhoneNo.getEditText().getText().toString()));
//        editor.putInt("UserPostalCode", Integer.parseInt(binding.postalCode.getEditText().getText().toString()));
//    }

    private void onclick() {
        binding.profileImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent.createChooser(intent, "Select Image"), Image);
            }
        });

        binding.updateProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EditProfile.this, MainActivity.class));
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Image && data != null) {
            Uri uri = data.getData();
            binding.profileImg.setImageURI(uri);
        }
    }
}