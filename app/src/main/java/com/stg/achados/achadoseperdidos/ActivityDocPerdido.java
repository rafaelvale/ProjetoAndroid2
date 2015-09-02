package com.stg.achados.achadoseperdidos;

import android.app.Activity;
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
public class ActivityDocPerdido extends Activity {

    private ArrayAdapter<CharSequence> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_doc_perdido);

        Spinner spinner = (Spinner)findViewById(R.id.spinner);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        adapter.add("Selecione o documento");
        adapter.add("CARTÃO DE DÉBITO/CRÉDITO");
        adapter.add("CARTÃO DO CIDADÃO - CAIXA ECONÔMICA FEDERAL");
        adapter.add("CARTÃO NACIONAL DE SAÚDE");
        adapter.add("O PASSE ESCOLAR OU PASSE LIVRE");
        adapter.add("CARTEIRA DE IDENTIDADE PROFISSIONAL");
        adapter.add("CARTEIRA DO IDOSO");
        adapter.add("CDI CERTIFICADO DISPENSA E INCORPORACAO");
        adapter.add("CERTIDÃO (NASCIMENTO/CASAMENTO)");
        adapter.add("CERTIFICADO DE RESERVISTA");
        adapter.add("CGC/CNPJ");
        adapter.add("CNH CARTEIRA NACIONAL DE HABILITACAO");
        adapter.add("CONSELHO FEDERAL DE MEDICINA VETERINARIA");
        adapter.add("CONSELHO REGIONAL DE BIOLOGIA  - CRB");
        adapter.add("CONSELHO REGIONAL DE EDUCAÇÃO FÍSICA");
        adapter.add("CONSELHO REGIONAL DE FARMÁCIA");
        adapter.add("CPF/CIC");
        adapter.add("CRLV E DOCUMENTOS DE VEÍCULO");
        adapter.add("CTPS");
        adapter.add("DOCUMENTO DE IDENTIFICAÇÃO INDIGENA\n");
        adapter.add("DOCUMENTOS DE VEÍCULO\n");
        adapter.add("IDENTIDADE DE ADVOGADO\n");
        adapter.add("OUTROS");
        adapter.add("PASSAPORTE\n");
        adapter.add("PIS - PROGRAMA INTEGRAÇÃO SOCIAL\n");
        adapter.add("PORTE, REGISTRO E CERTIFICADO DE ARMAS\n");
        adapter.add("RG - REGISTRO GERAL\n");
        adapter.add("RNE - REGISTRO NACIONAL DE ESTRANGEIRO\n");
        adapter.add("TÍTULO DE ELEITOR\n");

        spinner.setAdapter(adapter);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    }

}
