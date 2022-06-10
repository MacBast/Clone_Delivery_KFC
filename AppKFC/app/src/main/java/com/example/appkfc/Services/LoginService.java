package com.example.appkfc.Services;

import com.example.appkfc.models.LoginDataModel1;
import com.example.appkfc.models.LoginModel21;
import com.example.appkfc.models.LoginRegistroRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginService {

    @POST("login/login.php")
    Call<LoginModel21> login(@Body LoginDataModel1 loginRequest);



   /// @POST("login/register.php")
    //Call<String> register(@p String correo, String pass);

}
