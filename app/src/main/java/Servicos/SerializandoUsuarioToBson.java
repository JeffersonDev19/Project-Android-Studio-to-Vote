package Servicos;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import java.util.Date;

import Objeto.Usuario;

public class SerializandoUsuarioToBson {

    public static final DBObject toDBObject(Usuario usuario){
        return new BasicDBObject("_id", usuario.getNome())
                .append("nome", usuario.getNome())
                .append("email", usuario.getEmail())
                .append("senha", usuario.getSenha())
                .append("CPF", usuario.getCPF())
                .append("cidade", usuario.getCidade())
                .append("data", usuario.getData())
                .append("permissao", usuario.getPermissao());
    }

    public static final Usuario toJavaObject(DBCursor cursor){
        Usuario usuario = new Usuario();
        usuario.setID((String)cursor.one().get("_id"));
        usuario.setNome((String)cursor.one().get("nome"));
        usuario.setEmail((String) cursor.one().get("email"));
        usuario.setSenha((String) cursor.one().get("senha"));
        usuario.setCPF((String)cursor.one().get("CPF"));
        usuario.setCidade((String)cursor.one().get("cidade"));
        usuario.setData((Date)cursor.one().get("data"));
        usuario.setPermissao((int)cursor.one().get("permissao"));
        return usuario;
    }
}
