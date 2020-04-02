package com.example.bookshelf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements BookListFragment.BookSelectedInterface {


    BookDetailsFragment bookDetailsFragment;
    String url = "https://kamorris.com/lab/abp/booksearch.php?";
    FragmentManager fm;
    boolean twoPane;


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        twoPane = findViewById(R.id.container2) != null;

        getTestBooks_connection(new VolleyCallback() {
            ArrayList<Book> books_collections = new ArrayList<Book>();

            @Override
            public void get_data(JSONArray response) throws JSONException {
                System.out.println("you have reach here");
                int books_collection_length = response.length();
                fm = getSupportFragmentManager();
                System.out.println("rotated");


                for (int i = 0; i < books_collection_length; i++) {
                    int book_id = response.getJSONObject(i).getInt("book_id");
                    String book_title = response.getJSONObject(i).getString("title");
                    String book_author = response.getJSONObject(i).getString("author");
                    String book_cover_url = response.getJSONObject(i).getString("cover_url");
                    Book new_book = new Book(book_id, book_title, book_author, book_cover_url);
                    books_collections.add(new_book);
                }

                fm.beginTransaction().replace(R.id.container1, BookListFragment.newInstance(books_collections)).commit();

                if (twoPane) {
                    bookDetailsFragment = new BookDetailsFragment();
                    fm.beginTransaction().replace(R.id.container2, bookDetailsFragment).commit();
                }
            }


        });


    }


    private void getTestBooks_connection(final VolleyCallback callback) {

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                System.out.println("connection success");
                try {
                    callback.get_data(response);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("connection fail");
            }
        });
        requestQueue.add(jsonArrayRequest);

    }


    @Override
    public void bookSelected(int index, ArrayList<Book> books) {


        if (twoPane) {
            System.out.println("you have clicked on me on " + index);
            System.out.println(books.get(index).getAUTHOR());
            bookDetailsFragment.displayBook(books.get(index));
        } else {
            System.out.println("you have clicked on me on " + index);
            System.out.println(books.get(index).getAUTHOR());

            fm.beginTransaction().replace(R.id.container1, BookDetailsFragment.newInstance(books.get(index))).addToBackStack(null).commit();


        }
    }


}

interface VolleyCallback {
    void get_data(JSONArray response) throws JSONException;
}