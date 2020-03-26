package edu.temple.assignment7;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;


public class BookListFragment extends Fragment {

    private static String view_type = "view_type";
    MyLibrary my_library;
    View view;

    public BookListFragment() {
        // Required empty public constructor
    }


    public static BookListFragment newInstance(String viewtype) {
        BookListFragment fragment = new BookListFragment();
        Bundle args = new Bundle();
        args.putString(view_type, viewtype);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        this.my_library = new MyLibrary(getActivity());
        this.my_library.init();
        Bundle bundle = getArguments();

        if (bundle != null) {
            String type = bundle.getString(view_type);
            System.out.println("you type of view is : " + type);

            if (type.equals("p")) {
                view = inflater.inflate(R.layout.portrait, container, false);
                this.view = view;
                list_view_adaptor_portrait();
            } else if (type.equals("l")) {
                view = inflater.inflate(R.layout.landscape, container, false);
                this.view = view;
            }

        }


        return this.view;
    }

    public void list_view_adaptor_portrait() {
        two_item_adaptor adaptor = new two_item_adaptor(getContext(), my_library);
        ListView book_list = view.findViewById(R.id.portrait_xml_ListView);
        book_list.setAdapter(adaptor);

    }


}
