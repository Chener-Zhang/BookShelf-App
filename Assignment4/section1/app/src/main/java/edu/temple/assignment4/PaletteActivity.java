package edu.temple.assignment4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class PaletteActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    Spinner myspinner;
    String[] mylist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        color_name_list();
        spinner_setup();
        adaptor_setup();
    }


    public int spinner_setup() {
        myspinner = findViewById(R.id.my_spinner);
        return 1;
    }


    public void color_name_list() {
        String[] mylist = {"#ffffff", "#0000FF", "#FFFF00", "#008000", "#FF0000", "#FFFFF0", "#FFA07A", "#FF6347", "#FF8C00", "#FF7F50", "#FF69B4"};
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

        for (int i = 0; i < parent.getCount(); i++) {
            if (parent.getItemAtPosition(i).equals("Choose a Color")) {

            } else if (parent.getItemAtPosition(i).equals(choosen)) {

                System.out.println("mycolor choosen : " + choosen);
                System.out.println("mycolor position: " + parent.getItemAtPosition(i));
                System.out.println("color_index" + i);

                Intent action = new Intent(this, CanvasActivitiy.class);
                action.putExtra("color_index", i);
                action.putExtra("color", choosen);
                action.putExtra("list", mylist);
                startActivity(action);

            }
        }
        /*
        if (choosen.equals("Choose a Color")) {

        } else {
            Intent action = new Intent(this, CanvasActivitiy.class);
            action.putExtra("color", choosen);

            startActivity(action);
        }*/

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}