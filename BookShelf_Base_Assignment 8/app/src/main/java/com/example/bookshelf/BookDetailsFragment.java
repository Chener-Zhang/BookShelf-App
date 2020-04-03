package com.example.bookshelf;

import android.os.Bundle;

import androidx.annotation.NonNull;
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
    private static final String SAVE_BOOK = "save_book";
    TextView titleTextView, authorTextView;

    public BookDetailsFragment() {
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(SAVE_BOOK, this.book);
    }

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
        if (savedInstanceState != null) {
            if (savedInstanceState.getParcelable(SAVE_BOOK) != null) {
                book = savedInstanceState.getParcelable(SAVE_BOOK);
                System.out.println("the pass value is book : " + book.getAUTHOR());
            } else {
                //do nothing
            }
        } else if (getArguments() != null) {

            book = (Book) getArguments().getParcelable(BOOK_KEY);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_book_details, container, false);

        titleTextView = v.findViewById(R.id.titleTextView);
        authorTextView = v.findViewById(R.id.authorTextView);

        if (book != null)
            displayBook(book);
        return v;
    }


    public void displayBook(Book book) {
        titleTextView.setText(book.getTITLE());
        authorTextView.setText(book.getAUTHOR());
    }
}
