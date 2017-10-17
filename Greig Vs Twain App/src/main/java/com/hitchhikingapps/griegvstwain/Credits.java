package com.hitchhikingapps.griegvstwain;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;


public class Credits extends AppCompatActivity {
    MediaPlayer other;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
       /*
        TextView myTextView=(TextView)findViewById(R.id.Credits);
        Typeface typeFace=Typeface.createFromAsset(getAssets(),"fonts/HarabaraHand.ttf");
        myTextView.setTypeface(typeFace);
        */
        TextView credits = (TextView)findViewById(R.id.credits);
        credits.setMovementMethod(new ScrollingMovementMethod());
        credits.setText("Project Leader, Head Developer, Lead Programmer – Duncan Rowe\n" +
                        "\n" +
                        "Audio Engineer, Copyright Consultant, Music Arranger, Technical Artist – Aaron Keller\n" +
                        "\n" +
                        "Creative Director, Assistant Producer, Lead QA Tester- Ryan Quach\n" +
                        "\n" +
                        "External Producer, Game Designer, Lead Artist- Technical Artist – Nick Vaporciyan\n" + "\n" + "    We would like to thank " +
                        "everyone who has supported us in our adventure! We sincerely hope you enjoy our game and please post or " +
                        "tell us any feedback, it would be very appreciated. Woz out!\n" + "\n" + "All images belong to their individual" +
                        " websites and were searched for using google images. Music pieces were written by Grieg Twain and then 8bited by Geocities."


        );
        credits.setTypeface(Typeface.SERIF);

        final SharedPreferences sound = getSharedPreferences("mute", Context.MODE_PRIVATE);
        if(sound.getBoolean("sound",true)) {
            other = MediaPlayer.create(Credits.this, R.raw.settings_credits);
            other.setLooping(true);
            other.start();
        }


    }

    @Override
    protected void onStop() {
        super.onStop();

        final SharedPreferences sound = getSharedPreferences("mute", Context.MODE_PRIVATE);
        if(sound.getBoolean("sound",true)) {
            other.release();
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        final SharedPreferences sound = getSharedPreferences("mute", Context.MODE_PRIVATE);
        if(sound.getBoolean("sound",true)) {
            other = MediaPlayer.create(Credits.this, R.raw.settings_credits);
            other.setLooping(true);
            other.start();
        }

    }


    public void menu(View view){
        finish();
        Intent menuIntent = new Intent(Credits.this, Startup.class);
        Credits.this.startActivity(menuIntent);
        final SharedPreferences sound = getSharedPreferences("mute", Context.MODE_PRIVATE);
        if(sound.getBoolean("sound",true)) {
            other.release();
        }

    }



}
