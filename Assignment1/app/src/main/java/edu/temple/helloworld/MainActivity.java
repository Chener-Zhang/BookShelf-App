package edu.temple.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button mybutton001;
    TextView mytest001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         mybutton001 = (Button) findViewById(R.id.button001);
         mytest001 =(TextView) findViewById(R.id.textView001);

        mybutton001.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mytest001.setText("you have press the button!!!");
            }
        });
    }


}
