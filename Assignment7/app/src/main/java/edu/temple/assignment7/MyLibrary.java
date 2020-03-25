package edu.temple.assignment7;

import android.content.Context;

import java.util.HashMap;

public class MyLibrary {
    public int number_Book;
    public HashMap<String, String> library_map;
    Context context;



    //init
    public MyLibrary(Context main_content) {
        this.context = main_content;
        this.library_map = new HashMap();
    }

    //init the map
    public void init() {
        int number_of_books = context.getResources().getStringArray(R.array.book_name).length;

    }
    //return the # of book
    public int getNumber_Book() {
        return 0;
    }

    //return book title
    public String getBooktitle() {
        return null;
    }


    //return book author
    public String getBookAuthor() {
        return null;
    }

    // add book
    public void addbook() {

    }

    //delete the book
    public void rmbook() {

    }




}
