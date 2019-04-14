package com.example.jeffersongarcia.appvote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Controladores.ControladorLogin;
import Objeto.Usuario;
import Repositories.RepositorioUsuario;

public class Login extends AppCompatActivity {

    EditText txtNome;
    EditText txtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtNome =  findViewById(R.id.txtLogin);
        txtSenha = findViewById(R.id.txtSenha);
    }

    public void btnLogin(View view){
       // if(ControladorLogin.Login(txtNome,txtSenha) != null){
            Toast.makeText(Login.this, "Ola, seja bem vindo " + txtNome.getText().toString(), Toast.LENGTH_SHORT).show();
       //     RepositorioUsuario repUsu = new RepositorioUsuario();
       //     Usuario usuario = repUsu.getUsuario(txtNome.toString());
            txtNome.setText("");
            txtSenha.setText("");
            Intent it = new Intent(Login.this, VoteScreen.class);
            //it.putExtra("usuario", "gerson");
            startActivity(it);
      /*  } else {
            Toast.makeText(Login.this, "O login foi negado, tente novamente", Toast.LENGTH_SHORT).show();
        }*/
    }

    public void btnCadastrar(View view){
        Intent it = new Intent(Login.this, MainActivity.class);
        startActivity(it);
    }
}
