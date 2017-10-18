package com.example.pranavsridhar.rpsgame;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import java.util.Random;
import javax.xml.transform.Result;


public class MainActivity extends AppCompatActivity {

    public String[] RPS;
    public TextView Results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        Results = (TextView) findViewById(R.id.textView2);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        RPS = new String[]{"Rock", "Paper", "Scissor"};
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    public void rock(View view) {
        playComp("rock");
    }

    public void scissor(View view) {
        playComp("scissor");
    }

    public void paper(View view) {
        playComp("paper");
    }

    public void playComp(String player) {
        Random rand = new Random();
        int number = rand.nextInt(2);
        String comp = RPS[number];
        if (comp == player) {
            Results.setText("Tie!");
        }
        else if (comp =="rock" && player=="paper" || comp=="paper" && player=="scissor" || comp=="scissor" && player=="rock"){
            Results.setText("You Won!");
        }
        else {
            Results.setText("You Lost!");
        }
    }
}
