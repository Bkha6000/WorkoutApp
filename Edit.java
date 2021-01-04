package com.example.project2_skhanal7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Edit extends AppCompatActivity {
    final static String TABLE_NAME2 = "artists2";
    final static String ARTIST_NAME2 = "name2";
    final static String _ID2 = "_id2";
    final static String[] columns = {MainActivity._ID1,
            MainActivity.ARTIST_NAME1, MainActivity.reps, MainActivity.sets, MainActivity.weights};
    String[] print_columns = {MainActivity.ARTIST_NAME1};
    private SQLiteDatabase db = null;
    private DatabaseOpenHelper2 dbHelper = null;
    public ListView lis;
    ArrayAdapter<String> myada;
    public SimpleCursorAdapter myAdapter;
    public SimpleCursorAdapter myAdapter1;
    Cursor mCursor;
    Cursor mCursor1;
    Button ada;
    Button ada1;
    EditText mtext;
    ArrayList artt;
    //int a =R.layout.info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        ArrayList<String> jon = new ArrayList<String>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        dbHelper = new DatabaseOpenHelper2(this);
        lis = findViewById(R.id.Liss);
        Intent bv1 = getIntent();
        final String fd1 = bv1.getStringExtra("Tie");

        ada = findViewById(R.id.button3);
        if(fd1!= null &&fd1.equals("1")){
            ada.setVisibility(View.INVISIBLE);
        }
        myada = new ArrayAdapter<String>(this, R.layout.info);
        lis.setAdapter(myada);
        lis.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getApplicationContext(), "Item " + ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
                TextView gh = ((TextView) view);
                String p = (String) gh.getText();
                /*System.out.println("hahahahahhahahhahahhahah");*/


                Intent ia = new Intent(getApplicationContext(), ExerciseEdit.class);
                ia.putExtra("Item name", p);
                if(fd1 != null &&fd1.equals("1")){
                    Intent iaa = new Intent(getApplicationContext(), WorkEdit.class);
                    iaa.putExtra("Item",p);
                    startActivityForResult(iaa,1);

                }



                else{
                    ia.putExtra("Type",0);
                    startActivityForResult(ia, 1);

                }




            }

        });

        lis.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                                           public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                                               TextView gh = ((TextView) view);
                                               String p = (String) gh.getText();


                                               db.delete(MainActivity.TABLE_NAME1,"name1 = ?",new String[]{p});

                                               myada.remove(p);
                                               return true;
                                           }
                                       }
        );
        db = dbHelper.getWritableDatabase();
        Cursor  cursor = db.rawQuery("select * from " + MainActivity.TABLE_NAME1,null);


        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                String name = cursor.getString(cursor.getColumnIndex(MainActivity.ARTIST_NAME1));

                if(!jon.contains(name)){
                    myada.add(name);

                }

                cursor.moveToNext();
            }
        }


    }

    public void onclick(View V) {
        Intent intent = new Intent(this, ExerciseEdit.class);
        intent.putExtra("Type", 1);
        startActivityForResult(intent, 1);
    }



    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == 1) {
                String joh = data.getStringExtra("Name");
                myada.add(joh);


            }

        }
    }
}














