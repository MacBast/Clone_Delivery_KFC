package com.example.appkfc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.appkfc.Adapters.CompraAdapter;
import com.example.appkfc.Adapters.ProductAdapter;
import com.example.appkfc.Services.ListProducts;
import com.example.appkfc.databinding.ActivityCompraBinding;
import com.example.appkfc.models.ListProductsModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Compra extends AppCompatActivity {
    ArrayList productArrayList;
    CompraAdapter productAdapter;
    ActivityCompraBinding productosBinding;
    Retrofit retrofit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        productosBinding = ActivityCompraBinding.inflate(getLayoutInflater());
        View view = productosBinding.getRoot();
    setContentView(view);
        productArrayList = new ArrayList<>();
        productAdapter = new CompraAdapter( this,productArrayList);
       productosBinding.rvProducts.setHasFixedSize(true);
        productosBinding.rvProducts.setLayoutManager(new LinearLayoutManager(this));
        productosBinding.rvProducts.setAdapter(productAdapter);
        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.6/Api_res/features/").addConverterFactory(GsonConverterFactory.create())
                .build();

        productosBinding.btnCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProductosComprasdos();
                Intent intent = new Intent(Compra.this, ProductosActivity.class);
                startActivity(intent);

            }
        });

        ListarCompra();

    }
    public void ListarCompra(){

        ListProducts listProducts = retrofit.create(ListProducts.class);
        Call<ArrayList<ListProductsModel>> listar = listProducts.listarCompra();
        listar.enqueue(new Callback<ArrayList<ListProductsModel>>() {
            @Override
            public void onResponse(Call<ArrayList<ListProductsModel>> call, Response<ArrayList<ListProductsModel>> response) {
                for (int i = 0; i<response.body().size(); i++){
                    productArrayList.add(response.body().get(i));
                }
                productAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ArrayList<ListProductsModel>> call, Throwable t) {

            }
        });

    }



    public void ProductosComprasdos(){

        ListProducts listProducts = retrofit.create(ListProducts.class);
        Call<String> Borrar = listProducts.Comprass();
        Borrar.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                Toast.makeText(Compra.this, ""+response.body(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });


    }
}