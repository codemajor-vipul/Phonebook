package com.example.hello.phonebook;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class Search extends Activity {
LinearLayout ll;
    EditText tt;
    public void fill()
    {
        String str="select * from phonebook";
        SQLiteDatabase db=openOrCreateDatabase("mydb",MODE_PRIVATE,null);
        Cursor c=db.rawQuery(str,null);
        if(c.moveToFirst())
        {
            do {
                TextView ttt = new TextView(this);
                ttt.setText(c.getString(0));
                ttt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(Search.this,"Clicked",Toast.LENGTH_SHORT).show();
                      TextView t1=(TextView)v;
                      Toast.makeText(Search.this,"Clicked"+t1.getText().toString(),Toast.LENGTH_SHORT).show();
                     Intent in=new Intent(Search.this,Details.class);
                        in.putExtra("name",t1.getText().toString());
                        startActivity(in);
                    }
                });
                ll.addView(ttt);

            }while(c.moveToNext());
        }
        else
        {
            Toast.makeText(Search.this,"finished",Toast.LENGTH_SHORT).show();

        }
        db.close();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ll=(LinearLayout)findViewById(R.id.ll);
        tt=(EditText)findViewById(R.id.tt);
        fill();
    }



}
