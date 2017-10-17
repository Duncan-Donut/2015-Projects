package com.hitchhikingapps.griegvstwain;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Startup extends AppCompatActivity  {
    MediaPlayer intro, main;
    boolean i;
    boolean mute;
    private Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup);

            final SharedPreferences sound = getSharedPreferences("mute", Context.MODE_PRIVATE);
            final SharedPreferences.Editor editor = sound.edit();

        if(sound.getBoolean("sound",true)) {
            intro = MediaPlayer.create(Startup.this, R.raw.intro);
            main = MediaPlayer.create(Startup.this, R.raw.maincut);
            intro.start();
            i = true;
            intro.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mp) {
                    intro.release();
                    i = false;
                    main.setLooping(true);
                    main.start();
                }
            });
        }


    }

    @Override
    protected void onStop() {
        super.onStop();

        final SharedPreferences sound = getSharedPreferences("mute", Context.MODE_PRIVATE);
        if(sound.getBoolean("sound",true)) {
            if (i == true) {
                intro.release();
            }
            if (i == false) {
                main.release();
            }
        }

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        final SharedPreferences sound = getSharedPreferences("mute", Context.MODE_PRIVATE);
        if(sound.getBoolean("sound",true)) {
            intro = MediaPlayer.create(Startup.this, R.raw.intro);
            main = MediaPlayer.create(Startup.this, R.raw.maincut);
            intro.start();
            i = true;
            intro.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mp) {
                    intro.release();
                    i = false;
                    main.setLooping(true);
                    main.start();
                }
            });
        }

    }

    public void startgame(View view){
        finish();
        Intent startIntent = new Intent(Startup.this, MainActivity.class);
        Startup.this.startActivity(startIntent);

        final SharedPreferences sound = getSharedPreferences("mute", Context.MODE_PRIVATE);
        if(sound.getBoolean("sound",true)) {
            if (i == true) {
                intro.release();
            }
            if (i == false) {
                main.release();
            }
        }
    }

    public void startcredits(View view){
        finish();
        Intent creditsIntent = new Intent(Startup.this, Credits.class);
        Startup.this.startActivity(creditsIntent);

        final SharedPreferences sound = getSharedPreferences("mute", Context.MODE_PRIVATE);
        if(sound.getBoolean("sound",true)) {
            if (i == true) {
                intro.release();
            }
            if (i == false) {
                main.release();
            }
        }

    }
    public void startsettings(View view){
        finish();
        Intent settingsIntent = new Intent(Startup.this, Settings.class);
        Startup.this.startActivity(settingsIntent);

        final SharedPreferences sound = getSharedPreferences("mute", Context.MODE_PRIVATE);
        if(sound.getBoolean("sound",true)) {
            if (i == true) {
                intro.release();
            }
            if (i == false) {
                main.release();
            }
        }
    }


    public void quit(View view){
        System.exit(0);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        final SharedPreferences sound = getSharedPreferences("mute", Context.MODE_PRIVATE);
        if(sound.getBoolean("sound",true)) {
            if (i == true) {
                intro.release();
            }
            if (i == false) {
                main.release();
            }
        }
    }



}
