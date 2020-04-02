package com.example.bookshelf;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class BooksAdapter extends BaseAdapter implements Filterable {

    Context context;
    ArrayList<Book> books;
    ArrayList<Book> book_list;
    customize_filter filter;


    public BooksAdapter(Context context, ArrayList books) {
        this.context = context;
        this.books = books;
        book_list = books;
    }


    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Object getItem(int position) {
        return books.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView titleTextView, authorTextView;

        if (!(convertView instanceof LinearLayout)) {
            convertView = LayoutInflater.from(context).inflate(R.layout.books_adapter_layout, parent, false);
        }

        titleTextView = convertView.findViewById(R.id.titleTextView);
        authorTextView = convertView.findViewById(R.id.authorTextView);

        String title = books.get(position).getTITLE();
        String author = books.get(position).getAUTHOR();

        titleTextView.setText(title);
        authorTextView.setText(author);


        return convertView;
    }

    @Override
    public Filter getFilter() {
        if(filter == null){
            filter = new customize_filter();
        }
        return filter;
    }

    //inner class
    class customize_filter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
                return null;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
                notifyDataSetChanged();
        }
    }


}
