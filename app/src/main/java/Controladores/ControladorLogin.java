package Controladores;

import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import Objeto.Usuario;
import Repositories.RepositorioUsuario;

public class ControladorLogin {

    public static Usuario Login(EditText txtNome, EditText txtSenha){
        RepositorioUsuario repUsu = new RepositorioUsuario();
        List<Usuario> listaUsuario = repUsu.getTodosUsuarios();
        for(Usuario usuario : listaUsuario){
            if(usuario.getNome().equals(txtNome) && usuario.getSenha().equals(txtSenha)){
                return repUsu.getUsuario(txtNome.getText().toString());
            }
        }
        return null;
    }
}
