package com.hitchhikingapps.thesuggestionbox;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class Department extends AppCompatActivity {
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department);

         lv = (ListView) findViewById(R.id.listView);

        String[] Deps = new String[]{"Music","Physics","General","Chemistry","English","Computer Science","Theory of Knowledge","Spanish","French"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Deps );
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> myAdapter, View myView, int myItemInt, long mylng) {

                String selectedFromList = (String) (lv.getItemAtPosition(myItemInt));

                finish();
                Intent intent = new Intent(Department.this, Suggestions.class);
                intent.putExtra("name", selectedFromList);
                startActivity(intent);

            }
        });


    }

    public void department (View view){

        finish();
        Intent departmentsintent = new Intent(Department.this, Suggestions.class);
        Department.this.startActivity(departmentsintent);


    }

}
