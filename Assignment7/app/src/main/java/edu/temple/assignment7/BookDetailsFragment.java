package edu.temple.assignment7;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class BookDetailsFragment extends Fragment {

    public static String BOOK = "book";
    public static String AUTHUR = "author";

    public BookDetailsFragment() {
        // Required empty public constructor
    }

    public static BookDetailsFragment newInstance(String book, String author) {
        BookDetailsFragment fragment = new BookDetailsFragment();
        Bundle args = new Bundle();
        args.putString(BOOK, book);
        args.putString(AUTHUR, author);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_book_details, container, false);
        Bundle bundle = getArguments();
        if (bundle != null) {

            String book_name = bundle.getString(BOOK);
            String author_name = bundle.getString(AUTHUR);

            TextView book_name_textview = view.findViewById(R.id.book_canvas);
            TextView author_name_textview = view.findViewById(R.id.author_canvas);

            book_name_textview.setText(book_name);
            author_name_textview.setText(author_name);
        }

        return view;
    }

}
