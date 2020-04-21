package edu.temple.assignment4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.widget.TextView;

public class CanvasActivitiy extends AppCompatActivity {


    String getcolor;
    int getcolor_index;
    String[] list;

    TextView box;


    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        box = (TextView) findViewById(R.id.color_text_view);

        getcolor = getIntent().getExtras().getString("color");
        getcolor_index = getIntent().getExtras().getInt("color_index");
        list = getIntent().getExtras().getStringArray("list");
        box.setText(getcolor);

        System.out.println("-----------");
        System.out.println("index: "+ getcolor_index);
        System.out.println(list[getcolor_index]);
        System.out.println(getcolor);
        System.out.println("-----------");


        ConstraintLayout canvas = (ConstraintLayout) findViewById(R.id.canvas_layout);
        canvas.setBackgroundColor(Color.parseColor(list[getcolor_index]));
    }

}
