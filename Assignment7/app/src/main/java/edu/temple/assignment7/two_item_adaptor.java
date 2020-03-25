package edu.temple.assignment7;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


public class two_item_adaptor extends BaseAdapter {
    //Constructor
    private Context context;
    private MyLibrary hashMap;

    public two_item_adaptor(Context context, MyLibrary hashMap) {
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

        View view = View.inflate(context,R.layout.fragment_book_list_row,null);
        TextView book_name = (TextView) view.findViewById(R.id.book_name);
        TextView author_name = (TextView) view.findViewById(R.id.author_name);
        String BOOK_NAME = (String) getItem(position);
        String AUTHOR_NAME = hashMap.getSingleBookAuthor(BOOK_NAME);
        book_name.setText(BOOK_NAME);
        author_name.setText(AUTHOR_NAME);

        return view;
    }
}
