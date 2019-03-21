package Servicos;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import java.util.Date;

import Objeto.Usuario;
import Objeto.Voto;

public class SerializandoVotoToBson {

    public static final DBObject toDBObject(Voto voto){
        return new BasicDBObject("_id", voto.getID())
                .append("id_usuario", voto.getID_Usuario())
                .append("presidente", voto.getChapaPresidente())
                .append("governador", voto.getChapaGovernador())
                .append("deputado", voto.getChapaDeputado())
                .append("data", voto.getData());
    }

    public static final Voto toJavaObject(DBCursor cursor){
        Voto voto = new Voto();
        voto.setID((String)cursor.one().get("_id"));
        voto.setID_Usuario((String)cursor.one().get("id_usuario"));
        voto.setChapaPresidente((Integer)cursor.one().get("presidente"));
        voto.setChapaGovernador((Integer)cursor.one().get("governador"));
        voto.setChapaDeputado((Integer)cursor.one().get("deputado"));
        return voto;
    }
}