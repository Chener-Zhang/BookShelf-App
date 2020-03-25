package edu.temple.assignment7;

import android.content.Context;
import android.content.res.Resources;

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
        Resources res = context.getResources();
        int number_of_books = res.getStringArray(R.array.book_name).length;
        System.out.println("the numbers of the book are: " + number_of_books);
        for (int i = 0; i < number_of_books; i++) {
            String book_name = res.getStringArray(R.array.book_name)[i];
            String book_author = res.getStringArray(R.array.book_author)[i];
            library_map.put(book_name, book_author);
        }
    }


    //print the library --> hash_map
    public void printLibrary() {
        System.out.println(library_map.toString());
    }

    //return the # of book
    public int getNumber_Book() {
        return library_map.size();
    }

    //return book title
    public String getBooktitle() {
        return null;
    }

    //return book author
    public String getBookAuthor(String book_name) {
        return library_map.get(book_name);
    }


    /*
    public void addbook() {}
    public void rmbook() {}
    */


}
