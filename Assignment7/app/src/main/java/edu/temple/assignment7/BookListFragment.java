package edu.temple.assignment7;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.lang.reflect.Array;
import java.util.Arrays;


public class BookListFragment extends Fragment {

    MyLibrary my_library;
    View view;

    public BookListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.portrait, container, false);
        this.my_library = new MyLibrary(getActivity());
        this.my_library.init();
        this.view = view;
        System.out.println("numbers are ：" + my_library.number_Book);
        list_view_adaptor();

        return view;
    }

    public void list_view_adaptor() {
        two_item_adaptor adaptor = new two_item_adaptor(getContext(), my_library);
        ListView book_list = (ListView) view.findViewById(R.id.portrait_xml_ListView);
        book_list.setAdapter(adaptor);

    }


}
