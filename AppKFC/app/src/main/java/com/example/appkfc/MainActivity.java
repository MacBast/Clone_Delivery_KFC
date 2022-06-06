package com.example.appkfc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.appkfc.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        mainBinding.pedir.setOnClickListener(this);

    }


    //Metodo boton de login
    public void  login (View view){
        Intent login = new Intent(this, LoginActivity.class);
        startActivity(login);
    }

    //Metodo boton de productos
    public void  productos (View view){
        Intent productos = new Intent(this, ProductosActivity.class);
        startActivity(productos);
    }

}
