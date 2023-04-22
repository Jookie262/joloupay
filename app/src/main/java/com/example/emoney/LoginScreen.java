package com.example.emoney;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.textfield.TextInputLayout;

public class LoginScreen extends AppCompatActivity {

    TextInputLayout username_layout, password_layout;
    ImageButton submit_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        username_layout = findViewById(R.id.username_layout);
        password_layout = findViewById(R.id.password_layout);
        submit_btn = findViewById(R.id.submit_btn);

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String get_username = username_layout.getEditText().getText().toString();
                String get_password = password_layout.getEditText().getText().toString();

                if(validateInput(get_username, get_password)){
                    startActivity(new Intent(LoginScreen.this, DashboardActivity.class));
                    finish();
                }
            }
        });
    }

    private boolean validateInput(String username, String password){
        boolean isValid = true;

        if(username.isEmpty()){
            username_layout.setError("Please Input Username");
            isValid = false;
        } else {
            username_layout.setError(null);
        }

        if(password.isEmpty()){
            password_layout.setError("Please Input Password");
            isValid = false;
        } else {
            password_layout.setError(null);
        }

        return isValid;
    }
}