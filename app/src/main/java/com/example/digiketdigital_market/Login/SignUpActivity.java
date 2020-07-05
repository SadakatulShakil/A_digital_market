package com.example.digiketdigital_market.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.digiketdigital_market.R;
import com.example.digiketdigital_market.Retrofit.RetrofitClient;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        String name = nameET.getText().toString().trim();;
        String email = emailET.getText().toString().trim();;
        String phone = phoneET.getText().toString().trim();;
        String created_app = currentDate+" "+currentTime;
        String password = passwordET.getText().toString().trim();

        if(nameET!= null || emailET!= null || phoneET!= null || password != null){

            Call<ResponseBody> call = RetrofitClient
                    .getInstance()
                    .getApi()
                    .user_reg(name,email,phone,created_app,password);

            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    //String s = response.errorBody().toString();
                    String s = null;
                    try {
                        s = response.body().string();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Log.d(TAG, "onResponse: " + s);
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Toast.makeText(SignUpActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });

        }else{
            Toast.makeText(this, "Please fill the all field !", Toast.LENGTH_SHORT).show();
        }
    }

    private void init() {
        nameET = findViewById(R.id.etName);
        emailET =findViewById(R.id.etEmail);
        phoneET = findViewById(R.id.etPhone);
        passwordET = findViewById(R.id.etPassword);
        signUpBT = findViewById(R.id.btSignUp);
    }
}
