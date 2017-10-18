package com.hitchhikingapps.thesuggestionbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;


public class Startup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup);

        ImageView picture = (ImageView)findViewById(R.id.startup);

        picture.setImageResource(R.drawable.start);

    }

    public void suggestion(View view){

        finish();
        Intent departmentintent = new Intent(Startup.this, Department.class);
        Startup.this.startActivity(departmentintent);

    }

    public void fixed(View view){
        finish();
        Intent fixedintent = new Intent(Startup.this, Fixed.class);
        Startup.this.startActivity(fixedintent);

    }

    public void login(View view){
        finish();
        Intent loginintent = new Intent(Startup.this, Adminlogin.class);
        Startup.this.startActivity(loginintent);


    }




}
