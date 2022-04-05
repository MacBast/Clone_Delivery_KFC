package com.example.appkfc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appkfc.Services.LoginService;
import com.example.appkfc.models.LoginModel;
import com.example.appkfc.models.LoginRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class sesion extends AppCompatActivity {

    EditText idUser, idPss;
    Button BsaveRR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion);

        idUser=findViewById(R.id.editTextTextEmailAddress);
        idPss=findViewById(R.id.editTextTextPassword);

        BsaveRR= findViewById(R.id.btnincioSec);
        BsaveRR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });
    }



    public void loginUser(){
        String xidemail = idUser.getText().toString().trim();
        String xidpass = idPss.getText().toString().trim();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.207.11/Jueves6/Api_res/features/").addConverterFactory(GsonConverterFactory.create())
                .build();
        LoginService loginService = retrofit.create(LoginService.class);
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail(xidemail);
        loginRequest.setPass(xidpass);
        Call<LoginModel> login = loginService.login(loginRequest);
        login.enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                if (response.isSuccessful()){
                    LoginModel model = response.body();
                    Toast.makeText(sesion.this,model.getEmail(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {
                Toast.makeText(sesion.this,"funciono pero hay un error"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }



    //Metodo boton de Login
    public void  login (View view) {
        Intent login = new Intent(this, LoginActivity.class);
        startActivity(login);
    }

    //Metodo boton de iniciar sesion
    public void  iniciar (View view){
        Intent iniciar = new Intent(this, sesion.class);
        startActivity(iniciar);
    }

    //Metodo boton de registrarme
    public void  registrarme (View view){
        Intent registrarme = new Intent(this, registerActivity.class);
        startActivity(registrarme);
    }
}