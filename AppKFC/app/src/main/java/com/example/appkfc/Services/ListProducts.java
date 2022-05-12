package com.example.appkfc.Services;

import android.widget.Toast;

import com.example.appkfc.models.ListProductsModel;
import com.example.appkfc.models.ListProductsRequest;
import com.example.appkfc.models.LoginModel;
import com.example.appkfc.models.LoginRequest;
import com.example.appkfc.sesion;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ListProducts {

    @GET("list_products/listProductos.php")
    Call<ArrayList<ListProductsModel>> listar();

    @POST("list_products/compraproducts.php")
    Call<String> compra(@Body ListProductsModel data);

    @GET("list_products/listCompras.php")
    Call<ArrayList<ListProductsModel>> listarCompra();

    @GET("list_products/borracompra.php")
    Call<String> Comprass();// cambiar***

}
