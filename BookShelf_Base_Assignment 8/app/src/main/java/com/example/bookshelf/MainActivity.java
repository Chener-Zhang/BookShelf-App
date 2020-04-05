package com.example.bookshelf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
    Context context = this;
    RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        twoPane = findViewById(R.id.container2) != null;
        get_data(new VolleyCallback() {
            @Override
            public void onSuccess(ArrayList<Book> books_collection) throws JSONException {

                twoPane = findViewById(R.id.container2) != null;

                fm = getSupportFragmentManager();

                fm.beginTransaction().replace(R.id.container1, BookListFragment.newInstance(books_collection)).commit();
                if (twoPane) {
                    bookDetailsFragment = new BookDetailsFragment();
                    fm.beginTransaction().replace(R.id.container2, bookDetailsFragment).commit();
                }

            }
        });


    }

    public void research(final URLCallBack urlCallBack){
        Button button = findViewById(R.id.search_button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = findViewById(R.id.my_search_bar);
                String user_input = editText.getText().toString();
                String url_new = url+user_input;

                try {
                    urlCallBack.get_url(context,url_new);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    private void get_data(final VolleyCallback callback) {

        research(new URLCallBack() {

            @Override
            public void get_url(Context context, String url_string) throws JSONException {


                System.out.println(url_string);
                requestQueue = Volley.newRequestQueue(context);
                JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url_string, new Response.Listener<JSONArray>() {
                    ArrayList<Book> books_collections = new ArrayList<Book>();
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
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        try {
                            callback.onSuccess(books_collections);
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
        });



    }


    @Override
    public void bookSelected(int index, ArrayList<Book> books) {

        if (twoPane) {
            
            bookDetailsFragment.displayBook(books.get(index));
        } else {

            fm.beginTransaction().replace(R.id.container1,BookDetailsFragment.newInstance(books.get(index))).addToBackStack(null).commit();


        }
    }


}

interface VolleyCallback {
    void onSuccess(ArrayList<Book> books_collection) throws JSONException;
}

interface URLCallBack {
    void get_url(Context context, String url_string) throws JSONException;
}