package com.example.appkfc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appkfc.Services.LoginService;
import com.example.appkfc.databinding.ActivitySesionBinding;
import com.example.appkfc.models.LoginDataModel;
import com.example.appkfc.models.LoginModel;
import com.example.appkfc.models.LoginModel2;
import com.example.appkfc.models.LoginRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class sesion extends AppCompatActivity {

    EditText idUser, idPss;
    Button BsaveRR;
    ActivitySesionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySesionBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        BsaveRR= findViewById(R.id.btnincioSec);
        BsaveRR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });
    }



    public void loginUser(){
        String xidemail =binding.editTextTextEmailAddress.getText().toString();
        String xidpass =binding.editTextTextPassword.getText().toString();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.6/Api_res/features/").addConverterFactory(GsonConverterFactory.create())
                .build();

        LoginDataModel loginDataModel = new LoginDataModel();
        loginDataModel.setEmail(xidemail);
        loginDataModel.setPass(xidpass);
        LoginService loginService = retrofit.create(LoginService.class);
        Call<LoginModel2> login = loginService.login(loginDataModel);
        login.enqueue(new Callback<LoginModel2>() {
            @Override
            public void onResponse(Call<LoginModel2> call, Response<LoginModel2> response) {

                LoginModel2 model = response.body();

                    try {

                        if (model.getEmail().equals(xidemail)&& model.getContraseña().equals(xidpass)) {

                            Intent intent = new Intent(sesion.this, ProductosActivity.class);
                            startActivity(intent);

                            Toast.makeText(sesion.this, "bien", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(sesion.this, "datos incorrectos", Toast.LENGTH_SHORT).show();
                        }
                    }catch (Exception e){

                    }
                   /* */
            }

            @Override
            public void onFailure(Call<LoginModel2> call, Throwable t) {
                Toast.makeText(sesion.this,"funciono pero hay un error" + t.getMessage(), Toast.LENGTH_SHORT).show();
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