package com.example.pranavsridhar.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    int x=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void Changer (View view){

        TextView pranav = (TextView)findViewById(R.id.pranav);
        x++;

        switch(x){
            case 1: pranav.setText("Pranav!!!");break;
            case 2: pranav.setText("Pranab?");break;
            case 3: pranav.setText("Pravan!");break;
            case 4: pranav.setText("Not cool");break;
            case 5: pranav.setText("jkjk");break;
            case 6: pranav.setText("Pranva");break;
            case 7: pranav.setText("don't");break;
            case 8: pranav.setText("be");break;
            case 9: pranav.setText("salty boi");break;
            case 10: pranav.setText("");break;
            case 11: pranav.setText("Is this done?");break;
            case 12: pranav.setText("Now it is");break;
        }

        if(x>11){
            x=0;
        }

    }




}
