package Controladores;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jeffersongarcia.appvote.Login;
import com.example.jeffersongarcia.appvote.MainActivity;
import com.example.jeffersongarcia.appvote.R;
import com.example.jeffersongarcia.appvote.VoteScreen;

import java.text.ParseException;
import java.util.Date;

import Objeto.Usuario;
import Repositories.RepositorioUsuario;

public class ControladorCadastro {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static Boolean Salvar(View view, Usuario usuario) throws ParseException {
        RepositorioUsuario repUsu = new RepositorioUsuario(view.getContext());
        if (repUsu.isExiste(usuario) == null) {
            repUsu.salvar(usuario);
            return true;
        } else {
            return false;
        }
    }
}
