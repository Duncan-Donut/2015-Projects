package com.example.mwallace.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.*;
import java.util.Properties;

public class Login extends AppCompatActivity {
    private Connection con;
    private EditText username;
    private EditText password;
    private TextView valid;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        android.os.StrictMode.ThreadPolicy policy = new android.os.StrictMode.ThreadPolicy.Builder().permitAll().build();
        android.os.StrictMode.setThreadPolicy(policy);


        setContentView(R.layout.activity_login);
        username = (EditText) findViewById(R.id.editTextUsername);
        password = (EditText) findViewById(R.id.editTextPassword);
        valid = (TextView) findViewById(R.id.textViewValid);


        Properties connectionProps = new Properties();
        connectionProps.put("user","test");
        connectionProps.put("password", "TestPass");
        connectionProps.put("databaseName","testdb");
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:jtds:sqlserver://10.129.0.50:1433;", connectionProps);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void submit(View view){

        try {

            PreparedStatement ps = con.prepareStatement("SELECT id FROM logins WHERE username = ? AND password = ?");
            ps.setString(1,username.getText().toString());
            ps.setString(2,password.getText().toString());
            ResultSet rs = ps.executeQuery();

            String validText = "Not valid";
            while (rs.next()){
                validText = "Valid, id = " + String.valueOf(rs.getInt("id"));
            }
            valid.setText(validText);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
