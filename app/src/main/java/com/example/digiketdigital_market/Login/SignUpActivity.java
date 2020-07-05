package com.example.digiketdigital_market.Login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.digiketdigital_market.Home.HomeActivity;
import com.example.digiketdigital_market.R;
import com.example.digiketdigital_market.pojoclass.User;
import com.example.digiketdigital_market.pojoclass.UserResponse;
import com.example.digiketdigital_market.retrofit.Api;
import com.example.digiketdigital_market.retrofit.RetrofitInstance;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SignUpActivity extends AppCompatActivity {

    private EditText nameET, emailET, phoneET, passwordET;
    private Button signUpBT;
    private static final String TAG = "SignUpActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        init();
        clickEvents();


    }

    private void clickEvents() {
        signUpBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //COding for go to home page
                userSignUp();
            }
        });
    }

    private void userSignUp() {
        String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        String currentTime = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());

        String name = nameET.getText().toString().trim();

        String email = emailET.getText().toString().trim();

        String phone = phoneET.getText().toString().trim();

        String created_app = currentDate + " " + currentTime;
        String password = passwordET.getText().toString().trim();

        ///Another idea of constructor

        final User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setCreatedApp(created_app);
        user.setPhone(phone);
        user.setPassword(password);

        Retrofit  retrofit = RetrofitInstance.getRetrofitInstance();

        Api api = retrofit.create(Api.class);

        Call<UserResponse> call = api.user_reg(user);

        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if(response.code() == 200){
                    Toast.makeText(SignUpActivity.this, "data inserted name is !" + user.getName(), Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(SignUpActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {

            }
        });

    }

    private void init() {
        nameET = findViewById(R.id.etName);
        emailET = findViewById(R.id.etEmail);
        phoneET = findViewById(R.id.etPhone);
        passwordET = findViewById(R.id.etPassword);
        signUpBT = findViewById(R.id.btSignUp);
    }
}
