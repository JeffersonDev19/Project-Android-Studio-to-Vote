package Controladores;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;

import com.example.jeffersongarcia.appvote.R;

import java.util.Date;

import Objeto.Usuario;
import Objeto.Voto;
import Repositories.RepositorioVotocao;

public class ControladorVoteScreen {

    public static Boolean isVotou(View view, Intent it){
        // Preparando o voto
        Voto voto;
        EditText txtIDUsuario;

        //Preenchendo
        voto = new Voto();
        String ID = it.getStringExtra("usuario");
        voto.setID_Usuario(ID);

        RepositorioVotocao repVoto = new RepositorioVotocao(view.getContext());
        if(repVoto.isVotou(voto) == null){
            return false;
        } else {
            return true;
        }
    }

    public static void SalvarVotacao(View view, Intent it){

        RepositorioVotocao repUsu = new RepositorioVotocao(view.getContext());

        String ID = it.getStringExtra("usuario");

        EditText txtPresidente;
        EditText txtGovernador;
        EditText txtDeputado;
        Date data;

        txtDeputado = view.findViewById(R.id.txtDeputado);
        txtGovernador = view.findViewById(R.id.txtGovernador);
        txtPresidente = view.findViewById(R.id.txtPresidente);
        data = new Date();

        Voto voto = new Voto();
        voto.setChapaPresidente(txtPresidente.getText().toString());
        voto.setChapaDeputado(txtDeputado.getText().toString());
        voto.setChapaGovernador(txtGovernador.getText().toString());
        voto.setID_Usuario(ID);
        voto.setData(data);
        repUsu.salvar(voto);
    }
}
