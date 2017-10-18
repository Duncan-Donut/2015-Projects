package com.hitchhikingapps.thesuggestionbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

public class Fixed extends AppCompatActivity {

    MyDBHandler dbHandler;
    GridView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixed);
        lv = (GridView) findViewById(R.id.gridView);
        dbHandler = new MyDBHandler(this,null,null,1);

        printDatabase();
    }

    public void back (View view){

        finish();
        Intent fixerintent = new Intent(Fixed.this, Startup.class);
        Fixed.this.startActivity(fixerintent);

    }
    public void printDatabase(){

        String[] arr = dbHandler.databaseToString();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr);
        lv.setAdapter(adapter);

    }





}
