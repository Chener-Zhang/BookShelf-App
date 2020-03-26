package edu.temple.assignment7;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class booklist_fragment extends Fragment {


    private static String view_type;
    private View VIEW;
    public booklist_fragment() {
        // Required empty public constructor
    }


    public static booklist_fragment newInstance(String viewtype) {
        booklist_fragment fragment = new booklist_fragment();
        Bundle args = new Bundle();
        args.putString(view_type, viewtype);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        Bundle bundle = getArguments();
        if(bundle!=null){

            if(bundle.getString(view_type).equals("p")){
                VIEW = inflater.inflate(R.layout.book_list_fragment, container, false);

            }else if(bundle.getString(view_type).equals("l")){
                //doing something else for landscape;
                //VIEW
            }
        }
        return VIEW;
    }




}
