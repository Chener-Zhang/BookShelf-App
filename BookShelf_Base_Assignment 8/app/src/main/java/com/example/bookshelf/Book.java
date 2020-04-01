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

    public String book_printer(){
        return null;
    }
}


