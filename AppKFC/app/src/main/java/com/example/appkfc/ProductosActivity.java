package com.example.appkfc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
    ArrayList<Product> productArrayList;
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
        //productosBinding.rvPro;
    }


    //Metodo boton de inicio
    public void  inicio (View view){
        Intent inicio = new Intent(this, MainActivity.class);
        startActivity(inicio);
    }

    //connection DB

    public void ListarProducts(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.207.11/Jueves6/Api_res/features/").addConverterFactory(GsonConverterFactory.create())
                .build();
        ListProducts listProducts = retrofit.create(ListProducts.class);
        ListProductsRequest listProductsRequest = new ListProductsRequest();

        Call<ListProductsModel> listar = listProducts.listar(listProductsRequest);
        listar.enqueue(new Callback<ListProductsModel>() {
            @Override
            public void onResponse(Call<ListProductsModel> call, Response<ListProductsModel> response) {
                if (response.isSuccessful()){
                    ListProductsModel model = response.body();
                    Toast.makeText(ProductosActivity.this,model.getName(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ListProductsModel> call, Throwable t) {
                Toast.makeText(ProductosActivity.this,"funciono pero hay un error"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    //listar productos

}