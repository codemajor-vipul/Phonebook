package com.example.hello.phonebook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity implements View.OnClickListener {
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Button b=(Button)v;
        if(b==b1)
        {
            Intent in=new Intent(MainActivity.this,Add.class);
            startActivity(in);
        }
        else
        {
            Intent in=new Intent(MainActivity.this,Search.class);
            startActivity(in);
        }


    }
}




