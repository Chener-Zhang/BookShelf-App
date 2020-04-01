package com.example.bookshelf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements BookListFragment.BookSelectedInterface {

    FragmentManager fm;

    boolean twoPane;
    BookDetailsFragment bookDetailsFragment;
    String url = "https://kamorris.com/lab/abp/booksearch.php?";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        twoPane = findViewById(R.id.container2) != null;

        fm = getSupportFragmentManager();

        getTestBooks();


        /*
        fm.beginTransaction()
                .replace(R.id.container1, BookListFragment.newInstance(getTestBooks()))
                .commit();

        if (twoPane) {
            bookDetailsFragment = new BookDetailsFragment();
            fm.beginTransaction()
                    .replace(R.id.container2, bookDetailsFragment)
                    .commit();
        }
        */


    }

    private ArrayList<Book> getTestBooks() {
        final ArrayList<Book> books_collection = new ArrayList<Book>();
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                System.out.println("connection success");

                try {
                    int json_arr_size = response.length();
                    System.out.println("the length is " + json_arr_size);
                    for (int i = 0; i < json_arr_size; i++) {
                        JSONObject jsonObject = response.getJSONObject(i);

                        int book_id = jsonObject.getInt("book_id");
                        String title = jsonObject.getString("title");
                        String author = jsonObject.getString("author");
                        String cover_url = jsonObject.getString("cover_url");
                        Book newbook = new Book(book_id,title,author,cover_url);
                        books_collection.add(newbook);
                        

                    }

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


        return books_collection;
    }


    @Override
    public void bookSelected(int index) {

        /*
        if (twoPane)
            bookDetailsFragment.displayBook(getTestBooks().get(index));

        else {

            fm.beginTransaction()
                    .replace(R.id.container1, BookDetailsFragment.newInstance(getTestBooks().get(index)))
                    .addToBackStack(null)
                    .commit();
        }
*/

    }



}
