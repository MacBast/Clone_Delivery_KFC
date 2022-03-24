package com.example.appkfc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.appkfc.Services.LoginService;
import com.example.appkfc.databinding.ActivityMainBinding;
import com.example.appkfc.models.LoginModel;
import com.example.appkfc.models.LoginRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    CardView cardView;
    private ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view= mainBinding.getRoot();
        loginUser();
        mainBinding.pedir.setOnClickListener(this);
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

    public void loginUser(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.18.22:80/Jueves6/Api_res/features/").addConverterFactory(GsonConverterFactory.create())
                .build();
        LoginService loginService = retrofit.create(LoginService.class);
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail("pedroperez@gmail.com");
        loginRequest.setIdentification("987654321");
        Call<LoginModel> login = loginService.login(loginRequest);
        login.enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                if (response.isSuccessful()){
                    LoginModel model = response.body();
                    Toast.makeText(MainActivity.this,model.getFullname(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {
                Toast.makeText(MainActivity.this,"malo", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
