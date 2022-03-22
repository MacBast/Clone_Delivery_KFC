package com.example.appkfc;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class InicioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
    }

    //Metodo boton de Login
    public void  login (View view) {
        Intent login = new Intent(this, LoginActivity.class);
        startActivity(login);
    }
}