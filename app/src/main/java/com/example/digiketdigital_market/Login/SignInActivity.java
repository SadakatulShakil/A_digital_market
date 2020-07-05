package com.example.digiketdigital_market.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.digiketdigital_market.R;

public class SignInActivity extends AppCompatActivity {
    private EditText emailET, passwordET;
    private TextView forgetPassTV, signUpTV;
    private Button signInBT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        init();
        clickEvents();
    }

    private void clickEvents() {

        signInBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //coding for go to home page;
            }
        });

        signUpTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    private void init() {
        emailET = findViewById(R.id.etEmail);
        passwordET = findViewById(R.id.etPassword);
        forgetPassTV = findViewById(R.id.forgetPassword);
        signUpTV = findViewById(R.id.tvRegistration);
        signInBT = findViewById(R.id.btSignIn);
    }
}
