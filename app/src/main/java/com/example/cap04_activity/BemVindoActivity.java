package com.example.cap04_activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class BemVindoActivity extends DebugActivity{
@Override
    protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_bem_vindo); //Layout desta activity
    //Recebe o nome enviado por parâmetro
    Bundle args = getIntent().getExtras();
    String nome = args.getString("nome");
    //vamos atualizar o texto do TextView com uma mensagem de bem-vindo
    TextView text = (TextView) findViewById(R.id.text);
    text.setText(nome + ", seja bem-vindo");
    // Adiciona o botão "up navigation"
    getActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
    int id = item.getItemId();
    if(id == android.R.id.home){
        //o método finish() vai encerrar essa activity
        finish();
        return true;
    }
    return super.onOptionsItemSelected(item);
    }
}
