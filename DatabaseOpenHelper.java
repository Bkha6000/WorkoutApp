package com.example.project2_skhanal7;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseOpenHelper extends SQLiteOpenHelper {




    final static String NAME = "artist_db";
    final static Integer VERSION = 2;
    final Context context;

    public DatabaseOpenHelper(Context context) {
        super(context, MainActivity.ARTIST_NAME, null, 1);
        this.context = context;
    }

    public void onCreate(SQLiteDatabase db) {

        /*db.execSQL(CREATE_CMD);
        ContentValues cv = new ContentValues();
        cv.put(MainActivity.ARTIST_NAME, "Ride Bike");

        db.insert(MainActivity.TABLE_NAME, null, cv);
        cv.put(MainActivity.ARTIST_NAME, "Do squats");

        db.insert(MainActivity.TABLE_NAME, null, cv);
        cv.put(MainActivity.ARTIST_NAME, "Do Bench Presses");

        db.insert(MainActivity.TABLE_NAME, null, cv);*/

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        //db.execSQL("DROP TABLE IF EXISTS " + MainActivity.TABLE_NAME);
        //onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //onUpgrade(db, oldVersion, newVersion);
    }

    void deleteDatabase() {
        //context.deleteDatabase(MainActivity.TABLE_NAME);
    }
}

