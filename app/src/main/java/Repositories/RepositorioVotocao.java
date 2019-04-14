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
            this.bancoVotacao = mongoClient.getDB("appVote");
            this.colecaoVotos = bancoVotacao.getCollection("Voto");
        }
    }

    public boolean isVotou(Voto voto){
        List<Voto> listaVoto = getTodosVotos();
        for(Voto votoConf : listaVoto){
            if(voto.getID_Usuario() == votoConf.getID_Usuario() && voto.getID() == votoConf.getID()){
                return true;
            }
        }
        return false;
    }

    public void SalvarVoto(Voto voto){
        DBObject objetoSalvo = SerializandoVotoToBson.toDBObject(voto);
        colecaoVotos.insert(objetoSalvo);
    }

    public List<Voto> getTodosVotos(){
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

}
