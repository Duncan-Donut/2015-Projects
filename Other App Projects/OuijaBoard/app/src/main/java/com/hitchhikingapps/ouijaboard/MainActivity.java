package com.hitchhikingapps.ouijaboard;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.SensorEvent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;




public class MainActivity extends AppCompatActivity implements SensorEventListener {

    RelativeLayout hello;
    TextView hi;
    TextView mTextField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hello = (RelativeLayout)findViewById(R.id.background);
        hi = (TextView)findViewById(R.id.hi);

        SensorManager mSensorManager;
        Sensor mSensor;

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);

        mSensorManager.registerListener(this,mSensor,SensorManager.SENSOR_DELAY_FASTEST);

        findX = makerX();
        findY = makerY();
        findZ = makerZ();

        hi.setText("Find " + findX + " " + findY + " " + findZ + " ");
        hi.setTextColor(Color.argb(255, findX, findY, findZ));

        mTextField = (TextView)findViewById(R.id.times);

        new CountDownTimer(90000, 1000) {

            public void onTick(long millisUntilFinished) {
                mTextField.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                hi.setText("TIMES UP, you lost");
            }
        }.start();
    }

    int findX,findY,findZ;

    @Override
    public void onSensorChanged(SensorEvent event) {
        int x,y,z;

        x = (int) Math.abs(100 * event.values[0]);
        y = (int) Math.abs(100 * event.values[1]);
        z = (int) Math.abs(100 * event.values[2]);

        hello.setBackgroundColor(Color.argb(255, x, y, z));

        if(checker(x,y,z)){
            hi.setText("YOU WON!!!");
        }
    }


    public boolean checker(int x,int y, int z){

        if((x <=findX+25 && x >= findX-25)&&(y <=findY+25 && y >= findY-25)&&(z <=findZ+25 && z >= findZ-25)) {
            return true;
        }
        return false;
    }

    public int makerX(){
        int x = (int)((Math.random()*255) +1);
        return x;
    }
    public int makerY(){
        int y = (int)((Math.random()*255) +1);
        return y;
    }
    public int makerZ(){
        int z = (int)((Math.random()*255) +1);
        return z;
    }




    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
