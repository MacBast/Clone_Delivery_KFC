package com.example.appkfc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class registerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    //Metodo boton de login
    public void  login (View view) {
        Intent login = new Intent(this, LoginActivity.class);
        startActivity(login);
    }

    //Metodo boton de registrarme
    public void  registrarme (View view){
        Intent registrarme = new Intent(this, registerActivity.class);
        startActivity(registrarme);
    }

    //Metodo boton de iniciar sesion
    public void  iniciar (View view){
        Intent iniciar = new Intent(this, sesion.class);
        startActivity(iniciar);
    }
}