package com.example.appkfc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.JsonReader;
import android.view.View;
import android.widget.Toast;

import com.example.appkfc.Adapters.ProductAdapter;
import com.example.appkfc.Entities.Product;
import com.example.appkfc.Services.ListProducts;
import com.example.appkfc.Services.LoginService;
import com.example.appkfc.databinding.ActivityMainBinding;
import com.example.appkfc.databinding.ActivityProductosBinding;
import com.example.appkfc.models.ListProductsModel;
import com.example.appkfc.models.ListProductsRequest;
import com.example.appkfc.models.LoginModel;
import com.example.appkfc.models.LoginRequest;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductosActivity extends AppCompatActivity {

    ProductAdapter productAdapter;
    ArrayList productArrayList;
    private ActivityProductosBinding productosBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);
        productosBinding = ActivityProductosBinding.inflate(getLayoutInflater());
        View view= productosBinding.getRoot();
        setContentView(view);
        productArrayList = new ArrayList<>();
        productAdapter = new ProductAdapter(this, productArrayList);
        productosBinding.rvProducts.setHasFixedSize(true);
        productosBinding.rvProducts.setLayoutManager(new LinearLayoutManager(this));
        productosBinding.rvProducts.setAdapter(productAdapter);
        ListarProducts();
    }


    //Metodo boton de inicio
    public void  inicio (View view){
        Intent inicio = new Intent(this, MainActivity.class);
        startActivity(inicio);
    }

    //connection API

    public void ListarProducts(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://172.18.86.226/Clone_Delivery_KFC/Api_res/features/").addConverterFactory(GsonConverterFactory.create())
                .build();
        ListProducts listProducts = retrofit.create(ListProducts.class);
        ListProductsRequest listProductsRequest = new ListProductsRequest();
        ListProductsModel listProductsRequest2 = new ListProductsModel();
        Call<ListProductsModel> listar = listProducts.listar(listProductsRequest2);
        listar.enqueue(new Callback<ListProductsModel>() {
            @Override
            public void onResponse(Call<ListProductsModel> call, Response<ListProductsModel> response) {
                if (response.isSuccessful()){
                    ListProductsModel model = response.body();
                    Toast.makeText(ProductosActivity.this,"si funciono", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(ProductosActivity.this,"error del error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ListProductsModel> call, Throwable t) {
                Toast.makeText(ProductosActivity.this,"error "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}