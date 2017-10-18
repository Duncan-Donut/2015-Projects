package com.hitchhikingapps.thesuggestionbox;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;


public class Suggestions extends AppCompatActivity {

    private Connection con;
    EditText comp;
    EditText sugg;
    TextView name;
    String mail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestions);



        name = (TextView)findViewById(R.id.name);
        comp = (EditText)findViewById(R.id.complaint);
        sugg = (EditText)findViewById(R.id.suggestion);



        Bundle bundle = getIntent().getExtras();
        name.setText(bundle.getString("name"));

        mail = emailList(name.getText().toString()).toString();

        //duncan

        android.os.StrictMode.ThreadPolicy policy = new android.os.StrictMode.ThreadPolicy.Builder().permitAll().build();
        android.os.StrictMode.setThreadPolicy(policy);

        Properties connectionProps = new Properties();
        connectionProps.put("user","report");
        connectionProps.put("password", "ReportPass");
        connectionProps.put("databaseName", "Reportdb");


        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:jtds:sqlserver://10.129.0.50:1433;", connectionProps);
        }
        catch (Exception e){
            e.printStackTrace();
        }



    }

    public void suggester (View view){


        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO issues VALUES (?,?,?)");
            ps.setString(2, comp.getText().toString());
            ps.setString(1, sugg.getText().toString());
            ps.setString(3, mail);
            ps.executeUpdate();


        }
        catch (Exception e){
            e.printStackTrace();
        }

        finish();
        Intent SuggestIntent = new Intent(Suggestions.this, Send.class);
        Suggestions.this.startActivity(SuggestIntent);


    }

    public String emailList(String email){
       switch(email){
           case "Music" : return "music@gmail.com";
           case "General" : return "general@gmail.com";

       }


        return "";
    }



}
