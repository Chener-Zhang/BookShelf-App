package com.example.bookshelf;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BookDetailsFragment extends Fragment {

    private static final String BOOK_KEY = "book";
    private Book book;

    TextView titleTextView, authorTextView;
    ImageView imageView;

    public BookDetailsFragment() {
    }



    public static BookDetailsFragment newInstance(Book book) {
        BookDetailsFragment fragment = new BookDetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable(BOOK_KEY, (Parcelable) book);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            book = (Book) getArguments().getParcelable(BOOK_KEY);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_book_details, container, false);

        titleTextView = v.findViewById(R.id.titleTextView);
        authorTextView = v.findViewById(R.id.authorTextView);
        imageView = v.findViewById(R.id.my_image);

        if (book != null) {
            displayBook(book);
        }
        return v;
    }


    public void displayBook(Book book) {
        titleTextView.setText(book.getTITLE());
        authorTextView.setText(book.getAUTHOR());
        GET_IMG img = new GET_IMG(imageView);
        img.execute(book.getCOVER_URL());
    }


    private class GET_IMG extends AsyncTask<String, Void, Bitmap> {
        ImageView imageView;

        public GET_IMG(ImageView img) {
            this.imageView = img;
        }


        @Override
        protected Bitmap doInBackground(String... strings) {
            String link = strings[0];
            Bitmap map = null;
            try {
                InputStream inputStream = new java.net.URL(link).openStream();
                map = BitmapFactory.decodeStream(inputStream);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return map;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            imageView.setImageBitmap(bitmap);
        }
    }
}
