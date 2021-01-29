package com.fcodex.ecommerce.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.fcodex.ecommerce.SharedPreference.Sharedpreference;
import com.fcodex.ecommerce.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class UserLogin extends AppCompatActivity {

    private TextView forget_password;
    private MaterialButton Login_button;
    private EditText login_email,login_password;

    Sharedpreference sharedpreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedpreference = new Sharedpreference(this);
        if (sharedpreference.LoadDarkMode()) {

            setTheme(R.style.Theme_AppCompat_NoActionBar);
        } else {
            setTheme(R.style.Theme_AppCompat_DayNight_NoActionBar);
        }
        setContentView(R.layout.activity_user_login);

        id();
        onclicl();
    }

    private void onclicl() {
        forget_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserLogin.this, ForgetPassword.class);
                startActivity(intent);
                finish();
            }
        });


        Login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String mail=login_email.getText().toString();
//                String password=login_password.getText().toString();
//
//                if (mail.isEmpty()){
//                    Toast.makeText(UserLogin.this, "User Mail is Required", Toast.LENGTH_SHORT).show();
//                }
//                else if (password.isEmpty()){
//                    Toast.makeText(UserLogin.this, "Password is Required", Toast.LENGTH_SHORT).show();
//                }
                    startActivity(new Intent(UserLogin.this, MainActivity.class));
                    finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(UserLogin.this, LoginAndRegister.class));
        finish();
        super.onBackPressed();
    }

    private void id() {
//        login_email=findViewById(R.id.login_email);
//        login_password=findViewById(R.id.login_password);
        forget_password = findViewById(R.id.forget_password);
        Login_button = findViewById(R.id.Login_button);

    }
}