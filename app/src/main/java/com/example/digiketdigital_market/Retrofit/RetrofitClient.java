package com.example.digiketdigital_market.Retrofit;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String BASE_URL = "http://192.168.1.103/DemoApi/";
    private static RetrofitClient rInstance;
    private Retrofit retrofit;

    private RetrofitClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrofitClient getInstance(){
        if(rInstance == null){
            rInstance = new RetrofitClient();
        }
        return rInstance;
        }


        public Api getApi(){
        return retrofit.create(Api.class);
        }
    }

