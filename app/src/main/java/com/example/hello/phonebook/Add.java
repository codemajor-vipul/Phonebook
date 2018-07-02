package com.example.hello.phonebook;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Add extends Activity {
TextView t1,t2,t3;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        t1=(TextView)findViewById(R.id.t1);
        t2=(TextView)findViewById(R.id.t2);
        t3=(TextView)findViewById(R.id.t3);
        b=(Button)findViewById(R.id.btn);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db=openOrCreateDatabase("mydb",MODE_PRIVATE,null);
                db.execSQL("create table if not exists phonebook(name varchar,pno varchar,email varchar)");
                String st="insert into phonebook values('"+t1.getText().toString()+"','"+t2.getText().toString()+"','"+t3.getText().toString()+"')";
                db.execSQL(st);
                Toast.makeText(Add.this,"saved",Toast.LENGTH_SHORT).show();
                db.close();
    }
        });
    }
}
