package com.hitchhikingapps.factorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText edit;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public int factorial(int number) {

        if (number < 0) {
            return 0;
        }
        else if(number == 0){
            return 0;
        }
        else if(number == 1 ){
            return 1;
        }
        else{
            return (number * factorial(number-1));
        }

    }

    public void factor (View view){

        edit = (EditText)findViewById(R.id.editText);
        text = (TextView)findViewById(R.id.textView);

        int a = Integer.parseInt(edit.getText().toString());

        int b= factorial(a);

        text.setText(b + "");

    }

}
