package com.example.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper
{
    public DBHelper(Context context)
    {
        super(context,
                "StudentDB",
                null,
                1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(
        "CREATE TABLE Student(" +
        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
        "name TEXT)");
    }

    @Override
    public void onUpgrade(
            SQLiteDatabase db,
            int oldVersion,
            int newVersion)
    {

    }

    public void insertData(String name)
    {
        SQLiteDatabase db =
                this.getWritableDatabase();

        ContentValues cv =
                new ContentValues();

        cv.put("name", name);

        db.insert("Student",
                null,
                cv);

        db.close();
    }
}