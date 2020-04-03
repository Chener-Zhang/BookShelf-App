package com.example.bookshelf;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {

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


    protected Book(Parcel in) {
        ID = in.readInt();
        TITLE = in.readString();
        AUTHOR = in.readString();
        COVER_URL = in.readString();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ID);
        dest.writeString(TITLE);
        dest.writeString(AUTHOR);
        dest.writeString(COVER_URL);
    }
}


