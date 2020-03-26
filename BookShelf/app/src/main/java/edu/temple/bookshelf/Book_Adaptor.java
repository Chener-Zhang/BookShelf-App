package edu.temple.bookshelf;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/*
* his adapter is to connect the book and author name into single row of the list;
*/

public class Book_Adaptor extends BaseAdapter {


    private Context context;
    private Map_Library hashMap;

    public Book_Adaptor(Context context, Map_Library hashMap) {
        this.context = context;
        this.hashMap = hashMap;
    }

    @Override
    public int getCount() {
        return hashMap.number_Book;
    }

    @Override
    public Object getItem(int position) {
        return hashMap.getSingleBook(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = View.inflate(context, R.layout.fragment_book_list, null);

        TextView book_name = (TextView) view.findViewById(R.id.book);
        TextView author_name = (TextView) view.findViewById(R.id.author);

        String BOOK_NAME = (String) getItem(position);
        String AUTHOR_NAME = hashMap.getSingleBookAuthor(BOOK_NAME);

        book_name.setText(BOOK_NAME);
        author_name.setText(AUTHOR_NAME);

        return view;
    }
}
