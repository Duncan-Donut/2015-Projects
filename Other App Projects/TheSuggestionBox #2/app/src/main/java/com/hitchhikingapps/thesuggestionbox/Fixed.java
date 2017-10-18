package com.hitchhikingapps.thesuggestionbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

public class Fixed extends AppCompatActivity {

    GridView lv;
    private Connection con;

    //aaron

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixed);


        lv = (GridView) findViewById(R.id.gridView);


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

        try {

            PreparedStatement ps = con.prepareStatement("SELECT complaint,suggestion FROM issues");

            ResultSet rs = ps.executeQuery();

            String compText = "";
            String suggText = "";
            ArrayList<String> arr = new ArrayList<String>();

            while (rs.next()){

                compText =  String.valueOf(rs.getString("complaint"));
                suggText =  String.valueOf(rs.getString("suggestion"));

                arr.add(compText);
                arr.add(suggText);

            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr);
            lv.setAdapter(adapter);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public void back (View view){

        finish();
        Intent fixerintent = new Intent(Fixed.this, Startup.class);
        Fixed.this.startActivity(fixerintent);

    }






}
