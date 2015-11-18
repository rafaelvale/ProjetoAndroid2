package com.stg.achados.achadoseperdidos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * Created by Diego on 16/08/2015.
 */
public class ActivityLogin extends Activity{


    EditText edtNome;
    EditText edtSenha;
    Button btnCadastrar;
    //variavel para validar os dados do formulario
    Boolean camposValidados;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);
        edtNome = (EditText)findViewById(R.id.edtNome);
        edtSenha = (EditText)findViewById(R.id.edtSenha);
        btnCadastrar = (Button)findViewById(R.id.btnCadastrar);

        //Programando o botao cadastrar
        btnCadastrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                camposValidados = true;

                if(edtNome.getText().length()==0 || edtSenha.getText().length()==0){
                    Toast.makeText(getApplication(),"Favor informar usuário e senha",Toast.LENGTH_LONG).show();

                    camposValidados = false;
                }else{

                    Toast.makeText(getApplication(),"Seja Bem Vindo "+edtNome.getText().toString()+"!",Toast.LENGTH_LONG).show();

                    edtNome.setText("");
                    edtSenha.setText("");

                    Intent intent = new Intent(ActivityLogin.this, ActivityHome.class);
                    startActivity(intent);

                }
                if(camposValidados){
                    Toast.makeText(getApplication(),"Usuário Autenticado com Sucesso!",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(ActivityLogin.this, ActivityHome.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(getApplication(),"Dados Inválidos!",Toast.LENGTH_LONG).show();


                }
            }
        });
    }



    public void CriarCadastro(View view){

        Intent intent = new Intent(this, ActivityTelaCadastro.class);
        startActivity(intent);
    }


}
