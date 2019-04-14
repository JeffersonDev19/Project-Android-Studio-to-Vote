package com.example.jeffersongarcia.appvote;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Timestamp;
import java.util.Date;

import Objeto.Usuario;
import Repositories.RepositorioUsuario;

import static java.lang.Integer.*;

public class MainActivity extends AppCompatActivity {

    Usuario usuario;
    EditText txtNome;
    EditText txtEmail;
    EditText txtSenha;
    EditText txtCPF;
    EditText txtCidade;
    Date date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnRegistrar(View view){
                usuario = new Usuario();
                txtNome = findViewById(R.id.txtNome);
                txtEmail = findViewById(R.id.txtEmail);
                txtSenha = findViewById(R.id.txtSenha);
                txtCPF = findViewById(R.id.txtCPF);
                txtCidade = findViewById(R.id.txtCidade);
                date = new Date();
                usuario.setID(txtNome.toString());
                usuario.setNome(txtNome.getText().toString());
                usuario.setEmail(txtEmail.toString());
                usuario.setSenha(txtSenha.toString());
                usuario.setCPF(txtCPF.toString());
                usuario.setCidade(txtCidade.toString());
                usuario.setData(date);
                usuario.setPermissao(0);
                /*
                RepositorioUsuario repUsu = new RepositorioUsuario();
                if(!repUsu.existeUsuario(usuario.getID(), usuario.getSenha())) {
                    repUsu.SalvarUsuario(usuario);
                    Intent it = new Intent(MainActivity.this, VoteScreen.class);
                    it.putExtra("usuario", usuario.getID());
                    startActivity(it);
                }
                */
                if(usuario.getNome().equals("gerson")){
                    Intent it = new Intent(MainActivity.this, Login.class);
                    it.putExtra("usuario", usuario.getNome());
                    startActivity(it);
                } else {
                    Toast.makeText(MainActivity.this, "Cadastro Incompleto", Toast.LENGTH_SHORT).show();
                }
    }

    public void btnCancelar(View view){
                txtNome.setText("");
                txtEmail.setText("");
                txtSenha.setText("");
                txtCidade.setText("");
                txtCPF.setText("");
                Intent it = new Intent(MainActivity.this, MainActivity.class);
                startActivity(it);
    }
}
