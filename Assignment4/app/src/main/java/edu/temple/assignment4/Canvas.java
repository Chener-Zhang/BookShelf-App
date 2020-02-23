package edu.temple.assignment4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Canvas extends AppCompatActivity {


    String getcolor;
    TextView box;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        getcolor = getIntent().getExtras().getString("color");
        
    }

}
