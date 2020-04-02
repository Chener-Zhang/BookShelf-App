package com.example.bookshelf;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;


public class BookListFragment extends Fragment {

    private static final String BOOK_LIST_KEY = "booklist";
    private ArrayList<Book> books;
    BookSelectedInterface parentActivity;
    Context main_context;



    public BookListFragment() {
    }

    public static BookListFragment newInstance(ArrayList<Book> books) {

        BookListFragment fragment = new BookListFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(BOOK_LIST_KEY, books);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof BookSelectedInterface) {
            parentActivity = (BookSelectedInterface) context;
        } else {
            throw new RuntimeException("Please implement the required interface(s)");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            books = (ArrayList) getArguments().getParcelableArrayList(BOOK_LIST_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ListView listView = (ListView) inflater.inflate(R.layout.fragment_book_list, container, false);


        final BooksAdapter adapter = new BooksAdapter(getContext(),books);
        listView.setAdapter(adapter);

        EditText search_bar = getActivity().findViewById(R.id.my_search_bar);



        search_bar.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                    adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });




        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                parentActivity.bookSelected(position, books);
            }
        });

        return listView;
    }


    interface BookSelectedInterface {
        void bookSelected(int index, ArrayList<Book> books);
    }
}
