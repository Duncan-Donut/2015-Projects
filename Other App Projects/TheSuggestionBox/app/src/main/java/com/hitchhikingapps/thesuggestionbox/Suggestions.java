package com.hitchhikingapps.thesuggestionbox;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class Suggestions extends AppCompatActivity {

    EditText comp;
    EditText sugg;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestions);

        TextView name = (TextView)findViewById(R.id.name);
        comp = (EditText)findViewById(R.id.complaint);
        sugg = (EditText)findViewById(R.id.suggestion);
        dbHandler = new MyDBHandler(this,null,null,1);

        Bundle bundle = getIntent().getExtras();
        name.setText(bundle.getString("name"));


    }

    public void suggester (View view){

        Complaint complaint = new Complaint(comp.getText().toString());
        if(!comp.getText().toString().matches("")){
            dbHandler.addComplaint(complaint);
        }


        Suggestion suggestion = new Suggestion(sugg.getText().toString());
        if(!sugg.getText().toString().matches("")){
            dbHandler.addSuggestion(suggestion);
        }



        finish();
        Intent SuggestIntent = new Intent(Suggestions.this, Send.class);
        Suggestions.this.startActivity(SuggestIntent);


    }



}
