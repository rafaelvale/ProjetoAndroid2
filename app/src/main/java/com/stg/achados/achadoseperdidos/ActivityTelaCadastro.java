package com.stg.achados.achadoseperdidos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;

import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;


/**
 * Created by Diego on 17/08/2015.
 */
public class ActivityTelaCadastro extends Activity {

   EditText edtNome;
   EditText edtCPF;
    EditText edtEmail;
    EditText edtConfEmail;
    EditText edtSenha;
    EditText edtConfSenha;
    Button btnCadastrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        edtConfEmail = (EditText)findViewById(R.id.edtConfEmail);
        edtConfSenha = (EditText)findViewById(R.id.edtConfSenha);
        btnCadastrar = (Button)findViewById(R.id.btnCadastrar);

    }

    public void VoltarCad(View view){

        Intent intent = new Intent(this,ActivityLogin.class);
        startActivity(intent);
    }

    public void Cadastrar(View view) {

        edtNome = (EditText)findViewById(R.id.edtNome);
        edtCPF = (EditText)findViewById(R.id.edtCPF);
        edtEmail = (EditText)findViewById(R.id.edtEmail);
        edtSenha = (EditText)findViewById(R.id.edtSenha);

        if(edtNome.getText().length()==0 || edtCPF.getText().length()==0 ||
                edtEmail.getText().length()==0 || edtConfEmail.getText().length()==0 || edtConfSenha.getText().length()==0
                || edtSenha.getText().length()==0){

            Toast.makeText(getApplication(),"Favor informar todos os campos",Toast.LENGTH_SHORT).show();
        }

        Thread thread = new Thread(){
            String resultado;
            @Override
            public void run(){
                String Namespace="http://STG/WEBSERVICE";
                String url="http://webservicestg.azurewebsites.net/WebService_App.asmx";
                String metodo="CadastrarUsuario";
                String soap="http://STG/WEBSERVICE/CadastrarUsuario";


                SoapObject soapObject = new SoapObject(Namespace,metodo);
                soapObject.addProperty("Nome", edtNome.getText().toString());
                soapObject.addProperty("CPF", edtCPF.getText().toString());
                soapObject.addProperty("Email",edtEmail.getText().toString());
                soapObject.addProperty("Senha",edtSenha.getText().toString());

                SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                envelope.dotNet=true;

                envelope.setOutputSoapObject(soapObject);

                HttpTransportSE transportSE = new HttpTransportSE(url);
                try {
                    transportSE.call(soap,envelope);
                    SoapPrimitive res = (SoapPrimitive) envelope.getResponse();
                    resultado = res.toString();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),resultado, Toast.LENGTH_SHORT).show();
                        Toast.makeText(getApplicationContext(),"CPF "+ edtCPF.getText().toString(), Toast.LENGTH_SHORT).show();

                    }
                });
            }

        };

        thread.start();

        Intent intent = new Intent(this, ActivityLogin.class);
        startActivity(intent);
    }

}

