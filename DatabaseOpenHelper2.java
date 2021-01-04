package com.example.project2_skhanal7;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseOpenHelper2 extends SQLiteOpenHelper {


    static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + MainActivity.TABLE_NAME1 + " ("  +
                    MainActivity.ARTIST_NAME1+ " TEXT PRIMARY KEY," +
                    MainActivity.reps + " TEXT NOT NULL," +MainActivity.sets+ " TEXT NOT NULL,"+
                    MainActivity.weights+ " TEXT NOT NULL," + MainActivity.notes + " TEXT NOT NULL)";

    final static String NAME = "artist_db";
    final static Integer VERSION = 2;
    final Context context;



    public DatabaseOpenHelper2(Context context) {
        super(context, MainActivity.ARTIST_NAME1, null, 1);
        this.context = context;
    }

    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_ENTRIES);
        ContentValues cv = new ContentValues();
        cv.put(MainActivity.ARTIST_NAME1, "Do Push-ups");
        cv.put(MainActivity.reps,"2");
        cv.put(MainActivity.sets,"2");
        cv.put(MainActivity.weights,"0 lbs");
        cv.put(MainActivity.notes,"None");

        db.insert(MainActivity.TABLE_NAME1, null, cv);
        cv.put(MainActivity.ARTIST_NAME1, "Do bench press");
        cv.put(MainActivity.reps,"2");
        cv.put(MainActivity.sets,"2");
        cv.put(MainActivity.weights,"45 lbs");
        cv.put(MainActivity.notes,"None");

        db.insert(MainActivity.TABLE_NAME1, null, cv);
        cv.put(MainActivity.ARTIST_NAME1, "Do sit-ups");
        cv.put(MainActivity.reps,"2");
        cv.put(MainActivity.sets,"2");
        cv.put(MainActivity.weights,"0 lbs");
        cv.put(MainActivity.notes,"None");

        db.insert(MainActivity.TABLE_NAME1, null, cv);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        db.execSQL("DROP TABLE IF EXISTS " + MainActivity.TABLE_NAME1);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    void deleteDatabase() {
        context.deleteDatabase(MainActivity.TABLE_NAME1);
    }
}


