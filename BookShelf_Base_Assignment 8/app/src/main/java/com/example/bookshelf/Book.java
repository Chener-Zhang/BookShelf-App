package com.example.bookshelf;

public class Book {

    private int ID;
    private String TITLE;
    private String AUTHOR;
    private String COVER_URL;

    public Book(int id, String title, String author, String cover_url) {
        ID = id;
        TITLE = title;
        AUTHOR = author;
        COVER_URL = cover_url;
    }


    public int getID() {
        return ID;
    }

    public String getTITLE() {
        return TITLE;
    }

    public String getAUTHOR() {
        return AUTHOR;
    }

    public String getCOVER_URL() {
        return COVER_URL;
    }

    public String book_printer() {
        String id = "\n " + getID();
        String author = getAUTHOR() + "\n";
        String book_name = getTITLE()+ "\n";
        String uml = getCOVER_URL() + "\n";
        //System.out.println(id + author + book_name + uml + "\n----------------------\n");
        return id + author + book_name + uml + "\n----------------------\n";
    }
}


