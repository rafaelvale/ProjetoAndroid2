package com.stg.achados.achadoseperdidos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Diego on 17/08/2015.
 */
public class ActivityTelaCadastro extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);
    }

    public void VoltarCad(View view){

        Intent intent = new Intent(this,ActivityLogin.class);
        startActivity(intent);
    }

    public void Cadastrar(View view) {
        //método para incluir no banco
    }
}
