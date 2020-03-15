package edu.temple.assignment6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //------------------------>
        setup_spinner_adaptor();
    }

    public void setup_spinner_adaptor(){

        //get the spinner from the PaletteFtagment
        Spinner myspinner = (Spinner) findViewById(R.id.palette_spinner);

        //Create a color_list import from Resourse color
        String[] color_list =  getResources().getStringArray(R.array.color_list);

        //Making an adapter
        ArrayAdapter<String> ColorAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, color_list);

        //Connect the spinner with my adapter
        myspinner.setAdapter(ColorAdapter);
    }


}
