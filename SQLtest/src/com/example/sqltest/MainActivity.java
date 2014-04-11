
package com.example.sqltest;




import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class MainActivity extends Activity {

    Button insert;
    EditText et;
    String text;
    private Cursor myCursor;
    ListView lv;
    List<String> data;

    String TABLE_NAME="information";
    String COLUM_NAME="content";
    dbHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        insert=(Button)findViewById(R.id.button1);
        et=(EditText)findViewById(R.id.editText1);
        lv=new ListView(this);
        lv=(ListView)findViewById(R.id.listView1);
        List<String> data = new ArrayList<String>();
        db=new dbHelper(MainActivity.this);
        myCursor=db.select();
        SimpleCursorAdapter adpater=new SimpleCursorAdapter(this
                , R.layout.test, myCursor,
                new String[]{dbHelper.FIELD_TITLE},
                new int[]{R.id.topTextView});

        lv.setAdapter(adpater);


        insert.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                // TODO Auto-generated method stub
              text=et.getText().toString();
              db.insert( text);
              myCursor.requery();
              lv.invalidateViews();
              //adapter.add("text");
            }
        });

    }
}

