package edu.temple.assignment7;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


public class book_list_fragment extends Fragment {


    private static String view_type;
    private View VIEW;
    public book_list_fragment() {
        // Required empty public constructor
    }


    public static book_list_fragment newInstance(String viewtype) {
        book_list_fragment fragment = new book_list_fragment();
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

    public void portait_adaptor(){
        MyLibrary library = new MyLibrary(getContext());
        Book_Adaptor adaptor = new Book_Adaptor(getContext(),library);

    }





}
