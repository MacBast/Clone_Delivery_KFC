//package com.example.appkfc.Services;
//
//import android.widget.Toast;
//
//
//import com.example.appkfc.models.ListProductsModel1;
//import com.example.appkfc.models.ListProductsRequest1;
//import com.example.appkfc.models.LoginModel;
//import com.example.appkfc.models.LoginRequest;
//import com.example.appkfc.sesion;
//
//import java.util.ArrayList;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;
//import retrofit2.http.Body;
//import retrofit2.http.GET;
//import retrofit2.http.POST;
//import retrofit2.http.Path;
//
//public interface ListProducts {
//
//    @GET("list_products/listProductos.php")
//    Call<ArrayList<ListProductsModel1>> listar();
//
//    @POST("list_products/compraproducts.php")
//    Call<String> compra(@Body ListProductsModel1 data);
//
//    @GET("list_produvcts/listCompras.php")
//    Call<ArrayList<ListProductsModel1>> listarCompra();
//
//    @GET("list_products/borracompra.php")
//    Call<String> Comprass();// cambiar***
//
//}
