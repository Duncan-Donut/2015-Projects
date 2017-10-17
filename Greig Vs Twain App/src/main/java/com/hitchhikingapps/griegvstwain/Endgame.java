package com.hitchhikingapps.griegvstwain;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

public class Endgame extends AppCompatActivity {

    MediaPlayer endGame;
    int hscore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endgame);


        final SharedPreferences high = getSharedPreferences("highscore", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = high.edit();
        editor.putInt("highscore",0);


        TextView round = (TextView)findViewById(R.id.round);
        Integer data = getIntent().getExtras().getInt("rounds") -2;
        round.setTypeface(Typeface.SERIF);
        round.setGravity(Gravity.CENTER_HORIZONTAL);

        TextView highscore = (TextView)findViewById(R.id.highscore);
        highscore.setTypeface(Typeface.SERIF);
        highscore.setGravity(Gravity.CENTER_HORIZONTAL);

        if(getIntent().getExtras().getBoolean("timeout")){
            round.setText("Time Ran Out" + "\n\n" + "Score : " + data);
            highscore.setText("High score : " + high.getInt("highscore", 0));
            round.setGravity(Gravity.CENTER_HORIZONTAL);
            highscore.setGravity(Gravity.CENTER_HORIZONTAL);
        }
        else{
           if(data > high.getInt("highscore",0)) {
                editor.putInt("highscore",data);
                editor.apply();
               highscore.setText("New High Score!");
           }
            else{
               highscore.setText("High score : " + high.getInt("highscore", 0));
               highscore.setGravity(Gravity.CENTER_HORIZONTAL);

           }

            round.setText("Score: " + data );
            round.setGravity(Gravity.CENTER_HORIZONTAL);

        }

        final SharedPreferences sound = getSharedPreferences("mute", Context.MODE_PRIVATE);

        endGame = MediaPlayer.create(Endgame.this, R.raw.gameover);

        if (sound.getBoolean("sound", true)) {
            endGame.setLooping(true);
            endGame.setVolume(1, 1);
            endGame.start();
        }






    }

    @Override
    protected void onStop() {
        super.onStop();
        final SharedPreferences sound = getSharedPreferences("mute", Context.MODE_PRIVATE);
        if(sound.getBoolean("sound",true)) {
            endGame.release();
        }
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        final SharedPreferences sound = getSharedPreferences("mute", Context.MODE_PRIVATE);
        if (sound.getBoolean("sound", true)) {
            endGame.setVolume(1, 1);
            endGame.start();
        }


    }

    public void restart(View view){
        finish();
        Intent restartIntent = new Intent(Endgame.this, MainActivity.class);
        Endgame.this.startActivity(restartIntent);
        final SharedPreferences sound = getSharedPreferences("mute", Context.MODE_PRIVATE);
        if(sound.getBoolean("sound",true)) {
            endGame.release();
        }

    }
    public void menu(View view){
        finish();
        Intent menuIntent = new Intent(Endgame.this, Startup.class);
        Endgame.this.startActivity(menuIntent);
        final SharedPreferences sound = getSharedPreferences("mute", Context.MODE_PRIVATE);
        if(sound.getBoolean("sound",true)) {
            endGame.release();
        }

    }


}
