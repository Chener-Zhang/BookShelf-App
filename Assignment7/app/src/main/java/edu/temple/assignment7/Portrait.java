package edu.temple.assignment7;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Portrait extends Fragment {


    View view;
    MyLibrary library;

    public Portrait() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_portrait, container, false);
        library = new MyLibrary(getContext());
        library.init();
        portait_adaptor();
        return view;
    }


    public void portait_adaptor(){
        Book_Adaptor adaptor = new Book_Adaptor(getContext(),library);
        ListView mylist = view.findViewById(R.id.fragment_list_for_portrait);
        mylist.setAdapter(adaptor);



        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            FragmentManager fragmentManager = getFragmentManager();
            Book_Detail_Fragment book_detail_fragment = new Book_Detail_Fragment();
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String book = library.getSingleBook(position);
                String author = library.getSingleBookAuthor(book);
                System.out.println("author " + author + "book " + book);
                fragmentManager.beginTransaction().replace(getId(),book_detail_fragment).addToBackStack(null).commit();
            }
        });
        
    }





}
