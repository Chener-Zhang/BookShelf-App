package edu.temple.assignment4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
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
    String current_selection;
    String[] mylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        color_name_list();
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


    public void color_name_list() {
        String[] mylist = {"#0000ff", "#6a0dad", "#00ff00", "#DE3163", "#ff007f", "#aaa9ad", "#87ceeb", "#d1e231", "#ff0800", "#6a0dad", "#007ba7", "#ffe135"};
        this.mylist = mylist;
    }

    public int adaptor_setup() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.mycolor)) {
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView ItemView = (TextView) view;
                view.setId(position);

                for (int i = 0; i < mylist.length; i++) {
                    if (position == i) {
                        current_selection = mylist[i];
                        ItemView.setBackgroundColor(Color.parseColor(mylist[i]));
                    }
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
        String choosen = parent.getSelectedItem().toString();
        if (choosen.equals("Choose a Color")) {

        } else {
            Intent action = new Intent(this, Canvas.class);
            action.putExtra("color", choosen);
            action.putExtra("color_id", current_selection);
            startActivity(action);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}