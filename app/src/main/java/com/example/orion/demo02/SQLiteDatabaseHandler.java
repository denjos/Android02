package com.example.orion.demo02;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.LinkedList;
import java.util.List;

public class SQLiteDatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="contactoDB";
    private static final String TABLE_NAME="Contacto";



    public SQLiteDatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATION_TABLE="create table contacto(codigo INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, alias TEXT, telefono TEXT)";
        db.execSQL(CREATION_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists contacto");
        this.onCreate(db);
    }
    public void insertarContacto(Contacto contacto)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("nombre",contacto.getNombre());
        values.put("alias",contacto.getAlias());
        values.put("telefono",contacto.getTelefono());
        db.insert("contacto",null,values);
        db.close();
    }
    public List<Contacto> listarContactos()
    {
        List<Contacto> lista= new LinkedList<Contacto>();
        String query="select * from contacto";
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(query,null);
        Contacto contacto=null;
        if (cursor.moveToFirst())
        {
            do{
                contacto=new Contacto();
                contacto.setCodigo(cursor.getInt(0));
                contacto.setNombre(cursor.getString(1));
                contacto.setAlias(cursor.getString(2));
                contacto.setTelefono(cursor.getString(3));
                lista.add(contacto);
            }
            while (cursor.moveToNext());
        }
        return lista;
    }
}
