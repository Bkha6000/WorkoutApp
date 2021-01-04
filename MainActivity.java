package com.example.project2_skhanal7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button but;
    Button but1;
    final static String TABLE_NAME = "artists";
    final static String ARTIST_NAME = "name";


    String[] print_columns = { ARTIST_NAME};
    private SQLiteDatabase db = null;
    private DatabaseOpenHelper2 dbHelper = null;
    final static String TABLE_NAME1 = "artists1";
    final static String ARTIST_NAME1 = "name1";
    final static String _ID1 = "_id1";
    final static String reps = "reps1";
    final static String sets = "sets1";
    final static String weights = "weights1";
    final static String notes = "notes1";
    final static String[] columns = { _ID1,
            ARTIST_NAME};
    final static String[] columns1 = { _ID1,
            ARTIST_NAME1,reps,sets,weights };
    String[] print_columns1 = { ARTIST_NAME};
    private SQLiteDatabase db1 = null;
    private DatabaseOpenHelper dbHelper1 = null;
    public ListView lis;
    public SimpleCursorAdapter myAdapter;
    public SimpleCursorAdapter myAdapter1;
    Cursor mCursor;
    Cursor mCursor1;
    Button ada;
    Button ada1;
    EditText mtext;
    ArrayList artt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        but = findViewById(R.id.button);
        but1 = findViewById(R.id.button2);
        dbHelper = new DatabaseOpenHelper2(this);
        db = dbHelper.getWritableDatabase();
    }

    public void buttonClick(View v){
        Intent intent = new Intent(this, Edit.class);
        intent.putExtra("Tie","0");
        startActivityForResult(intent,1);



    }
    public void buttonClick1(View v){
        Intent intent = new Intent(this, Edit.class);
        intent.putExtra("Tie","1");
        startActivityForResult(intent,1);



    }
}
