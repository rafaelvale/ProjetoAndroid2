package com.stg.achados.achadoseperdidos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
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
public class ActivityDocEncontrado extends Activity {

 Button btnConcCadDocEnc;
   EditText editTextNumero;
    EditText editTextNome;
    EditText editTextOBS;


    public void IrParaOMapa(View view){
        Intent intent = new Intent(this, AchouMaps.class);
        startActivity(intent);
    }

    private ArrayAdapter<CharSequence> adapter;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_doc_encontrado);

        Spinner spinner = (Spinner)findViewById(R.id.spinner);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        adapter.add("Selecione o documento");
        adapter.add("CARTÃO DO CIDADÃO");
        adapter.add("CARTÃO NACIONAL DE SAÚDE");
        adapter.add("CARTEIRA DO IDOSO");
        adapter.add("CERTIDÃO (NASCIMENTO/CASAMENTO)");
        adapter.add("CERTIFICADO DE RESERVISTA");
        adapter.add("CNPJ");
        adapter.add("CNH CARTEIRA NACIONAL DE HABILITACAO");
        adapter.add("CPF");
        adapter.add("CRLV E DOCUMENTOS DE VEÍCULO");
        adapter.add("CTPS");
        adapter.add("DOCUMENTO DE IDENTIFICAÇÃO INDIGENA\n");
        adapter.add("IDENTIDADE DE ADVOGADO\n");
        adapter.add("OUTROS");
        adapter.add("PASSAPORTE\n");
        adapter.add("RG - REGISTRO GERAL\n");
        adapter.add("RNE - REGISTRO NACIONAL DE ESTRANGEIRO\n");
        adapter.add("TÍTULO DE ELEITOR\n");



        spinner.setAdapter(adapter);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        btnConcCadDocEnc =(Button)findViewById(R.id.btnConcCadDocEnc);
        editTextNome =(EditText)findViewById(R.id.editTextNome);
        editTextNumero =(EditText)findViewById(R.id.editTextNumero);
        editTextOBS =(EditText)findViewById(R.id.editTextOBS);
    }

    public void ConcCadDocEnc(View view){

        Thread thread = new Thread(){
            String resultado;
            @Override
            public void run(){
                String Namespace="http://STG/WEBSERVICE";
                String url="http://achadosperdidoshomo.azurewebsites.net/WebService_App.asmx";
                String metodo="CadastrarDocumento";
                String soap="http://STG/WEBSERVICE/CadastrarDocumento";


                SoapObject soapObject = new SoapObject(Namespace,metodo);
                soapObject.addProperty("Descricao",editTextOBS.getText().toString());
                soapObject.addProperty("NumeroDocumento", editTextNumero.getText().toString());
                //soapObject.addProperty("NumeroDocumentoAlternativo",.getText().toString());
                soapObject.addProperty("Nome",editTextNome.getText().toString());
                soapObject.addProperty("Tipo","AD");

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
                        Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();


                    }
                });
            }

        };

        thread.start();


    }



}
