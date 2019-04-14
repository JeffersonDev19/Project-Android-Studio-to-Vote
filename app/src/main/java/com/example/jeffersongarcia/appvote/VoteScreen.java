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

import java.util.Date;

import Objeto.Usuario;
import Objeto.Voto;
import Repositories.RepositorioUsuario;
import Repositories.RepositorioVotocao;

public class VoteScreen extends AppCompatActivity {

    EditText txtPresidente;
    EditText txtGovernador;
    EditText txtDeputado;
    Usuario usuario;
    Date data;
    RepositorioVotocao repVoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote_screen);
        //Intent it = getIntent();
        //String ID = it.getStringExtra("usuario");
        //RepositorioUsuario repUsu = new RepositorioUsuario();
        //repVoto = new RepositorioVotocao();
        //usuario = repUsu.getUsuario(ID);
        //txtDeputado = findViewById(R.id.txtDeputado);
        //txtGovernador = findViewById(R.id.txtGovernador);
        //txtPresidente = findViewById(R.id.txtPresidente);
        //data = new Date();
    }

    public void btnVotar(View view){
        /*Voto voto = new Voto();
        voto.setID(usuario.getID());
        voto.setChapaPresidente(txtPresidente.toString());
        voto.setChapaDeputado(txtDeputado.toString());
        voto.setChapaGovernador(txtGovernador.toString());
        voto.setID_Usuario(usuario.getID());
        voto.setData(data);*//*
        if(repVoto.isVotou(voto)){
            Toast.makeText(VoteScreen.this, "Você já votou!", Toast.LENGTH_SHORT).show();
        } else {*/
            //repVoto.SalvarVoto(voto);
            Toast.makeText(VoteScreen.this, "Seu voto foi computado com sucesso", Toast.LENGTH_SHORT).show();
        //}
    }

}