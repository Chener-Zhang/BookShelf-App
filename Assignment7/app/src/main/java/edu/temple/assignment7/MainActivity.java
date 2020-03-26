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

        Portrait portrait = new Portrait();
        Landscape landscape = new Landscape();
        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            fragmentTransaction.replace(android.R.id.content, portrait);
        }

        else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            fragmentTransaction.replace(android.R.id.content,landscape );
        }


        fragmentTransaction.commit();
    }


}
