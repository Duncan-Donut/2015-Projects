package com.hitchhikingapps.rainbowz;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText input = (EditText) findViewById(R.id.input);
    TextView output = (TextView) findViewById(R.id.output);
    ArrayList <String> charzart = new ArrayList<String>();
    ArrayList <String> color = new ArrayList<String>();

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

        Button converter = (Button) findViewById(R.id.button);

        int begin = 0;
        int total = 16777216;
        String text = input.getText().toString();

        ArrayList<Integer> hexa = new ArrayList<Integer>();


        //charzart array
        int b = text.length();

        for (int i = 1; i <= b; i++) {
            charzart.add(text.substring(i - 1, i));
        }

        //hexa array

        int a = text.length() - 1;

        for (int z = 0; z < charzart.size(); z++) {

            if (charzart.get(z).matches(" ")) {
                a--;
            }
        }


        int numb = total / a;

        for (int x = 0; x <= 16777216; x = x + numb) {
            hexa.add(x);
        }


        //changing into hexadecimal numbers

        for (int y = 0; y < hexa.size(); y++) {

            int cvalue = hexa.get(y);
            int one, two, three, four, five, six;

            one = cvalue / 1048570;
            cvalue = cvalue - one * 1048570;

            two = cvalue / 65356;
            cvalue = cvalue - two * 65356;

            three = cvalue / 4096;
            cvalue = cvalue - three * 4096;

            four = cvalue / 256;
            cvalue = cvalue - four * 256;

            five = cvalue / 16;
            cvalue = cvalue - five * 16;

            six = cvalue;

            if (one != 16) {

                String let = "";
                String fin = "#";

                switch (one) {
                    case 0:
                        let = "0";
                        break;
                    case 1:
                        let = "1";
                        break;
                    case 2:
                        let = "2";
                        break;
                    case 3:
                        let = "3";
                        break;
                    case 4:
                        let = "4";
                        break;
                    case 5:
                        let = "5";
                        break;
                    case 6:
                        let = "6";
                        break;
                    case 7:
                        let = "7";
                        break;
                    case 8:
                        let = "8";
                        break;
                    case 9:
                        let = "9";
                        break;
                    case 10:
                        let = "A";
                        break;
                    case 11:
                        let = "B";
                        break;
                    case 12:
                        let = "C";
                        break;
                    case 13:
                        let = "D";
                        break;
                    case 14:
                        let = "E";
                        break;
                    case 15:
                        let = "F";
                        break;
                    default:
                        let = "x";
                }

                fin += let;
                let = "";

                switch (two) {
                    case 0:
                        let = "0";
                        break;
                    case 1:
                        let = "1";
                        break;
                    case 2:
                        let = "2";
                        break;
                    case 3:
                        let = "3";
                        break;
                    case 4:
                        let = "4";
                        break;
                    case 5:
                        let = "5";
                        break;
                    case 6:
                        let = "6";
                        break;
                    case 7:
                        let = "7";
                        break;
                    case 8:
                        let = "8";
                        break;
                    case 9:
                        let = "9";
                        break;
                    case 10:
                        let = "A";
                        break;
                    case 11:
                        let = "B";
                        break;
                    case 12:
                        let = "C";
                        break;
                    case 13:
                        let = "D";
                        break;
                    case 14:
                        let = "E";
                        break;
                    case 15:
                        let = "F";
                        break;
                    default:
                        let = "x";
                }

                fin += let;
                let = "";

                switch (three) {
                    case 0:
                        let = "0";
                        break;
                    case 1:
                        let = "1";
                        break;
                    case 2:
                        let = "2";
                        break;
                    case 3:
                        let = "3";
                        break;
                    case 4:
                        let = "4";
                        break;
                    case 5:
                        let = "5";
                        break;
                    case 6:
                        let = "6";
                        break;
                    case 7:
                        let = "7";
                        break;
                    case 8:
                        let = "8";
                        break;
                    case 9:
                        let = "9";
                        break;
                    case 10:
                        let = "A";
                        break;
                    case 11:
                        let = "B";
                        break;
                    case 12:
                        let = "C";
                        break;
                    case 13:
                        let = "D";
                        break;
                    case 14:
                        let = "E";
                        break;
                    case 15:
                        let = "F";
                        break;
                    default:
                        let = "x";
                }

                fin += let;
                let = "";

                switch (four) {
                    case 0:
                        let = "0";
                        break;
                    case 1:
                        let = "1";
                        break;
                    case 2:
                        let = "2";
                        break;
                    case 3:
                        let = "3";
                        break;
                    case 4:
                        let = "4";
                        break;
                    case 5:
                        let = "5";
                        break;
                    case 6:
                        let = "6";
                        break;
                    case 7:
                        let = "7";
                        break;
                    case 8:
                        let = "8";
                        break;
                    case 9:
                        let = "9";
                        break;
                    case 10:
                        let = "A";
                        break;
                    case 11:
                        let = "B";
                        break;
                    case 12:
                        let = "C";
                        break;
                    case 13:
                        let = "D";
                        break;
                    case 14:
                        let = "E";
                        break;
                    case 15:
                        let = "F";
                        break;
                    default:
                        let = "x";
                }

                fin += let;
                let = "";

                switch (five) {
                    case 0:
                        let = "0";
                        break;
                    case 1:
                        let = "1";
                        break;
                    case 2:
                        let = "2";
                        break;
                    case 3:
                        let = "3";
                        break;
                    case 4:
                        let = "4";
                        break;
                    case 5:
                        let = "5";
                        break;
                    case 6:
                        let = "6";
                        break;
                    case 7:
                        let = "7";
                        break;
                    case 8:
                        let = "8";
                        break;
                    case 9:
                        let = "9";
                        break;
                    case 10:
                        let = "A";
                        break;
                    case 11:
                        let = "B";
                        break;
                    case 12:
                        let = "C";
                        break;
                    case 13:
                        let = "D";
                        break;
                    case 14:
                        let = "E";
                        break;
                    case 15:
                        let = "F";
                        break;
                    default:
                        let = "x";
                }

                fin += let;
                let = "";

                switch (six) {
                    case 0:
                        let = "0";
                        break;
                    case 1:
                        let = "1";
                        break;
                    case 2:
                        let = "2";
                        break;
                    case 3:
                        let = "3";
                        break;
                    case 4:
                        let = "4";
                        break;
                    case 5:
                        let = "5";
                        break;
                    case 6:
                        let = "6";
                        break;
                    case 7:
                        let = "7";
                        break;
                    case 8:
                        let = "8";
                        break;
                    case 9:
                        let = "9";
                        break;
                    case 10:
                        let = "A";
                        break;
                    case 11:
                        let = "B";
                        break;
                    case 12:
                        let = "C";
                        break;
                    case 13:
                        let = "D";
                        break;
                    case 14:
                        let = "E";
                        break;
                    case 15:
                        let = "F";
                        break;
                    default:
                        let = "x";
                }

                fin += let;
                let = "";


                color.add(fin);

                fin = "#";
            } else {
                color.add("#FFFFFF");
            }

        }


        //BUTTON

        converter.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {

                        String end = "";
                        for (int p = 0; p < charzart.size(); p++) {

                            if (charzart.get(p).equals(" ")) {

                            }
                            else{

                                Spannable colorSpan = new SpannableString(charzart.get(p));
                                int fake = Integer.parseInt(color.get(p));
                                colorSpan.setSpan(new ForegroundColorSpan(fake), 0, 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE);

                                end += colorSpan;
                            }


                        }

                        output.setText(end);
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
