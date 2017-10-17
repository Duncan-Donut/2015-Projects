package com.hitchhikingapps.griegvstwain;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button mark;
    Button edvard;
    RelativeLayout layout;
    ImageView picture;
    TextView time;
    Boolean running = true;
    CountDownTimer timer;
    int checker = 0;
    boolean clicker = false;
    boolean person = true;
    int round = 0;
    double random;
    long n=0;
    int timeDelay;
    MediaPlayer original;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        flipper();
        picturechanger();

        final SharedPreferences sound = getSharedPreferences("mute", Context.MODE_PRIVATE);

        if(sound.getBoolean("sound",true)) {
            original = MediaPlayer.create(MainActivity.this, R.raw.main);
            original.setLooping(true);
            original.start();
        }


    }
    public void picturechanger(){

        int randy = (int)Math.round(Math.random()*65);
        int andy = (int)Math.round(Math.random()*28);
        if(round % 5==0){
            switch(andy){
                case 1:
                    picture.setImageResource(R.drawable.yt_001);
                    person = false;
                    break;
                case 2:
                    picture.setImageResource(R.drawable.yt_002);
                    person = false;
                    break;
                case 3:
                    picture.setImageResource(R.drawable.yt_004);
                    person = false;
                    break;
                case 4:
                    picture.setImageResource(R.drawable.yt_005);
                    person = false;
                    break;
                case 5:
                    picture.setImageResource(R.drawable.yt_006);
                    person = false;
                    break;
                case 6:
                    picture.setImageResource(R.drawable.yt_007);
                    person = false;
                    break;
                case 7:
                    picture.setImageResource(R.drawable.yt_008);
                    person = false;
                    break;
                case 8:
                    picture.setImageResource(R.drawable.yt_009);
                    person = false;
                    break;
                case 9:
                    picture.setImageResource(R.drawable.yt_010);
                    person = false;
                    break;
                case 10:
                    picture.setImageResource(R.drawable.yt_011);
                    person = false;
                    break;
                case 11:
                    picture.setImageResource(R.drawable.yt_013);
                    person = false;
                    break;
                case 12:
                    picture.setImageResource(R.drawable.yt_014);
                    person = false;
                    break;
                case 13:
                    picture.setImageResource(R.drawable.yt_015);
                    person = false;
                    break;
                case 14:
                    picture.setImageResource(R.drawable.yg_001);
                    person = true;
                    break;
                case 15:
                    picture.setImageResource(R.drawable.yg_002);
                    person = true;
                    break;

                case 16:
                    picture.setImageResource(R.drawable.yg_003);
                    person = true;
                    break;

                case 17:
                    picture.setImageResource(R.drawable.yg_004);
                    person = true;
                    break;
                case 18:
                    picture.setImageResource(R.drawable.yg_005);
                    person = true;
                    break;
                case 19:
                    picture.setImageResource(R.drawable.yg_006);
                    person = true;
                    break;
                case 20:
                    picture.setImageResource(R.drawable.yg_007);
                    person = true;
                    break;
                case 21:
                    picture.setImageResource(R.drawable.yg_008);
                    person = true;
                    break;
                case 22:
                    picture.setImageResource(R.drawable.yg_009);
                    person = true;
                    break;
                case 23:
                    picture.setImageResource(R.drawable.yg_010);
                    person = true;
                    break;
                case 24:
                    picture.setImageResource(R.drawable.yg_011);
                    person = true;
                    break;
                case 25:
                    picture.setImageResource(R.drawable.yg_012);
                    person = true;
                    break;
                case 26:
                    picture.setImageResource(R.drawable.yg_013);
                    person = true;
                    break;
                case 27:
                    picture.setImageResource(R.drawable.yg_014);
                    person = true;
                    break;
                case 28:
                    picture.setImageResource(R.drawable.yt_003);
                    person = false;
                    break;
                case 0:
                    picture.setImageResource(R.drawable.yt_012);
                    person = false;
                    break;
            }
        }
        else {
            switch (randy) {
                case 0:
                    picture.setImageResource(R.drawable.g);
                    person = true;
                    break;
                case 1:
                    picture.setImageResource(R.drawable.g_002);
                    person = true;
                    break;
                case 2:
                    picture.setImageResource(R.drawable.g_003);
                    person = true;
                    break;
                case 3:
                    picture.setImageResource(R.drawable.g_004);
                    person = true;
                    break;
                case 4:
                    picture.setImageResource(R.drawable.g_005);
                    person = true;
                    break;
                case 5:
                    picture.setImageResource(R.drawable.g_006);
                    person = true;
                    break;
                case 6:
                    picture.setImageResource(R.drawable.g_007);
                    person = true;
                    break;
                case 7:
                    picture.setImageResource(R.drawable.g_008);
                    person = true;
                    break;
                case 8:
                    picture.setImageResource(R.drawable.g_009);
                    person = true;
                    break;
                case 9:
                    picture.setImageResource(R.drawable.g_010);
                    person = true;
                    break;
                case 10:
                    picture.setImageResource(R.drawable.g_011);
                    person = true;
                    break;
                case 11:
                    picture.setImageResource(R.drawable.g_012);
                    person = true;
                    break;
                case 12:
                    picture.setImageResource(R.drawable.g_013);
                    person = true;
                    break;
                case 13:
                    picture.setImageResource(R.drawable.g_014);
                    person = true;
                    break;
                case 14:
                    picture.setImageResource(R.drawable.g_015);
                    person = true;
                    break;
                case 15:
                    picture.setImageResource(R.drawable.g_016);
                    person = true;
                    break;
                case 16:
                    picture.setImageResource(R.drawable.g_017);
                    person = true;
                    break;
                case 17:
                    picture.setImageResource(R.drawable.g_018);
                    person = true;
                    break;
                case 18:
                    picture.setImageResource(R.drawable.g_019);
                    person = true;
                    break;
                case 19:
                    picture.setImageResource(R.drawable.g_021);
                    person = true;
                    break;
                case 20:
                    picture.setImageResource(R.drawable.g22);
                    person = true;
                    break;
                case 21:
                    picture.setImageResource(R.drawable.g24);
                    person = true;
                    break;
                case 22:
                    picture.setImageResource(R.drawable.g25);
                    person = true;
                    break;
                case 23:
                    picture.setImageResource(R.drawable.g27);
                    person = true;
                    break;
                case 24:
                    picture.setImageResource(R.drawable.g29);
                    person = true;
                    break;
                case 25:
                    picture.setImageResource(R.drawable.t_001);
                    person = false;
                    break;
                case 26:
                    picture.setImageResource(R.drawable.t_003);
                    person = false;
                    break;
                case 27:
                    picture.setImageResource(R.drawable.t_004);
                    person = false;
                    break;
                case 28:
                    picture.setImageResource(R.drawable.t_005);
                    person = false;
                    break;
                case 29:
                    picture.setImageResource(R.drawable.t_006);
                    person = false;
                    break;
                case 30:
                    picture.setImageResource(R.drawable.t_007);
                    person = false;
                    break;
                case 31:
                    picture.setImageResource(R.drawable.t_008);
                    person = false;
                    break;
                case 32:
                    picture.setImageResource(R.drawable.t_009);
                    person = false;
                    break;
                case 33:
                    picture.setImageResource(R.drawable.t17);
                    person = false;
                    break;
                case 34:
                    picture.setImageResource(R.drawable.t19);
                    person = false;
                    break;
                case 35:
                    picture.setImageResource(R.drawable.t20);
                    person = false;
                    break;
                case 36:
                    picture.setImageResource(R.drawable.t21);
                    person = false;
                    break;
                case 37:
                    picture.setImageResource(R.drawable.t22);
                    person = false;
                    break;
                case 38:
                    picture.setImageResource(R.drawable.t27);
                    person = false;
                    break;
                case 39:
                    picture.setImageResource(R.drawable.t29);
                    person = false;
                    break;
                case 40:
                    picture.setImageResource(R.drawable.t31);
                    person = false;
                    break;
                case 41:
                    picture.setImageResource(R.drawable.t32);
                    person = false;
                    break;
                case 42:
                    picture.setImageResource(R.drawable.t35);
                    person = false;
                    break;
                case 43:
                    picture.setImageResource(R.drawable.t37);
                    person = false;
                    break;
                case 44:
                    picture.setImageResource(R.drawable.t38);
                    person = false;
                    break;
                case 45:
                    picture.setImageResource(R.drawable.t39);
                    person = false;
                    break;
                case 46:
                    picture.setImageResource(R.drawable.t44);
                    person = false;
                    break;
                case 47:
                    picture.setImageResource(R.drawable.t45);
                    person = false;
                    break;
                case 48:
                    picture.setImageResource(R.drawable.t46);
                    person = false;
                    break;
                case 49:
                    picture.setImageResource(R.drawable.t47);
                    person = false;
                    break;
                case 50:
                    picture.setImageResource(R.drawable.t49);
                    person = false;
                    break;
                case 51:
                    picture.setImageResource(R.drawable.t50);
                    person = false;
                    break;
                case 52:
                    picture.setImageResource(R.drawable.t51);
                    person = false;
                    break;
                case 53:
                    picture.setImageResource(R.drawable.g31);
                    person = true;
                    break;
                case 54:
                    picture.setImageResource(R.drawable.g_020);
                    person = true;
                    break;
                case 55:
                    picture.setImageResource(R.drawable.g_001);
                    person = true;
                    break;
                case 56:
                    picture.setImageResource(R.drawable.g28);
                    person = true;
                    break;
                case 57:
                    picture.setImageResource(R.drawable.g30);
                    person = true;
                    break;
                case 58:
                    picture.setImageResource(R.drawable.g23);
                    person = true;
                    break;
                case 59:
                    picture.setImageResource(R.drawable.t_002);
                    person = false;
                    break;
                case 60:
                    picture.setImageResource(R.drawable.t_010);
                    person = false;
                    break;
                case 61:
                    picture.setImageResource(R.drawable.t_011);
                    person = false;
                    break;
                case 62:
                    picture.setImageResource(R.drawable.t_012);
                    person = false;
                    break;
                case 63:
                    picture.setImageResource(R.drawable.t_025);
                    person = false;
                    break;
                case 64:
                    picture.setImageResource(R.drawable.t_030);
                    person = false;
                    break;
                case 65:
                    picture.setImageResource(R.drawable.t_033);
                    person = false;
                    break;
            }
        }
        round++;

    }

    public void flipper(){

        //setting up the layout
        layout = new RelativeLayout(this);
        layout.setBackgroundColor(Color.parseColor("#1d4f63"));

        //creating a container for the left button
        final RelativeLayout.LayoutParams leftdetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        //assigning what each container will look like
        leftdetails.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        leftdetails.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        leftdetails.setMargins(200, 100, 100, 200);


        final RelativeLayout.LayoutParams rightdetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        //assigning what each container will look like
        rightdetails.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        rightdetails.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        rightdetails.setMargins(100, 100, 200, 200);

        final RelativeLayout.LayoutParams picturedetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        picturedetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        picturedetails.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        picturedetails.setMargins(100, 100, 100, 100);

        final RelativeLayout.LayoutParams timedetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        timedetails.addRule(RelativeLayout.ALIGN_TOP);
        timedetails.addRule(RelativeLayout.ALIGN_LEFT);
        timedetails.setMargins(100, 100, 100, 100);

        //setting up imageview picture
        picture = new ImageView(this);
        for(int x =0;x<1;x++){
            picturechanger();
        }

        //setting up time

        time = new TextView(this);
        time.setTypeface(Typeface.SERIF);
        time.setTextColor(Color.parseColor("#FFFFFF"));
        n = 2970 - timeDelay;
        timeDelay *= .9;

        timer = new CountDownTimer((long)(n+30), 1000) {
            public void onTick(long millisUntilFinished) {
               time.setText("seconds remaining: " + millisUntilFinished / 1000 + "." + (millisUntilFinished - (1000*(millisUntilFinished/1000))));
            }


            public void onFinish() {
                final SharedPreferences sound = getSharedPreferences("mute", Context.MODE_PRIVATE);
                if(sound.getBoolean("sound",true)) {
                    original.release();
                }
                finish();
                Intent endIntent = new Intent(MainActivity.this, Endgame.class);
                endIntent.putExtra("rounds",round);
                endIntent.putExtra("timeout",true);
                MainActivity.this.startActivity(endIntent);
            }

        }.start();


        //setting up mark
        mark = new Button(this);
        mark.setText("Twain");
        mark.setTextColor(Color.parseColor("#1d4f63"));
        mark.setBackgroundColor(Color.parseColor("#FFFFFF"));
        mark.setTypeface(Typeface.SERIF);
        mark.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        random = Math.random();
                        clicker = true;
                        if (random > .5) {
                            if (checker == 0) {
                                layout.removeView(mark);
                                layout.removeView(edvard);
                                layout.addView(mark, rightdetails);
                                layout.addView(edvard, leftdetails);
                                checker = 1;
                            } else {
                                layout.removeView(mark);
                                layout.removeView(edvard);
                                layout.addView(mark, leftdetails);
                                layout.addView(edvard, rightdetails);
                                checker = 0;
                            }
                        }
                        if(person == false){
                            picturechanger();
                            if(timer != null)
                                timer.cancel();
                            timer.start();

                        }
                        else{
                            final SharedPreferences sound = getSharedPreferences("mute", Context.MODE_PRIVATE);
                            if(sound.getBoolean("sound",true)) {
                                original.release();
                            }
                            timer.cancel();
                            finish();
                            Intent endIntent = new Intent(MainActivity.this, Endgame.class);
                            endIntent.putExtra("rounds",round);
                            MainActivity.this.startActivity(endIntent);

                        }

                    }

                }
        );


        //setting up edvard
        edvard = new Button(this);
        edvard.setText("Grieg");
        edvard.setTextColor(Color.parseColor("#1d4f63"));
        edvard.setBackgroundColor(Color.parseColor("#FFFFFF"));
        edvard.setTypeface(Typeface.SERIF);
        edvard.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        random = Math.random();
                        clicker = true;
                        if (random > .5) {
                            if (checker == 1) {
                                layout.removeView(mark);
                                layout.removeView(edvard);
                                layout.addView(mark, leftdetails);
                                layout.addView(edvard, rightdetails);
                                checker = 0;
                            } else {
                                layout.removeView(mark);
                                layout.removeView(edvard);
                                layout.addView(mark, rightdetails);
                                layout.addView(edvard, leftdetails);
                                checker = 1;
                            }
                        }
                        if (person == true) {
                            picturechanger();
                            if(timer != null)
                                timer.cancel();
                            timer.start();
                        } else {
                            final SharedPreferences sound = getSharedPreferences("mute", Context.MODE_PRIVATE);
                            if(sound.getBoolean("sound",true)) {
                                original.release();
                            }
                            timer.cancel();
                            finish();
                            Intent endIntent = new Intent(MainActivity.this, Endgame.class);
                            endIntent.putExtra("rounds", round);
                            MainActivity.this.startActivity(endIntent);

                        }
                    }
                }
        );

        //adding the two buttons and imageview to the layout and applying the rules
        layout.addView(mark,leftdetails);
        layout.addView(edvard, rightdetails);
        layout.addView(picture, picturedetails);
        layout.addView(time, timedetails);
        //setting the app to view this layout
        setContentView(layout);
        //timer();

    }
}
