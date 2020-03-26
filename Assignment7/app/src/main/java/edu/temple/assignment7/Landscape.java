package edu.temple.assignment7;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


/*
Landscape class
*/
public class Landscape extends Fragment {


    View view;
    Map_Library library;

    public Landscape() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.fragment_landscape, container, false);
        library = new Map_Library(getContext());
        library.init();
        landscape_adaptor();
        return view;

    }


    //Set the adaptor to the list, then to the right side of the view for the detail
    public void landscape_adaptor() {

        Book_Adaptor adaptor = new Book_Adaptor(getContext(), library);
        ListView mylist = view.findViewById(R.id.testlistview);
        mylist.setAdapter(adaptor);


        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            FragmentManager fragmentManager = getFragmentManager();
            Book_Detail_Fragment book_detail_fragment;

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String book = library.getSingleBook(position);
                String author = library.getSingleBookAuthor(book);
                System.out.println("author " + author + "book " + book);
                book_detail_fragment = Book_Detail_Fragment.newInstance(book, author);
                fragmentManager.beginTransaction().replace(R.id.book_detail_fragment_container, book_detail_fragment).commit();
            }
        });

    }

}
