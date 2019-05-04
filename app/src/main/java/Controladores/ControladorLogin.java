package Controladores;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.EditText;

import com.example.jeffersongarcia.appvote.R;

import java.text.ParseException;

import Objeto.Usuario;
import Repositories.RepositorioUsuario;

public class ControladorLogin {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static Usuario Login(View view, Usuario usuario) throws ParseException {
        RepositorioUsuario repUsu = new RepositorioUsuario(view.getContext());
        return repUsu.getLogin(usuario);
    }
}
