package edu.temple.assignment7;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.portrait);
        // you need the check the case here;

        //test
        testing();

    }


    public void testing() {
        MyLibrary lib = new MyLibrary(this);
    }
}
