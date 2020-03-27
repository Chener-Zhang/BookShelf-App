package edu.temple.bookshelf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


    Map_Library library;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        library = new Map_Library(this);
        library.init();

        Book_Adaptor adaptor = new Book_Adaptor(this, library);
        final ListView booklist = (ListView) findViewById(R.id.booklist);
        booklist.setAdapter(adaptor);


        final int current_orient = this.getResources().getConfiguration().orientation;

        booklist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                {
                    //check if it is phone or the tablet
                    Resources res = getResources();
                    boolean isPhone = res.getBoolean(R.bool.isPhone);

                    String current_book = library.getSingleBook(position);
                    String current_author = library.getSingleBookAuthor(current_book);

                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                    BookDetailsFragment bookDetailsFragment = BookDetailsFragment.newInstance(current_book, current_author);

                    System.out.println(res.getString(R.string.device));

                    if (isPhone) {
                        if (res.getString(R.string.device).equals("portrait")) {
                            fragmentTransaction.add(android.R.id.content, bookDetailsFragment).addToBackStack(null).commit();
                            
                        } else if (res.getString(R.string.device).equals("landscape"))
                        {
                            fragmentTransaction.replace(R.id.bookdetail, bookDetailsFragment).commit();
                        }

                    } else {
                        fragmentTransaction.replace(R.id.bookdetail, bookDetailsFragment).commit();

                    }
                }
            }
        });


    }
}
