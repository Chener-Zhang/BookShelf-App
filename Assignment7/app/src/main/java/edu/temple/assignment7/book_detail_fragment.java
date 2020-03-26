package edu.temple.assignment7;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class book_detail_fragment extends Fragment {



    private static String name = "book_name";
    private static String author = " book_author";
    public book_detail_fragment() {

    }

    public static book_detail_fragment newInstance(String bookname, String bookauthor) {
        book_detail_fragment myFragment = new book_detail_fragment();
        Bundle args = new Bundle();
        args.putString(name, bookname);
        args.putString(author, bookauthor);

        myFragment.setArguments(args);
        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.book_detail_fragment, container, false);
    }
}
