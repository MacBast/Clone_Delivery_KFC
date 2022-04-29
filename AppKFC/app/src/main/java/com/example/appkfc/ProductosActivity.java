package com.example.appkfc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.appkfc.Adapters.ProductAdapter;
import com.example.appkfc.Entities.Product;
import com.example.appkfc.databinding.ActivityMainBinding;
import com.example.appkfc.databinding.ActivityProductosBinding;

import java.util.ArrayList;

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
    }


    //Metodo boton de inicio
    public void  inicio (View view){
        Intent inicio = new Intent(this, MainActivity.class);
        startActivity(inicio);
    }


    //listar productos

}