package com.example.project2_skhanal7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class WorkEdit extends AppCompatActivity {
    TextView a;
    TextView d;
    TextView c;
    TextView b;
    TextView sd1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_edit);
        Intent kk = getIntent();
        String name1 = kk.getStringExtra("Item");
        a = findViewById(R.id.textView12);
        d = findViewById(R.id.textView13);
        c = findViewById(R.id.textView14);
        b = findViewById(R.id.textView15);
        sd1 = findViewById(R.id.textView16);
        DatabaseOpenHelper2 dbHelper = new DatabaseOpenHelper2(this);
        SQLiteDatabase db1 = dbHelper.getReadableDatabase();
        String selection = MainActivity.ARTIST_NAME1 + " = ?";
        String[] selectionArgs = { name1 };
        Cursor cursor = db1.query(
                MainActivity.TABLE_NAME1,
                null,
                selection,
                selectionArgs,
                null,
                null,
                null
        );
        cursor.moveToFirst();
        a.setText(name1);
        d.setText(cursor.getString(cursor.getColumnIndex(MainActivity.reps)));
        c.setText(cursor.getString(cursor.getColumnIndex(MainActivity.sets)));
        b.setText(cursor.getString(cursor.getColumnIndex(MainActivity.weights)));
        sd1.setText(cursor.getString(cursor.getColumnIndex(MainActivity.notes)));

    }
}
