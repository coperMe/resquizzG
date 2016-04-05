package com.adm.coper.resquizzgotham.POJO;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class Persist extends SQLiteOpenHelper {

    private SQLiteDatabase bd;
    private String [] cols = {"name","score"};

    /*constants*/
    public static final String DB_NAME = "resquizzgotham";
    public static final String SCRIPT = "Create table Scores (" +
            "_id integer primary key autoincrement,"
            +"name text not null," +
            "score integer not null)";


    public Persist(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        bd = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        /*crete table if not exists yet*/
        sqLiteDatabase.execSQL(SCRIPT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists Scores");
    }

    public void closeDataBase(){
        bd.close();
    }

    /*Operaciones CRUD*/
    public boolean add(String name, int score){
        ContentValues values = new ContentValues();
        values.put("name",name);
        values.put("score", score);

        return (bd.insert("Score","", values )>0);
    }

    public boolean delete(){
        bd.delete("Score", null, null);
        return true;
    }

    public ArrayList<Score> list(){
        /*select query*/
        Cursor c = bd.query("Score", cols, null, null, null, null, null);
        ArrayList<Score> scores = new ArrayList<Score>();
        c.moveToFirst();

        while(!c.isAfterLast()){
            scores.add(cursorToScore(c));
            c.moveToNext();
        }
        c.close();
        return scores;
    }

    private Score cursorToScore(Cursor c){
        Score res = null;
        String name = c.getString(c.getColumnIndex("name"));
        int score = c.getInt(c.getColumnIndex("score"));

        User aux = new User();
        aux.setName(name);
        res = new Score(aux, score);
        return res;
    }

}
