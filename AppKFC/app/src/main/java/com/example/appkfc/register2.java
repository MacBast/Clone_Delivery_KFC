package com.example.appkfc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


import com.example.appkfc.Services.LoginService;
import com.example.appkfc.databinding.ActivityRegister2Binding;


import com.example.appkfc.models.ListProductsRequest1;
import com.example.appkfc.models.LoginModel;
import com.example.appkfc.models.LoginRequest;
import com.example.appkfc.models.RegistroModel1;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class register2 extends AppCompatActivity {
    private RegistroModel1 primer_registroC,primer_registroP;
    Retrofit retrofit;
    ActivityRegister2Binding binding;
    ListProductsRequest1 list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityRegister2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        retrofit = new Retrofit.Builder()
                .baseUrl("http://54.197.21.179/features/").addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public void register(View view){
        String correo,pass;

        String primer_registroC = getIntent().getExtras().getString("correo");
        String primer_registroP = getIntent().getExtras().getString("pass");

        correo = primer_registroC;
        pass = primer_registroP;


        LoginRequest usuario = new LoginRequest();
        usuario.setEmail(correo);
        usuario.setPass(pass);
        LoginService registro = retrofit.create(LoginService.class);
        Call<String> register = registro.register(usuario);
        register.enqueue(new Callback<String>() {
            @Override
                public void onResponse(Call<String> call, Response<String> response) {
                Toast.makeText(register2.this, response.body(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(register2.this,sesion.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                    Toast.makeText(register2.this, "error", Toast.LENGTH_SHORT).show();

            }
        });



     /*   Toast.makeText(register2.this, ""+ correo, Toast.LENGTH_SHORT).show();
        Intent register = new Intent(this,sesion.class);
        startActivity(register);*/

    }
}