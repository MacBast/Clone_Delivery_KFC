package com.example.appkfc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appkfc.Entities.Product;
import com.example.appkfc.Services.LoginService;
import com.example.appkfc.databinding.ActivityMainBinding;
import com.example.appkfc.models.LoginModel;
import com.example.appkfc.models.LoginRequest;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD
        mainBinding.pedir.setOnClickListener(this);
=======
       // mainBinding.pedir.setOnClickListener(this);
>>>>>>> 64ab3de51ace4b58c1d8d8267081212bdbf10666
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.pedir:
                Intent intent = new Intent(this,LoginActivity.class);
                startActivity(intent);
                break;
        }
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
