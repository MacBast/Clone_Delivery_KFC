package com.example.appkfc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appkfc.Services.LoginService;
import com.example.appkfc.databinding.ActivityRegisterBinding;
import com.example.appkfc.models.LoginModel;
import com.example.appkfc.models.LoginRequest;

import java.lang.reflect.Array;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class registerActivity extends AppCompatActivity {
    EditText idUserRe, idPssRE;
    Button BsaveRR;
    ActivityRegisterBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        View view =binding.getRoot();
        setContentView(view);

        idUserRe=findViewById(R.id.edtxcorreoregistro);
        idPssRE=findViewById(R.id.edtxpassregistro);

        BsaveRR= findViewById(R.id.button_continuar);

        BsaveRR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });

    }



    public void loginUser(){

        String pass,correo;

        pass= binding.edtxpassregistro.getText().toString();
        correo= binding.edtxcorreoregistro.getText().toString();

        if(correo.equals("")){
            Toast.makeText(this, "Debe ingresar correo", Toast.LENGTH_SHORT).show();
        }else{
            if (pass.equals("")){
                Toast.makeText(this, "debe ingresar password", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "Datos registrados", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(registerActivity.this, register2.class);
                intent.putExtra("correo",correo);
                intent.putExtra("pass",pass);
                startActivity(intent);
            }
        }
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

    public void  register2 (View view) {
        Intent register2 = new Intent(this, register2.class);
        startActivity(register2);
    }





}