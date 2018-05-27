package com.cabrera.misnotas.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;


import com.cabrera.misnotas.Model.Person;

import java.util.ArrayList;
import java.util.List;


public class DBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME="bd_usuarios";
    public static final String TABLA_USUARIO="Persona";
    public static final String CAMPO_ID="carnet";
    public static final String CAMPO_NOTA="nota";
    public static final String CAMPO_MATERIA="materia";
    public static final String CAMPO_CATEDRATICO="catedratico";
    public static final String CREAR_TABLA_USUARIO="CREATE TABLE "+ TABLA_USUARIO +
            "("+CAMPO_ID+" TEXT,"
            +CAMPO_NOTA+" INTEGER,"
            +CAMPO_MATERIA+" TEXT,"
            +CAMPO_CATEDRATICO+" TEXT)";

    public static DBHelper myDB=null;
    private Context context;
    SQLiteDatabase db;

    public DBHelper(Context applicationContext) {
        super(applicationContext, DB_NAME, null, 1);
        this.context=applicationContext;
        db=this.getWritableDatabase();
    }

    public static DBHelper getInstance(Context ctx){
        if(myDB==null){
            myDB = new DBHelper(ctx.getApplicationContext());
        }
        return myDB;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREAR_TABLA_USUARIO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+CAMPO_ID);
        onCreate(db);
    }
    public boolean add(Person p){
        ContentValues values = new ContentValues();
        values.put(CAMPO_ID,p.getCarnet());
        values.put(CAMPO_NOTA,p.getNota());
        values.put(CAMPO_MATERIA,p.getMateria());
        values.put(CAMPO_CATEDRATICO,p.getCatedratico());
        db.insert(TABLA_USUARIO,null,values);
        Toast.makeText(context,"Insertado con exito", Toast.LENGTH_SHORT).show();
        return true;
    }
    public Person findUser(String carnet){
        Person p;
        String [] parametros = {carnet};
        String [] campos = {CAMPO_NOTA,CAMPO_MATERIA,CAMPO_CATEDRATICO};
        try {
            Cursor cursor = db.query(TABLA_USUARIO,campos,
                    CAMPO_ID+"=?",parametros,null,null,null);
            cursor.moveToFirst();
            p=new Person(carnet,cursor.getInt(0),
                    cursor.getString(1),cursor.getString(2));
        }
        catch (Exception e){
            Toast.makeText(context,"Usuario no encontrado", Toast.LENGTH_SHORT).show();
            p=null;
        }
        return p;
    }
    public List<Person> allUsers(){
        List<Person> elements = new ArrayList<>();
        String [] campos = {CAMPO_ID,CAMPO_NOTA,CAMPO_MATERIA,CAMPO_CATEDRATICO};
        Cursor cursor = db.query(TABLA_USUARIO,campos,
                null,null,null,null,null);
        Person p;
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                p=new Person(cursor.getString(0),cursor.getInt(1),
                        cursor.getString(2),cursor.getString(3));
                elements.add(p);
                cursor.moveToNext();
            }
        }
        return elements;
    }
    public boolean editUser(Person p){
        String [] parametros = {p.getCarnet()};
        ContentValues values = new ContentValues();
        values.put(CAMPO_NOTA,p.getNota());
        db.update(TABLA_USUARIO, values,CAMPO_ID+"=?",parametros);
        Toast.makeText(context,"Usuario Actualizado", Toast.LENGTH_SHORT).show();
        return true;
    }

}