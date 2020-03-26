package edu.temple.assignment7;

import android.content.Context;
import android.content.res.Resources;

import java.util.HashMap;

public class MyLibrary {
    public int number_Book;
    public HashMap<String, String> library_map;
    Context context;


    //init Constructor
    public MyLibrary(Context main_content) {
        this.context = main_content;
        this.library_map = new HashMap();
    }

    //init the map
    public void init() {
        Resources res = context.getResources();
        int number_of_books = res.getStringArray(R.array.book_name).length;
        for (int i = 0; i < number_of_books; i++) {
            String book_name = res.getStringArray(R.array.book_name)[i];
            String book_author = res.getStringArray(R.array.book_author)[i];
            library_map.put(book_name, book_author);
        }
        getNumber_Book();
    }


    //print the library --> hash_map
    public void printLibrary() {
        System.out.println(library_map.toString());
    }

    //return the # of book
    public int getNumber_Book() {
        this.number_Book = library_map.size();
        return number_Book;
    }

    //return book title
    public String[] getALLBooktitle() {
        String[] books = new String[getNumber_Book()];
        for (int i = 0; i < number_Book; i++) {
            books[i] = context.getResources().getStringArray(R.array.book_name)[i];
        }
        return books;
    }
    public String[] getAllAuthors(){
        String[] authors = new String[getNumber_Book()];
        for (int i = 0; i < number_Book; i++) {
            String author = library_map.get(context.getResources().getStringArray(R.array.book_name)[i]);
            authors[i] = author;
        }
        return authors;
    }


    //return book author
    public String getSingleBookAuthor(String book_name) {
        return library_map.get(book_name);
    }

    public String getSingleBook(int index){
        int counter = 0;
        for(String book : getALLBooktitle()){
            if(index == counter){
                return book;
            }
            counter++;
        }
        return null;
    }


}
