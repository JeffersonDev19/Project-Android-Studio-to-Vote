package Repositories;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Votacao.db";
    private static final int DATABASE_VERSION = 1;
    private final String CREATE_TABLE_USUARIO = "CREATE TABLE Usuario (ID INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT NOT NULL, email TEXT, senha TEXT NOT NULL, CPF INTEGER NOT NULL,cidade INTEGER NOT NULL,data TEXT NOT NULL, permissao INTEGER NOT NULL );";
    private final String CREATE_TABLE_VOTACAO = "CREATE TABLE Votacao (ID INTEGER PRIMARY KEY AUTOINCREMENT, chapaPresidente TEXT NOT NULL, chapaGovernador TEXT, chapaDeputado TEXT NOT NULL, ID_Usuario INTEGER NOT NULL, data TEXT NOT NULL);";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USUARIO);
        db.execSQL(CREATE_TABLE_VOTACAO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}