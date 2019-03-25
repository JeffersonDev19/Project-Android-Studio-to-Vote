package Repositories;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import java.util.List;

import Objeto.Voto;
import Servicos.SerializandoVotoToBson;

public class RepositorioVotocao {

    MongoClient mongoClient;
    DB bancoVotacao;
    DBCollection colecaoVotos;

    public RepositorioVotocao(){
        if(mongoClient == null) {
            this.mongoClient = ConnectionFactory.getInstance();
            this.bancoVotacao = mongoClient.getDB("nome do banco");
            this.colecaoVotos = bancoVotacao.getCollection("Usuario");
        }
    }

    public void SalvarUsuario(Voto voto){
        DBObject objetoSalvo = SerializandoVotoToBson.toDBObject(voto);
        colecaoVotos.insert(objetoSalvo);
    }

    public List<Voto> getTodosUsuarios(){
        List<Voto> listaVotos = null;
        for(int i = 0; i < colecaoVotos.count(); i++){
            listaVotos.add(SerializandoVotoToBson.toJavaObject(this.colecaoVotos.find()));
        }
        return listaVotos;
    }

    public Voto getVoto(String ID){
        DBObject query = new BasicDBObject("_id", ID);
        DBCursor cursor = colecaoVotos.find(query);
        return SerializandoVotoToBson.toJavaObject(cursor);
    }

    public void deletaUsuario(Voto voto){
        DBObject query = SerializandoVotoToBson.toDBObject(voto);
        colecaoVotos.remove(query);
    }

    public void atualizaUsuario(Voto voto){
        Voto buscador = getVoto(voto.getID());
        DBObject querySelector = SerializandoVotoToBson.toDBObject(voto);
        DBObject query = SerializandoVotoToBson.toDBObject(voto);
        colecaoVotos.update(querySelector, query);
    }
}
