package com.example.appkfc.Services;

import android.widget.Toast;

import com.example.appkfc.models.ListProductsModel;
import com.example.appkfc.models.ListProductsRequest;
import com.example.appkfc.models.LoginModel;
import com.example.appkfc.models.LoginRequest;
import com.example.appkfc.sesion;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ListProducts {

    @POST("list_products/listProductos.php")
    Call<ListProductsModel> listar(@Body ListProductsRequest listProductsRequest);


}
