package com.stg.achados.achadoseperdidos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

/**
 * Created by Diego on 17/08/2015.
 */
public class ActivityDocEncontrado extends Activity {

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

    }

    public void ConcCadDocEnc(View view){

        //metodo de inclusão no BD
    }



}
