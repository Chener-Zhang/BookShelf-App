package edu.temple.bookshelf;

import android.content.res.Resources;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;


public class BookListFragment extends Fragment {

    private static final String ARG_PARAM1 = "";
    private static final String ARG_PARAM2 = "";

    // TODO: Rename and change types of parameters
    private String book;
    private String author;

    public BookListFragment() {

    }


    // TODO: Rename and change types and number of parameters
    public static BookListFragment newInstance() {
        BookListFragment fragment = new BookListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            book = getArguments().getString(ARG_PARAM1);
            author = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_main, container, false);

        // init the library
        final Map_Library library = new Map_Library(getContext());
        Book_Adaptor adaptor = new Book_Adaptor(getContext(), library);

        //get the booklist in three different main_xml
        //set the custom adaptor to the booklist
        ListView booklist = view.findViewById(R.id.booklist);
        booklist.setAdapter(adaptor);
        //set the onclick listener
        booklist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                {
                    //get the resource
                    Resources res = getResources();

                    //check isPhone or not
                    boolean isPhone = res.getBoolean(R.bool.isPhone);

                    //get the library the book and author;
                    String current_book = library.getSingleBook(position);
                    String current_author = library.getSingleBookAuthor(current_book);


                    //init the fragment manager
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                    //init the Bookdetail_Fragment
                    BookDetailsFragment bookDetailsFragment = BookDetailsFragment.newInstance(current_book, current_author);

                    if (isPhone) {

                        if (res.getString(R.string.device).equals("portrait")) {
                            System.out.println("portrait");
                            fragmentTransaction.replace(android.R.id.content, bookDetailsFragment).addToBackStack(null);
                            fragmentTransaction.commit();

                        } else if (res.getString(R.string.device).equals("landscape")) {
                            System.out.println("landscape");
                            fragmentTransaction.replace(R.id.bookdetail, bookDetailsFragment).commit();
                        }

                    } else {
                        System.out.println("tablet");
                        fragmentTransaction.replace(R.id.bookdetail, bookDetailsFragment).commit();

                    }
                }
            }
        });

        return view;
    }
}
