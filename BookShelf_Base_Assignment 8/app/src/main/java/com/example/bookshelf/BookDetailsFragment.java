package com.example.bookshelf;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.Serializable;
import java.util.HashMap;


public class BookDetailsFragment extends Fragment {

    private static final String BOOK_KEY = "book";
    private Book book;

    TextView titleTextView, authorTextView;

    public BookDetailsFragment() {}

    public static BookDetailsFragment newInstance(Book book) {
        BookDetailsFragment fragment = new BookDetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable(BOOK_KEY, (Parcelable) book);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            book = (Book) getArguments().getParcelable(BOOK_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_book_details, container, false);

        titleTextView = v.findViewById(R.id.titleTextView);
        authorTextView = v.findViewById(R.id.authorTextView);

        /*
        Because this fragment can be created with or without
        a book to display when attached, we need to make sure
        we don't try to display a book if one isn't provided
         */
        if (book != null)
            displayBook(book);
        return v;
    }

    /*
    This method is used both internally and externally (from the activity)
    to display a book
     */
    public void displayBook(Book book) {
        titleTextView.setText(book.getTITLE());
        authorTextView.setText(book.getAUTHOR());
    }
}
