package com.example.appkfc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.appkfc.Adapters.ProductAdapter;
import com.example.appkfc.Services.ListProducts1;
import com.example.appkfc.databinding.ActivityProductosBinding;

import com.example.appkfc.models.ListProductsModel1;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductosActivity extends AppCompatActivity {

    ProductAdapter productAdapter;
    ArrayList<ListProductsModel1> productArrayList1;
    ArrayList productArrayList;
    Retrofit retrofit;
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
        retrofit = new Retrofit.Builder()
                .baseUrl("http://54.197.21.179/features/").addConverterFactory(GsonConverterFactory.create())
                .build();

        productosBinding.btndirecp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(ProductosActivity.this, Compra.class);
                startActivity(intent);
            }
        });

        ListarProducts();
    }


    //Metodo boton de inicio
    public void  inicio (View view){
        Intent inicio = new Intent(this, MainActivity.class);
        startActivity(inicio);
    }

    //connection API

    public void ListarProducts(){

        ListProducts1 listProducts = retrofit.create(ListProducts1.class);
        Call<ArrayList<ListProductsModel1>> listar = listProducts.listar();
        listar.enqueue(new Callback<ArrayList<ListProductsModel1>>() {
            @Override
            public void onResponse(Call<ArrayList<ListProductsModel1>> call, Response<ArrayList<ListProductsModel1>> response) {
                if (response.isSuccessful()) {
                    for (int i = 0; i < response.body().size(); i++) {
                        productArrayList.add(response.body().get(i));
                    }
                    productAdapter.notifyDataSetChanged();
                }
                else{
                    Toast.makeText(ProductosActivity.this, ""+response.toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<ListProductsModel1>> call, Throwable t) {
            }
        });
    }


}