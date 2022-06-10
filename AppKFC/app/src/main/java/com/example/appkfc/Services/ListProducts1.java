package com.example.appkfc.Services;

import com.example.appkfc.models.ListProductsModel1;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ListProducts1 {

    @GET("list_products/listProductos.php")
    Call<ArrayList<ListProductsModel1>> listar();

    @POST("list_products/compraproducts.php")
    Call<String> compra(@Body ListProductsModel1 data);

    @GET("list_products/listCompras.php")
    Call<ArrayList<ListProductsModel1>> listarCompra();

    @GET("list_products/borracompra.php")
    Call<String> Comprass();
}
