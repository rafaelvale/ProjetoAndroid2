package com.stg.achados.achadoseperdidos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


/**
 * Created by Diego on 16/08/2015.
 */
public class ActivityLogin extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);
    }

    public void CriarCadastro(View view){

        Intent intent = new Intent(this, ActivityTelaCadastro.class);
        startActivity(intent);
    }

    public void Acessar(View view){

        Intent intent = new Intent(this, ActivityHome.class);
        startActivity(intent);
    }

    public void APIGplus(View view){

    }

    public void APIFace(View view){

    }
}
