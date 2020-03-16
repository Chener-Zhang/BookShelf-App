package edu.temple.assignment6;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.provider.FontRequest;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import java.util.HashMap;
import java.util.Map;


public class PaletteFragment extends Fragment implements AdapterView.OnItemSelectedListener {


    View MYVIEW;
    Spinner MY_SPINNER;

    String[] MYCOLORLIST;
    String[] MYCOLORLIST_HEX;

    Map MY_COLOR_MAP;
    int LENGTH_OF_COLOR;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_palette, container, false);
        MYVIEW = view;
        map_setup();
        setup_spinner_adaptor();
        MY_SPINNER.setOnItemSelectedListener(this);
        return view;
    }

    public void map_setup() {
        //Get the list
        MYCOLORLIST = getResources().getStringArray(R.array.color_list);
        MYCOLORLIST_HEX = getResources().getStringArray(R.array.color_hex);

        Map<String, String> Color_map = new HashMap<String, String>();

        int len = MYCOLORLIST.length;
        LENGTH_OF_COLOR = len;
        for (int i = 0; i < len; i++) {
            Color_map.put(MYCOLORLIST[i], MYCOLORLIST_HEX[i]);
        }
        MY_COLOR_MAP = Color_map;
    }


    public void setup_spinner_adaptor() {
        //get the spinner from the PaletteFtagment
        Spinner myspinner = (Spinner) MYVIEW.findViewById(R.id.palette_spinner);

        //Create a color_list import from Resourse color
        String[] color_list = getResources().getStringArray(R.array.color_list);

        //Making an adapter
        ArrayAdapter<String> ColorAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, color_list);

        //Connect the spinner with my adapter
        myspinner.setAdapter(ColorAdapter);
        MY_SPINNER = myspinner;
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String choosen = parent.getSelectedItem().toString();

        if (MY_COLOR_MAP.get(choosen) != null) {

            FragmentManager fragmentManager = getFragmentManager();
            CanvasFragment paletteFragment = CanvasFragment.newInstance(choosen, (String) MY_COLOR_MAP.get(choosen));
            fragmentManager.beginTransaction().replace(R.id.CanvasFragment,paletteFragment).commit();

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
