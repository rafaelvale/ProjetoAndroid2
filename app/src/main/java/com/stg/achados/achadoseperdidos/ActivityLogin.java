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
 * Created by Diego on 16/08/2015.
 */
public class ActivityLogin extends Activity{


    EditText edtCPF;
    EditText edtSenha;
    EditText edtNome;

    Button btnCadastrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);
        edtCPF = (EditText)findViewById(R.id.edtCPF);
        edtSenha = (EditText)findViewById(R.id.edtSenha);
        btnCadastrar = (Button)findViewById(R.id.btnCadastrar);
        edtNome = (EditText)findViewById(R.id.edtNome);


    }

    public void Acessar(View view){

        if(edtCPF.getText().length()==0 || edtSenha.getText().length()==0){
            Toast.makeText(getApplication(),"Favor informar CPF e senha",Toast.LENGTH_SHORT).show();


        }else {

            Thread thread = new Thread() {
                String resultado;

                @Override
                public void run() {
                    String Namespace = "http://STG/WEBSERVICE";
                    String url = "http://webservicestg.azurewebsites.net/WebService_App.asmx";
                    String metodo = "BuscarUsuario";
                    String soap = "http://STG/WEBSERVICE/BuscarUsuario";


                    SoapObject soapObject = new SoapObject(Namespace, metodo);
               //     soapObject.addProperty("Nome", edtNome.getText().toString());
                    soapObject.addProperty("cpf", edtCPF.getText().toString());
                    soapObject.addProperty("senha", edtSenha.getText().toString());

                    SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                    envelope.dotNet = true;

                    envelope.setOutputSoapObject(soapObject);

                    HttpTransportSE transportSE = new HttpTransportSE(url);
                    try {
                        transportSE.call(soap, envelope);
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
                            Toast.makeText(getApplicationContext(), "Bem vindo, " + resultado, Toast.LENGTH_SHORT).show();
                            //Toast.makeText(getApplicationContext(), "CPF " + edtCPF.getText().toString(), Toast.LENGTH_LONG).show();

                        }
                    });
                }

            };
            thread.start();

            Intent intent = new Intent(this, ActivityHome.class);
            startActivity(intent);
        }
    }



    public void CriarCadastro(View view){

        Intent intent = new Intent(this, ActivityTelaCadastro.class);
        startActivity(intent);
    }


}
