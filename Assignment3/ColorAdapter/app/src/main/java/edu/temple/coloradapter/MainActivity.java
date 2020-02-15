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
        if (choosen_color.equals("Choose a Color")) {
            myLayout.setBackgroundColor(Color.parseColor("#ffffff"));

        } else {
            switch (choosen_color) {
                case "Blue":
                    myLayout.setBackgroundColor(Color.parseColor("#0000ff"));
                    break;

                case "Purple":
                    myLayout.setBackgroundColor(Color.parseColor("#6a0dad"));
                    break;

                case "green":
                    myLayout.setBackgroundColor(Color.parseColor("#00ff00"));
                    break;

                case "cherry":
                    myLayout.setBackgroundColor(Color.parseColor("#DE3163"));
                    break;

                case "rose":
                    myLayout.setBackgroundColor(Color.parseColor("#ff007f"));
                    break;

                case "silver":
                    myLayout.setBackgroundColor(Color.parseColor("#aaa9ad"));
                    break;

                case "sky":
                    myLayout.setBackgroundColor(Color.parseColor("#87ceeb"));
                    break;

                case "pear":
                    myLayout.setBackgroundColor(Color.parseColor("#d1e231"));
                    break;

                case "candy":
                    myLayout.setBackgroundColor(Color.parseColor("#ff0800"));
                    break;

                case "cerulean":
                    myLayout.setBackgroundColor(Color.parseColor("#007ba7"));
                    break;

                case "banana":
                    myLayout.setBackgroundColor(Color.parseColor("#ffe135"));
                    break;


            }
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
