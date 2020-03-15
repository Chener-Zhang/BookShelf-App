package edu.temple.assignment6;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;
import java.util.Map;


public class CanvasFragment extends Fragment {

    private String[] MYCOLORLIST;
    private String[] MYCOLORLIST_HEX;
    private int LENGTH_OF_COLOR;
    private Map MY_COLOR_MAP;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_palette, container, false);
        //map_setup();

        return view;
    }


    public void map_setup(){
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
}
