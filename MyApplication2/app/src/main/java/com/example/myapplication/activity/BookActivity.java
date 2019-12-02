package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.myapplication.R;
import com.example.myapplication.adapter.BookAdapter;
import com.example.myapplication.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookActivity extends AppCompatActivity {
    ListView book_item;
    List<Book> library = new ArrayList<Book>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_activity);
        book_item = (ListView) this.findViewById(R.id.listbook);
        fill_library();
        BookAdapter adapter = new BookAdapter(this, library);
        book_item.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void fill_library() {
        library.clear();
        library.add(new Book("Starcraft 2 : Les diables du ciel", "William-C Dietz"));
        library.add(new Book("L\'art du développment Android", "Mark Murphy"));
        library.add(new Book("Le sueil des ténèbres", "Karen Chance"));
        library.add(new Book("WPF par la pratique", "Thomas Lebrun"));
        library.add(new Book("La main de Léonard De Vinci", "Dominique Le men"));
        library.add(new Book("Topographie du corps", "Andrew Biel"));
        library.add(new Book("Le langage universel du corps", "Philippe Turchet"));
        library.add(new Book("Apprendre SQL avec MySQL", "Christian Soutou"));
    }
}
