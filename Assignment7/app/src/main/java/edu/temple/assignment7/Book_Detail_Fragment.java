package edu.temple.assignment7;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/*
* This class pass the data from the my library map to the Textview;
*/
public class Book_Detail_Fragment extends Fragment {


    private static String book_name = "book_name";
    private static String book_author = " book_author";
    private View view;


    public Book_Detail_Fragment() {
    }

    public static Book_Detail_Fragment newInstance(String bookname, String bookauthor) {
        Book_Detail_Fragment myFragment = new Book_Detail_Fragment();
        Bundle args = new Bundle();
        args.putString(book_name, bookname);
        args.putString(book_author, bookauthor);
        myFragment.setArguments(args);
        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.book_detail_both, container, false);
        Bundle bundle = getArguments();
        context_setup(bundle.getString(book_name), bundle.getString(book_author));
        return view;
    }

    public void context_setup(String book, String author) {
        TextView bookname_view = view.findViewById(R.id.book_name);
        TextView author_view = view.findViewById(R.id.author_name);
        bookname_view.setText(book);
        author_view.setText(author);
    }

}
