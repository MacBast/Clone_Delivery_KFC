package com.example.appkfc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.appkfc.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    CardView cardView;
    private ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view= mainBinding.getRoot();

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
}
