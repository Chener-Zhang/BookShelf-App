package edu.temple.assignment6;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class PaletteFragment extends Fragment implements AdapterView.OnItemSelectedListener {


    View myview;
    Spinner My_Spinner;
    public PaletteFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_palette, container, false);
        myview = view;
        setup_spinner_adaptor();
        My_Spinner.setOnItemSelectedListener(this);

        return view;
    }



    public void setup_spinner_adaptor() {
        //get the spinner from the PaletteFtagment
        Spinner myspinner = (Spinner) myview.findViewById(R.id.palette_spinner);
        //Create a color_list import from Resourse color
        String[] color_list = getResources().getStringArray(R.array.color_list);

        //Making an adapter
        ArrayAdapter<String> ColorAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, color_list);

        //Connect the spinner with my adapter
        myspinner.setAdapter(ColorAdapter);
        My_Spinner = myspinner;

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String choosen = parent.getSelectedItem().toString();
        System.out.println(choosen);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
