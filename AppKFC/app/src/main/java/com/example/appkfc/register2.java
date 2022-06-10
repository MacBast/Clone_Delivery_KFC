package com.example.appkfc;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.example.appkfc.Services.LoginService;
import com.example.appkfc.Services.RegisterService;
import com.example.appkfc.databinding.ActivityCompraBinding;
import com.example.appkfc.databinding.ActivityRegister2Binding;


import com.example.appkfc.models.ListProductsRequest1;
import com.example.appkfc.models.LoginRegistroRequest;
import com.example.appkfc.models.RegistroModel1;

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
                .baseUrl("http://34.234.64.174/features/").addConverterFactory(GsonConverterFactory.create())
                .build();

        binding.btncrearCuentaR2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(register2.this, "soy el boton", Toast.LENGTH_SHORT).show();
                /*LoginRegistroRequest usuario = new LoginRegistroRequest();
                usuario.set(correo);
                usuario.setPass(pass);
                RegisterService registro = retrofit.create(RegisterService.class);
                Call<String> register = registro.register(usuario);*/

            }
        });

    }

    public void register(View view){
        String correo,pass;

        String primer_registroC = getIntent().getExtras().getString("correo");
        String primer_registroP = getIntent().getExtras().getString("pass");

        correo = primer_registroC;
        pass = primer_registroP;

        LoginRegistroRequest usuario = new LoginRegistroRequest();
        usuario.setEmail(correo);
        usuario.setPass(pass);
        RegisterService registro = retrofit.create(RegisterService.class);
        Call<String> register = registro.register(usuario);
        register.enqueue(new Callback<String>() {
            @Override
                public void onResponse(Call<String> call, Response<String> response) {

                Toast.makeText(register2.this, response.body(), Toast.LENGTH_SHORT).show();
                //Intent intent = new Intent(register2.this,sesion.class);
                //startActivity(intent);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                    Toast.makeText(register2.this, "error"+t, Toast.LENGTH_SHORT).show();

            }
        });
    }

}