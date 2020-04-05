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
    Context context = this;
    RequestQueue requestQueue;

    final String url_passing_key = "url_key";
    final String collection_passing_key = "collection_key";
    public String global_url = "https://kamorris.com/lab/abp/booksearch.php?search=";
    public ArrayList<Book> global_books_collection = new ArrayList<>();


    @Override
    protected void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(url_passing_key, global_url);
        outState.putParcelableArrayList(collection_passing_key, global_books_collection);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        create_list();
        System.out.println("the size " + global_books_collection.size());


        twoPane = findViewById(R.id.container2) != null;
        fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.container1, BookListFragment.newInstance(global_books_collection)).commit();


        if (twoPane) {
            bookDetailsFragment = new BookDetailsFragment();
            fm.beginTransaction().replace(R.id.container2, bookDetailsFragment).commit();
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

                PASS_COLLECTION pass_collection = new PASS_COLLECTION(global_books_collection);
                pass_collection.execute();


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

    public class PASS_COLLECTION extends AsyncTask<ArrayList<Book>, ArrayList<Book>, ArrayList<Book>> {
        ArrayList<Book> current_collection;

        public PASS_COLLECTION(ArrayList<Book> collectin_data) {
            current_collection = collectin_data;
        }

        @Override
        protected ArrayList<Book> doInBackground(ArrayList<Book>... arrayLists) {
            global_books_collection = (ArrayList<Book>) current_collection.clone();
            return null;

        }
    }
}

