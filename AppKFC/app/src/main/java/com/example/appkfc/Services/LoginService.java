package com.example.appkfc.Services;

import com.example.appkfc.models.LoginDataModel;
import com.example.appkfc.models.LoginModel;
import com.example.appkfc.models.LoginModel2;
import com.example.appkfc.models.LoginRequest;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface LoginService {

    @POST("login/login.php")
    Call<LoginModel2> login(@Body LoginDataModel loginRequest);

    @POST("login/register.php")
    Call<String>register(@Body LoginRequest datos);


   /// @POST("login/register.php")
    //Call<String> register(@p String correo, String pass);

}
