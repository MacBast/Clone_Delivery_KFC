package com.example.appkfc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ProductosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);
    }


    //Metodo boton de inicio
    public void  inicio (View view){
        Intent inicio = new Intent(this, MainActivity.class);
        startActivity(inicio);
    }

}