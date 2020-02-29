package edu.temple.assignment5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class PaletteActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    Spinner myspinner;
    String[] mylist;
    String[] color_hex;
    String current_language = "english";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);

        get_color_hex();

        Button english_button = findViewById(R.id.English_language_buttom);
        english_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current_language = "english";
                init();
            }
        });

        Button spanish_button = findViewById(R.id.Spanish_language_buttom);
        spanish_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current_language = "spanish";
                init();
            }
        });


    }


    public void init() {

        color_name_list();
        System.out.println("name setup success");

        spinner_setup();
        System.out.println("spinner setup success");

        adaptor_setup();
        System.out.println("adaptor setup success");

    }


    public int spinner_setup() {
        myspinner = findViewById(R.id.my_spinner);
        return 1;
    }

    public void get_color_hex() {
        color_hex = getResources().getStringArray(R.array.color_in_hex);

    }

    public void color_name_list() {
        String[] mylist = color_hex;
        this.mylist = mylist;
    }

    public int adaptor_setup() {
        System.out.println("the current language is " + current_language);
        if (current_language.equals("spanish")) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.mycolor_in_spanish)) {
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
        } else {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.mycolor_in_english)) {
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
        }


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


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}