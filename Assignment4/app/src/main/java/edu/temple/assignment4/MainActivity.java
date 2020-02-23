package edu.temple.assignment4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    Spinner myspinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        color_init();
        spiiner_setup();
        adaptor_setup();
    }

    public int color_init() {
        Resources res = getResources();
        String[] myarr = res.getStringArray(R.array.mycolor);
        int size = myarr.length;
        return 1;
    }

    public int spiiner_setup() {
        myspinner = findViewById(R.id.my_spinner);
        return 1;
    }

    public int adaptor_setup() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.mycolor)) {
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView ItemView = (TextView) view;
                view.setId(position);

                switch (position){

                    case 1:
                        ItemView.setBackgroundColor(Color.parseColor("#0000ff"));
                        break;

                    case 2:
                        ItemView.setBackgroundColor(Color.parseColor("#6a0dad"));
                        break;

                    case 3:
                        ItemView.setBackgroundColor(Color.parseColor("#00ff00"));
                        break;

                    case 4:
                        ItemView.setBackgroundColor(Color.parseColor("#DE3163"));
                        break;

                    case 5:
                        ItemView.setBackgroundColor(Color.parseColor("#ff007f"));
                        break;

                    case 6:
                        ItemView.setBackgroundColor(Color.parseColor("#aaa9ad"));
                        break;

                    case 7:
                        ItemView.setBackgroundColor(Color.parseColor("#87ceeb"));
                        break;

                    case 8:
                        ItemView.setBackgroundColor(Color.parseColor("#d1e231"));
                        break;

                    case 9:
                        ItemView.setBackgroundColor(Color.parseColor("#ff0800"));
                        break;

                    case 10:
                        ItemView.setBackgroundColor(Color.parseColor("#007ba7"));
                        break;

                    case 11:
                        ItemView.setBackgroundColor(Color.parseColor("#ffe135"));
                        break;
                }

                return view;
            }
        };
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner.setAdapter(adapter);
        myspinner.setOnItemSelectedListener(this);


        return 0;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}