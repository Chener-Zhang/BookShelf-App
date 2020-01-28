package edu.temple.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    Button bt001 =  (Button)findViewById(R.id.button001);
    TextView textView001 = (TextView)findViewById(R.id.textView001);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt001.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                textView001.setText("You Clicked On Button");
            }

        });
    }



}
