package com.stg.achados.achadoseperdidos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ActivityTelaInicial extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

    }

    public void Entrar(View view){
        Intent intent = new Intent(this, ActivityLogin.class);
        startActivity(intent);
    }



}
