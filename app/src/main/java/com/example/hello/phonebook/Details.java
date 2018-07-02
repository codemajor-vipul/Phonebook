package com.example.hello.phonebook;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class Details extends Activity {
    TextView tv;
    public void fill(String name)
    {
        String str="select * from phonebook where name='"+name+"'";
        SQLiteDatabase db=openOrCreateDatabase("mydb",MODE_PRIVATE,null);
        Cursor c=db.rawQuery(str,null);
        c.moveToFirst();
        tv.setText(c.getString(0)+"\n"+c.getString(1)+"\n"+c.getString(2));
        Toast.makeText(Details.this,"details shown",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        tv=(TextView)findViewById(R.id.t_details);
        Intent in=getIntent();
        String str1=in.getStringExtra("name");
        fill(str1);
        registerForContextMenu(tv);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater m=getMenuInflater();
        m.inflate(R.menu.context,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.cm1)
        {

            SQLiteDatabase db=openOrCreateDatabase("mydb",MODE_PRIVATE,null);

        }
        return super.onContextItemSelected(item);

    }
}
