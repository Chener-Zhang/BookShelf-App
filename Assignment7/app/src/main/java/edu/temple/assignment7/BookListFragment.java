package edu.temple.assignment7;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;



public class BookListFragment extends Fragment {

    MyLibrary my_library;
    View view;
    public BookListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        System.out.println("get here");
        View view = inflater.inflate(R.layout.fragment_book_list, container, false);

        //init lib
        my_library = new MyLibrary(getActivity());
        my_library.init();
        //finished init lib
        this.view = view;
        list_view_adaptor();
        return view;
    }

    public void list_view_adaptor() {
        ListView book_list_view = this.view.findViewById(R.id.booklist_fragment);

    }



}
