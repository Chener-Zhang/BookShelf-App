package edu.temple.assignment7;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        book_list_fragment fragment = null;


        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            fragment = book_list_fragment.newInstance("p");
        }

        else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            //book_list_fragment
        }

        fragmentTransaction.replace(android.R.id.content, fragment);
        fragmentTransaction.commit();
    }


}
