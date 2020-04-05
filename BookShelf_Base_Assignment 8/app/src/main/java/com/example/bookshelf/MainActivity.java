package com.example.bookshelf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
    final String url = "https://kamorris.com/lab/abp/booksearch.php?search=";
    FragmentManager fm;
    boolean twoPane;
    RequestQueue requestQueue;

    final String url_passing_key = "url_key";
    public String global_url = "https://kamorris.com/lab/abp/booksearch.php?search=";


    boolean saved = false;
    String saved_boolean = "saved";

    @Override
    protected void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);
        saved = true;
        outState.putBoolean(saved_boolean, saved);
        outState.putString(url_passing_key, global_url);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (savedInstanceState != null) {
            global_url = savedInstanceState.getString(url_passing_key);
            saved = savedInstanceState.getBoolean(saved_boolean);
            create_list();
            set_onclick();
        } else {
            set_onclick();

        }


    }


    public boolean create_list() {
        requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(global_url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                System.out.println("connection success");
                int books_collection_length = response.length();
                ArrayList<Book> books_collections = new ArrayList<Book>();
                for (int i = 0; i < books_collection_length; i++) {
                    try {
                        int book_id = response.getJSONObject(i).getInt("book_id");
                        String book_title = response.getJSONObject(i).getString("title");
                        String book_author = response.getJSONObject(i).getString("author");
                        String book_cover_url = response.getJSONObject(i).getString("cover_url");
                        Book new_book = new Book(book_id, book_title, book_author, book_cover_url);
                        books_collections.add(new_book);
                        System.out.println(new_book.book_printer());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }


                twoPane = findViewById(R.id.container2) != null;
                fm = getSupportFragmentManager();


                fm.beginTransaction().replace(R.id.container1, BookListFragment.newInstance(books_collections)).commit();


                if (twoPane) {
                    bookDetailsFragment = new BookDetailsFragment();
                    fm.beginTransaction().replace(R.id.container2, bookDetailsFragment).commit();
                    
                }


            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("connection fail");
            }
        });

        requestQueue.add(jsonArrayRequest);
        return true;
    }


    private void set_onclick() {

        Button button = findViewById(R.id.search_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("you click it");
                EditText mytext = findViewById(R.id.my_search_bar);
                String user_input = mytext.getText().toString();
                if (user_input.length() > 0) {
                    global_url = url + user_input;
                    PASS_URL_DATA pass_data = new PASS_URL_DATA(global_url);
                    pass_data.execute();
                    create_list();
                } else {
                    PASS_URL_DATA pass_data = new PASS_URL_DATA(url);
                    pass_data.execute();
                    create_list();
                }
            }
        });

    }


    @Override
    public void bookSelected(int index, ArrayList<Book> books) {

        if (twoPane) {
            bookDetailsFragment.displayBook(books.get(index));
        } else {
            fm.beginTransaction().replace(R.id.container1, BookDetailsFragment.newInstance(books.get(index))).addToBackStack(null).commit();

        }
    }

    public class PASS_URL_DATA extends AsyncTask<String, String, String> {
        String current_data;

        public PASS_URL_DATA(String url_data) {
            current_data = url_data;

        }

        @Override
        protected String doInBackground(String... strings) {
            global_url = current_data;
            return null;
        }
    }


}

