package Repositories;

import android.text.Editable;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import java.util.List;

import Objeto.Usuario;
import Servicos.SerializandoUsuarioToBson;

public class RepositorioUsuario {

    MongoClient mongoClient;
    DB bancoVotacao;
    DBCollection colecaoUsuario;

    public RepositorioUsuario() {
        if (mongoClient == null) {
            this.mongoClient = ConnectionFactory.getInstance();
            this.bancoVotacao = mongoClient.getDB("appVote");
            this.colecaoUsuario = bancoVotacao.getCollection("Usuario");
        }
    }

    public void SalvarUsuario(Usuario usuario) {
        DBObject objetoSalvo = SerializandoUsuarioToBson.toDBObject(usuario);
        colecaoUsuario.insert(objetoSalvo);
    }

    public List<Usuario> getTodosUsuarios() {
        List<Usuario> listaUsuario = null;
        for (int i = 0; i < colecaoUsuario.count(); i++) {
            listaUsuario.add(SerializandoUsuarioToBson.toJavaObject(this.colecaoUsuario.find()));
        }
        return listaUsuario;
    }

    public boolean existeUsuario(String ID, String senha){
        List<Usuario> listaUsuario = this.getTodosUsuarios();
        for(Usuario usuario : listaUsuario){
            if(usuario.getID() == ID && usuario.getSenha() == senha){
                return true;
            }
        }
        return false;
    }

    public Usuario getUsuario(String ID) {
        DBObject query = new BasicDBObject("_id", ID);
        DBCursor cursor = colecaoUsuario.find(query);
        return SerializandoUsuarioToBson.toJavaObject(cursor);
    }

    public void deletaUsuario(Usuario usuario) {
        DBObject query = SerializandoUsuarioToBson.toDBObject(usuario);
        colecaoUsuario.remove(query);
    }

    public void atualizaUsuario(Usuario usuario) {
        Usuario buscador = getUsuario(usuario.getID());
        DBObject querySelector = SerializandoUsuarioToBson.toDBObject(usuario);
        DBObject query = SerializandoUsuarioToBson.toDBObject(usuario);
        colecaoUsuario.update(querySelector, query);
    }
}
