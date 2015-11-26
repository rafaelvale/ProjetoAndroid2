package com.stg.achados.achadoseperdidos;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Diego on 17/08/2015.
 */
public class ActivityHome extends Activity {
    Button btnSair;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_home);

        btnSair = (Button)findViewById(R.id.btnSair);

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(ActivityHome.this);
                alertDialog.setTitle("Logout");
                alertDialog.setMessage("Você realmente sair desta conta?");



                alertDialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"Até breve...", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(ActivityHome.this, ActivityTelaInicial.class);
                        startActivity(intent);

                    }

                });
                alertDialog.setNegativeButton("Não", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"Ok,vamos continuar...", Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });
                alertDialog.show();



            }
        });

    }

    public void onBackPressed()  {

    }

    public void Achou(View view){
        Intent intent = new Intent(this, ActivityDocEncontrado.class);
        startActivity(intent);
    }

    public void Perdeu(View view){
        Intent intent = new Intent(this, ActivityDocPerdido.class);
        startActivity(intent);
    }
}
