package com.example.mwallace.daysoftheweek;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import android.widget.TextView;

public class Reverse extends AppCompatActivity {

    private ListView lv;
    private ArrayAdapter<String> arrayAdapter1;
    private String[] WillFerrellMovies;
    private TreeMap<Integer,String> RottenTomatoScores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reverse);

        lv = (ListView) findViewById(R.id.weekDays);

        WillFerrellMovies = new String[]{"Step Brothers", "Anchorman", "Talladega Nights", "Zoolander", "The LEGO Movie", "Elf", "The Other Guys", "Wedding Crashers"};

        RottenTomatoScores = new TreeMap<Integer,String>();
        RottenTomatoScores.put(55,"Step Brothers");
        RottenTomatoScores.put(66,"Anchorman");
        RottenTomatoScores.put(72,"Talladega Nights");
        RottenTomatoScores.put(64,"Zoolander");
        RottenTomatoScores.put(96,"The LEGO Movie");
        RottenTomatoScores.put(84, "Elf");
        RottenTomatoScores.put(78, "The Other Guys");
        RottenTomatoScores.put(75,"Wedding Crashers");

        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                WillFerrellMovies );
        lv.setAdapter(arrayAdapter1);
    }

    public void arrange(View view){

        ArrayList<Integer> l = new ArrayList<Integer>(RottenTomatoScores.keySet());
        Collections.sort(l);
        Collections.reverse(l);

        ArrayList<String> keyArray = new ArrayList<String>();

        for(int x=0;x<l.size();x++) {
            keyArray.add(RottenTomatoScores.get(l.get(x)));
        }
        for (int i = 0; i < 8; i++) {
            while(WillFerrellMovies[i]!= keyArray.get(i)){
                for(int x =0; x<8;x++){
                    if(WillFerrellMovies[x] == keyArray.get(i)){
                        String Temp = WillFerrellMovies[i];
                        WillFerrellMovies[i] = WillFerrellMovies[x];
                        WillFerrellMovies[x] = Temp;
                    }
                }
            }
        }

        ((BaseAdapter) lv.getAdapter()).notifyDataSetChanged();
    }

    public void highScore(View view){
        arrange(view);
        TextView highScore = (TextView)findViewById(R.id.textView);
        highScore.setText(WillFerrellMovies[0]);

    }



}
