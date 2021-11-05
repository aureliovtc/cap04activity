package com.example.cap04_activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends DebugActivity{

        protected static final String TAG = "livro";
        protected void onStart(){
            super.onStart();
            Log.i(TAG, getClassName()+".onStart() chamado.");
        }
        protected void onRestart(){
            super.onRestart();
            Log.i(TAG, getClassName()+".onRestart() chamado.");
        }
        protected void onResume(){
            super.onResume();
            Log.i(TAG, getClassName()+".onResume() chamado.");
        }
        protected void onPause(){
            super.onPause();
            Log.i(TAG, getClassName()+"onPause() chamado.");
        }
        @Override
        protected void onSaveInstanceState(Bundle outState){
            super.onSaveInstanceState(outState);
            Log.i(TAG, getClassName()+".onSaveInstanceState() chamado.");
        }
        protected void onStop(){
            super.onStop();
            Log.i(TAG, getClassName()+".onStop() chamado.");
        }
        protected void onDestroy(){
            super.onDestroy();
            Log.i(TAG, getClassName()+".onDestroy() chamado.");
        }
        private String getClassName(){
            // Retorna o nome da classe sem o pacote
            String s = getClass().getName();
            return s.substring(s.lastIndexOf("."));
        }



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btLogin = (Button) findViewById(R.id.btLogin);
        btLogin.setOnClickListener(onClickLogin());
        }
        private View.OnClickListener onClickLogin(){
            return new View.OnClickListener(){
     @Override
     public void onClick(View v){
         TextView tLogin = (TextView) findViewById(R.id.tLogin);
         TextView tSenha = (TextView) findViewById(R.id.tSenha);
         String login = tLogin.getText().toString();
         String senha = tSenha.getText().toString();
         if("aurelio".equals(login) && "123".equals(senha)) {
             //Navega para a próxima tela
             Intent intent = new Intent(getContext(), BemVindoActivity.class);
             Bundle params = new Bundle();
             params.putString("nome", "Aurelio Carvalho");
             intent.putExtras(params);
             startActivity(intent);
         }else{
             alert("Login ou senha incorretos.");
                 }
        }

        };
    }
private Context getContext(){
            return this;
}
    private void alert(String s) {
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }
}

