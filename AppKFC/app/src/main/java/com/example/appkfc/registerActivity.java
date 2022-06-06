package com.example.appkfc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appkfc.databinding.ActivityRegisterBinding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class registerActivity extends AppCompatActivity {
    EditText idUserRe, idPssRE;
    Button BsaveRR;
    ActivityRegisterBinding binding;

/*
    public class Main {

        public void main(String[] args) {

            // Patrón para validar el email


            if (mather.find() == true) {
                System.out.println("El email ingresado es válido.");
            } else {
                System.out.println("El email ingresado es inválido.");
            }
        }

    }
*/


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

        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        // El email a validar
        //correo = "info@gamil.com";

        Matcher mather = pattern.matcher(correo);
        if (mather.find() == true && !pass.equals("")){
            Toast.makeText(this, "Datos registrados", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(registerActivity.this, register2.class);
            intent.putExtra("correo",correo);
            intent.putExtra("pass",pass);
            startActivity(intent);
        }else{
            Toast.makeText(this, "correo incorrecto", Toast.LENGTH_SHORT).show();
        }

       /* if(correo.equals("")){
            Toast.makeText(this, "Debe ingresar correo", Toast.LENGTH_SHORT).show();
        }else{
            if (pass.equals("")){
                Toast.makeText(this, "debe ingresar password", Toast.LENGTH_SHORT).show();
            }
        }*/
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