package com.ritik.todolist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class user_database extends SQLiteOpenHelper {
    public static String dbName ="userData.db";
    public user_database(@Nullable Context context) {
        super(context, dbName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "create table users(id integer primary key autoincrement ,name text ,msg text)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists users");
        onCreate(sqLiteDatabase);
    }

    public boolean insert_data(String name ,String msg){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues c =new ContentValues();
        c.put("name",name);
        c.put("msg",msg);
        long r =db.insert("users",null,c);
        if (r==-1){
            return false;
        }else return true;
    }
    public boolean delete_data(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where name=?",new String[]{name});
        if (cursor.getCount()>0){
            long r =db.delete("users","name=?",new String[]{name});
            if (r==-1)return true;
            else return false;
        }

        return false;
    }

    public Cursor  getInfo(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from users",null);
        return cursor;
    }
}
