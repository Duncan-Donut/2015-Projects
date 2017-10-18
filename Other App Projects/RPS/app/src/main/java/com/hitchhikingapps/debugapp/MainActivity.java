package com.hitchhikingapps.debugapp;

import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    int human = 0;
    int Ai=0;
    double machine = Math.random();
    int acounter = 0;
    int hcounter=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


            Button Rock = (Button)findViewById(R.id.Rock);
            Button Paper = (Button)findViewById(R.id.Paper);
            Button Scissors = (Button)findViewById(R.id.Scissors);
            final TextView Machine = (TextView)findViewById(R.id.Machine);
            final TextView Winner = (TextView)findViewById(R.id.Winner);
            final RadioButton quit = (RadioButton)findViewById(R.id.radioButton);
            Button Next = (Button)findViewById(R.id.Next);
            final TextView Hcounter = (TextView)findViewById(R.id.Hcounter);
            final TextView Acounter = (TextView)findViewById(R.id.Acounter);

        //Ai
        machine= Math.random();

            //When human presses button
            Rock.setOnClickListener(
                    new View.OnClickListener() {
                        public void onClick(View view) {

                            if(Ai == 0) {
                                human = 1;
                                if (machine < .33) {
                                    Machine.setText("Rock");
                                    Ai = 1;
                                } else if (machine < .66 && machine > .33) {
                                    Machine.setText("Paper");
                                    Ai = 2;
                                } else {
                                    Machine.setText("Scissors");
                                    Ai = 3;
                                }

                                if (Ai == human) {
                                    Winner.setText("Tie");
                                } else if (Ai == 1 && human == 2 || Ai == 2 && human == 3 || Ai == 3 && human == 1) {
                                    Winner.setText("You won");
                                } else {
                                    Winner.setText("Ai won :(");
                                }
                                ;
                            }

                        }
                    }

            );
            Paper.setOnClickListener(
                    new View.OnClickListener() {
                        public void onClick(View view) {
                           if(Ai == 0) {
                               human = 2;
                               if (machine < .33) {
                                   Machine.setText("Rock");
                                   Ai = 1;
                               } else if (machine < .66 && machine > .33) {
                                   Machine.setText("Paper");
                                   Ai = 2;
                               } else {
                                   Machine.setText("Scissors");
                                   Ai = 3;
                               }

                               if (Ai == human) {
                                   Winner.setText("Tie");
                               } else if (Ai == 1 && human == 2 || Ai == 2 && human == 3 || Ai == 3 && human == 1) {
                                   Winner.setText("You won");
                               } else {
                                   Winner.setText("Ai won :(");
                               }
                               ;
                           }
                        }
                    }
            );

            Scissors.setOnClickListener(
                    new View.OnClickListener() {
                        public void onClick(View view) {
                            human = 3;
                           if(Ai==0) {
                               if (machine < .33) {
                                   Machine.setText("Rock");
                                   Ai = 1;
                               } else if (machine < .66 && machine > .33) {
                                   Machine.setText("Paper");
                                   Ai = 2;
                               } else {
                                   Machine.setText("Scissors");
                                   Ai = 3;
                               }

                               if (Ai == human) {
                                   Winner.setText("Tie");
                               } else if (Ai == 1 && human == 2 || Ai == 2 && human == 3 || Ai == 3 && human == 1) {
                                   Winner.setText("You won");
                               } else {
                                   Winner.setText("Ai won :(");
                               }
                           }
                            ;
                        }
                    }
            );

          quit.setOnClickListener(
                  new View.OnClickListener() {
                      public void onClick(View view) {
                          System.exit(0);
                  }
                  }
          );


        Next.setOnClickListener(
                    new View.OnClickListener() {
                        public void onClick(View view) {
                            if(Winner.getText().toString().equals("Ai won :(")){
                                acounter++;
                                Acounter.setText("Ai wins " + String.valueOf(acounter));
                                Winner.setText("Winner is...");
                            }
                            if(Winner.getText().toString().equals("You won")){
                                hcounter++;
                                Hcounter.setText("Your wins " + String.valueOf(hcounter));
                                Winner.setText("Winner is...");
                            }
                            if(Winner.getText().toString().equals("Tie")){
                                Winner.setText("Winner is...");
                            }
                            Ai = 0;
                            Machine.setText("");
                            machine= Math.random();
                        }
                    }
            );






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
}
