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

public class registerActivity extends AppCompatActivity {

    EditText idUser, idEmail;
    Button BsaveRR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        idUser=findViewById(R.id.editTextTextEmailAddress);
        idEmail=findViewById(R.id.editTextTextPassword);

        BsaveRR= findViewById(R.id.button_continuar);
        loginUser();
    }

    public String UserS(){
        BsaveRR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String xiduser = idUser.getText().toString().trim();
                String xidEmail = idEmail.getText().toString().trim();
            }
        });
        return null;
    }

    public String EmailS(){
        String xidEmail;
        BsaveRR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View user) {
                String xidEmail = idEmail.getText().toString().trim();
            }
        });
        return null;
    }

    //private void gotoguardar(String xiduser, String xidEmail) {
        public void loginUser(){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://192.168.18.22:80/Jueves6/Api_res/features/").addConverterFactory(GsonConverterFactory.create())
                    .build();
            LoginService loginService = retrofit.create(LoginService.class);
            LoginRequest loginRequest = new LoginRequest();
            loginRequest.setEmail(UserS());
            loginRequest.setIdentification(EmailS());
            Call<LoginModel> login = loginService.login(loginRequest);
            login.enqueue(new Callback<LoginModel>() {
                @Override
                public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                    if (response.isSuccessful()){
                        LoginModel model = response.body();
                        Toast.makeText(registerActivity.this,model.getFullname(), Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onFailure(Call<LoginModel> call, Throwable t) {
                    Toast.makeText(registerActivity.this,"funciono pero hay un error", Toast.LENGTH_SHORT).show();
                }
            });

        }

    //}

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

    public void  register2 (View view) {
        Intent register2 = new Intent(this, register2.class);
        startActivity(register2);
    }





}