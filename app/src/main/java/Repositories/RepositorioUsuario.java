package Repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.text.ParseException;
import java.util.List;

import Objeto.Usuario;

public class RepositorioUsuario {

    private final String TABLE_USUARIOS = "Usuario";
    private DbGateway gw;

    public RepositorioUsuario(Context ctx) {
        gw = DbGateway.getInstance(ctx);
    }

    public void salvar(Usuario usuario) {
        ContentValues cv = new ContentValues();
        cv.put("nome", usuario.getNome());
        cv.put("email", usuario.getEmail());
        cv.put("senha", usuario.getSenha());
        cv.put("CPF", usuario.getCPF());
        cv.put("cidade", usuario.getCidade());
        cv.put("data", usuario.getData().toString());
        cv.put("permissao", usuario.getPermissao());

        gw.getDatabase().insert(TABLE_USUARIOS, null, cv);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Usuario isExiste(Usuario usuario) throws ParseException {
        String sql = "select * from " + TABLE_USUARIOS + " where nome = ? and email = ?";
        Cursor cursor = gw.getDatabase().rawQuery(sql, new String[]{usuario.getNome(), usuario.getEmail()});
        usuario = preparaUsuario(cursor);
        if(usuario.getID() != null) {
            return usuario;
        } else {
            return null;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Usuario getLogin(Usuario usuario) throws ParseException {
        String sql2 = "select * from " + TABLE_USUARIOS;
        Cursor cursor2 = gw.getDatabase().rawQuery(sql2, null);
        usuario = preparaUsuario(cursor2);
        return usuario;
    }

    public void excluir(Usuario usuario) {
        gw.getDatabase().delete(TABLE_USUARIOS, "ID" + "='" + usuario.getID() + "'", null);
    }

    public void atualizar(Usuario usuario) {
        ContentValues cv = new ContentValues();
        cv.put("nome", usuario.getNome());
        cv.put("email", usuario.getEmail());
        cv.put("senha", usuario.getSenha());
        cv.put("CPF", usuario.getCPF());
        cv.put("cidade", usuario.getCidade());
        cv.put("data", usuario.getData().toString());

        gw.getDatabase().update(TABLE_USUARIOS, cv, "where ID =" + usuario.getID(), null);
    }

    public Usuario get(Usuario usuario) {
        ContentValues cv = new ContentValues();
        cv.put("nome", usuario.getNome());
        cv.put("email", usuario.getEmail());
        cv.put("senha", usuario.getSenha());
        cv.put("CPF", usuario.getCPF());
        cv.put("cidade", usuario.getCidade());
        cv.put("data", usuario.getData().toString());

        return (Usuario) gw.getDatabase().rawQuery("Select * From " + TABLE_USUARIOS + " where ID = " + usuario.getID(), null);
    }

    public List<Usuario> getTodos() {
        return (List<Usuario>) gw.getDatabase().rawQuery("Select * From " + TABLE_USUARIOS, null);
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public Usuario preparaUsuario(Cursor cursor) throws ParseException {
        Usuario usuario = new Usuario();

        while(cursor.moveToNext()){
            usuario.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            usuario.setEmail(cursor.getString(cursor.getColumnIndex("email")));
            usuario.setSenha(cursor.getString(cursor.getColumnIndex("senha")));
            usuario.setCPF(cursor.getString(cursor.getColumnIndex("CPF")));
            usuario.setCidade(cursor.getString(cursor.getColumnIndex("cidade")));
            usuario.setData(cursor.getString(cursor.getColumnIndex("data")));
            usuario.setPermissao(Integer.parseInt(cursor.getString(cursor.getColumnIndex("permissao"))));
        }
        cursor.close();
        return usuario;
    }
}