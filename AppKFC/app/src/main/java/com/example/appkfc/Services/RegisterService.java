package com.example.appkfc.Services;

import com.example.appkfc.models.LoginRegistroRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RegisterService {

    @POST("login/register.php")
    Call<String> register(@Body LoginRegistroRequest loginRegistroRequest);
}
