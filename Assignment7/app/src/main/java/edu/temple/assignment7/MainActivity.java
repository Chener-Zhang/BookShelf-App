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
        setContentView(R.layout.main_activitiy);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        BookListFragment bookListFragment = null;


        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            bookListFragment = BookListFragment.newInstance("p");

        } else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            bookListFragment = BookListFragment.newInstance("l");

        }

        fragmentTransaction.replace(android.R.id.content, bookListFragment);
        fragmentTransaction.commit();

    }


}
