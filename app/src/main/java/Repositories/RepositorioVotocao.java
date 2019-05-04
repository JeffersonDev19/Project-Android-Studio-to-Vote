package Repositories;


import android.content.ContentValues;
import android.content.Context;

import java.util.List;

import Objeto.Usuario;
import Objeto.Voto;

public class RepositorioVotocao {

    private final String TABLE_VOTOS = "Votacao";
    private DbGateway gw;

    public RepositorioVotocao(Context ctx) {
        gw = DbGateway.getInstance(ctx);
    }
    
    public void salvar(Voto voto){

        ContentValues cv = new ContentValues();

        cv.put("ID", voto.getID());
        cv.put("chapaPresidente", voto.getChapaPresidente());
        cv.put("chapaGovernador", voto.getChapaGovernador());
        cv.put("chapaDeputado", voto.getChapaDeputado());
        cv.put("ID_Usuario", voto.getID_Usuario());
        cv.put("data", voto.getData().toString());
    }

    public List<Voto> getTodos() {
        return (List<Voto>) gw.getDatabase().rawQuery("Select * From " + TABLE_VOTOS, null);
    }

    public Voto isVotou(Voto voto){
        return (Voto) gw.getDatabase().rawQuery("select * from " + TABLE_VOTOS + " where ID_Usuario = " + voto.getID_Usuario(), null);
    }

}
