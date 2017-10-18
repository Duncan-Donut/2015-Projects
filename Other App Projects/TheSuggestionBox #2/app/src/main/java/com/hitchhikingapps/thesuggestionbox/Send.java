package com.hitchhikingapps.thesuggestionbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Send extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);


        ImageView picture = (ImageView)findViewById(R.id.send);

        picture.setImageResource(R.drawable.sent);

    }

    public void send (View view){

        finish();
        Intent SendIntent = new Intent(Send.this, Startup.class);
        Send.this.startActivity(SendIntent);


    }
}
