package com.example.appkfc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    //Metodo boton de inicio
    public void  inicio (View view){
        Intent inicio = new Intent(this, MainActivity.class);
        startActivity(inicio);
    }

    //Metodo boton de registrarme
    public void  registrarme (View view){
        Intent registrarme = new Intent(this, registerActivity.class);
        startActivity(registrarme);
    }

    //Metodo boton de iniciar sesion
    public void  iniciar (View view){
        Intent iniciar = new Intent(this, registerActivity.class);
        startActivity(iniciar);
    }
}