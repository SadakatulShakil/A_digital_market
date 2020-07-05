package com.example.digiketdigital_market.Retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {

    @FormUrlEncoded
    @POST("api")
    Call<ResponseBody> user_reg(
            @Field("name") String name,
            @Field("email") String email,
            @Field("phone") String phone,
            @Field("created_app") String date,
            @Field("password") String password
    );
}
