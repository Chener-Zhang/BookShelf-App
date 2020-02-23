package edu.temple.assignment4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.widget.TextView;

public class Canvas extends AppCompatActivity {


    String getcolor;
    String color_id;
    TextView box;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);
        box = (TextView) findViewById(R.id.color_text_view);

        getcolor = getIntent().getExtras().getString("color");
        color_id = getIntent().getExtras().getString("color_id");

        box.setText(getcolor);
        ConstraintLayout canvas = (ConstraintLayout) findViewById(R.id.canvas_layout);
        canvas.setBackgroundColor(Color.parseColor(color_id));
    }

}
