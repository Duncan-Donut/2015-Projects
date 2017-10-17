package com.hitchhikingapps.griegvstwain;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Button;

public class Settings extends AppCompatActivity {
    MediaPlayer other;
    Intent menuIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Switch silence = (Switch)findViewById(R.id.switch1);

        final SharedPreferences sound = getSharedPreferences("mute", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sound.edit();

        silence.setChecked(sound.getBoolean("muted", false));

        other = MediaPlayer.create(Settings.this, R.raw.settings_credits);
        other.setLooping(true);

            if (sound.getBoolean("sound", true)) {
                other.setVolume(1, 1);
                other.start();
            }



            silence.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(sound.getBoolean("sound",true)){
                    editor.putBoolean("sound", false);
                    editor.putBoolean("muted", isChecked);
                    editor.commit();
                    other.pause();

                }
                else{
                    editor.putBoolean("sound", true);
                    editor.putBoolean("muted", isChecked);
                    editor.commit();
                    other.seekTo(0);
                    other.start();

                }
                }

        });


    }

    @Override
    protected void onStop() {
        super.onStop();
        final SharedPreferences sound = getSharedPreferences("mute", Context.MODE_PRIVATE);
        if(sound.getBoolean("sound",true)){
            other.release();

        }

    }
    @Override
    protected void onRestart() {
        super.onRestart();
        final SharedPreferences sound = getSharedPreferences("mute", Context.MODE_PRIVATE);

        other = MediaPlayer.create(Settings.this, R.raw.settings_credits);
        other.setLooping(true);

        if (sound.getBoolean("sound", true)) {
            other.setVolume(1, 1);
            other.start();
        }

    }

    public void menu(View view){
        finish();
        menuIntent = new Intent(Settings.this, Startup.class);
        Settings.this.startActivity(menuIntent);

        final SharedPreferences sound = getSharedPreferences("mute", Context.MODE_PRIVATE);
        if(sound.getBoolean("sound",true)){
            other.release();

        }
    }

    public void reset(View view){
        final SharedPreferences high = getSharedPreferences("highscore", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = high.edit();
        Button highscore = (Button) findViewById(R.id.highscore);
        highscore.setText("Highscore reset!");
        editor.putInt("highscore",0);
        editor.apply();
    }






}
