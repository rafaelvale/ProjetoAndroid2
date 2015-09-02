package com.stg.achados.achadoseperdidos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
/**
 * Created by Diego on 17/08/2015.
 */
public class ActivityHome extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_home);

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
