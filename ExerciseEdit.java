package com.example.project2_skhanal7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class ExerciseEdit extends AppCompatActivity {
    EditText a;
    EditText d;
    EditText c;
    EditText b;
    EditText sd1;
    public SimpleCursorAdapter myAdapter;
    private SQLiteDatabase db = null;
    private DatabaseOpenHelper2 dbHelper = null;
    String r;
    String r1;
    String r2;
    String r3;
    String sd;
    Cursor cursor;
    String ads;
    String yt1;
    int yu;
    final static String[] columns = { MainActivity._ID1,
            MainActivity.ARTIST_NAME1,MainActivity.reps,MainActivity.sets,MainActivity.weights };
    String[] print_columns = { MainActivity.ARTIST_NAME1};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_edit);
        Intent in = getIntent();
        yt1 = in.getStringExtra("Item name");

        ads = in.getStringExtra("Item name");
        a = findViewById(R.id.editText);
        d = findViewById(R.id.editText4);
        c = findViewById(R.id.editText2);
        b = findViewById(R.id.editText3);
        sd1 = findViewById(R.id.editText5);
        dbHelper = new DatabaseOpenHelper2(this);
        db = dbHelper.getWritableDatabase();
        yu = in.getIntExtra("Type",0);
        if(yu==1){


        }
        else if(yu==0){
            yt1 = in.getStringExtra("Item name");
            a.setVisibility(View.INVISIBLE);
            SQLiteDatabase db1 = dbHelper.getReadableDatabase();
            String selection = MainActivity.ARTIST_NAME1 + " = ?";
            String[] selectionArgs = { yt1 };
            Cursor cursor = db.query(
                    MainActivity.TABLE_NAME1,
                    null,
                    selection,
                    selectionArgs,
                    null,
                    null,
                    null
            );
            cursor.moveToFirst();
            d.setText(cursor.getString(cursor.getColumnIndex(MainActivity.reps)));
            c.setText(cursor.getString(cursor.getColumnIndex(MainActivity.sets)));
            b.setText(cursor.getString(cursor.getColumnIndex(MainActivity.weights)));
            sd1.setText(cursor.getString(cursor.getColumnIndex(MainActivity.notes)));
        }
        else{

        }
    }
    public void updateE(View v){


        if(yu == 1) {
            String s = a.getText().toString();
            String sa = d.getText().toString();
            String saa = c.getText().toString();
            String saaa = b.getText().toString();
            String y1 = sd1.getText().toString();

        /*db.delete(MainActivity.TABLE_NAME1,"name1 = ?",new String[] {r});
        db.delete(MainActivity.TABLE_NAME1,"name1 = ?",new String[] {r1});
        db.delete(MainActivity.TABLE_NAME1,"name1 = ?",new String[] {r2});
        db.delete(MainActivity.TABLE_NAME1,"name1 = ?",new String[] {r3});*/
            Cursor ty = db.rawQuery("select * from " + MainActivity.TABLE_NAME1 + " where " + MainActivity.ARTIST_NAME1 + "= ?", new String[]{s});
            Log.d("Cursor",ty.getCount()+"");
            if (ty.getCount() > 0) {
                //Intent ia = new Intent(this, Edit.class);
                //ia.putExtra("Name", s);
                //ia.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                //setResult(1, ia);
                Toast.makeText(getApplicationContext(), "Duplicate Item" + s, Toast.LENGTH_SHORT).show();

                finish();
            }
            else {

                ContentValues cv = new ContentValues();
                if(s.equals("")){
                    Toast.makeText(getApplicationContext(), "Exercise needs name!!" , Toast.LENGTH_SHORT).show();
                    return;
                }
                cv.put(MainActivity.ARTIST_NAME1, s);
                cv.put(MainActivity.reps, sa);
                cv.put(MainActivity.sets, saa);
                cv.put(MainActivity.weights, saaa);
                cv.put(MainActivity.notes, y1);
                db.insert(MainActivity.TABLE_NAME1, null, cv);
                Intent ia = new Intent(this, Edit.class);
                ia.putExtra("Name", s);
                ia.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                setResult(1, ia);
                finish();


            }
        }
        else{
            db.delete(MainActivity.TABLE_NAME1,"name1 = ?",new String[]{ads});

            String sa = d.getText().toString();
            String saa = c.getText().toString();
            String saaa = b.getText().toString();
            String y1 = sd1.getText().toString();


            ContentValues cv = new ContentValues();
            cv.put(MainActivity.ARTIST_NAME1,ads);
            cv.put(MainActivity.reps,sa);
            cv.put(MainActivity.sets,saa);
            cv.put(MainActivity.weights,saaa);
            cv.put(MainActivity.notes,y1);
            db.insert(MainActivity.TABLE_NAME1,null,cv);
            /*Intent ia = new Intent(this, Edit.class);
            ia.putExtra("Name", ads);
            ia.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            setResult(1, ia);*/
            finish();

        }



    }
    public void oncancel(View g){

        Intent iaa = new Intent(this, Edit.class);
        iaa.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);


        setResult(RESULT_OK, iaa);
        startActivity( iaa);
    }
    public void onBackPressed(View g){
        Intent ia = new Intent(this, Edit.class);
        ia.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);


        setResult(RESULT_OK, ia);
        startActivity( ia );
    }

}
