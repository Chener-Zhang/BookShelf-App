package edu.temple.bookshelf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


    Map_Library library;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        library = new Map_Library(this);
        library.init();

        Book_Adaptor adaptor = new Book_Adaptor(this,library);
        ListView booklist = (ListView) findViewById(R.id.booklist);
        booklist.setAdapter(adaptor);


    }
}
