package com.example.appkfc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.appkfc.Adapters.CompraAdapter;
import com.example.appkfc.Services.ListProducts1;
import com.example.appkfc.databinding.ActivityCompraBinding;

import com.example.appkfc.models.ListProductsModel1;

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
                .baseUrl("http://34.234.64.174/features/").addConverterFactory(GsonConverterFactory.create())
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

        ListProducts1 listProducts = retrofit.create(ListProducts1.class);
        Call<ArrayList<ListProductsModel1>> listar = listProducts.listarCompra();
        listar.enqueue(new Callback<ArrayList<ListProductsModel1>>() {
            @Override
            public void onResponse(Call<ArrayList<ListProductsModel1>> call, Response<ArrayList<ListProductsModel1>> response) {
                for (int i = 0; i<response.body().size(); i++){
                    productArrayList.add(response.body().get(i));
                }
                productAdapter.notifyDataSetChanged();
                //Toast.makeText(Compra.this, "..."+response.body(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ArrayList<ListProductsModel1>> call, Throwable t) {
                Toast.makeText(Compra.this, ""+t, Toast.LENGTH_SHORT).show();
            }
        });

    }



    public void ProductosComprasdos(){

        ListProducts1 listProducts1 = retrofit.create(ListProducts1.class);
        Call<String> Borrar = listProducts1.Comprass();
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