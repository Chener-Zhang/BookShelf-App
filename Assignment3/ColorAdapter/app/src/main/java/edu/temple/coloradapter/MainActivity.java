package edu.temple.coloradapter;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner myspinner;
    String choosen_color;
    ConstraintLayout myLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Spinner spinner = findViewById(R.id.myspinner);
        myspinner = spinner;
        setup();
    }

    public void setup() {
        ArrayAdapter<String> ColorAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.MyColorList));
        ColorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner.setAdapter(ColorAdapter);
        myspinner.setOnItemSelectedListener(this);
        myLayout = findViewById(R.id.mylayout);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        choosen_color = parent.getSelectedItem().toString();
        System.out.println("You select: " + choosen_color);
        switch (choosen_color) {
            case "Blue":
                myLayout.setBackgroundColor(Color.blue(100));
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
