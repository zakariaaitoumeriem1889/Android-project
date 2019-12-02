package com.example.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.adapter.ImageAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Gallery gallery = (Gallery) this.findViewById(R.id.gallery);
        final ImageAdapter adapter = new ImageAdapter(this);
        gallery.setAdapter(adapter);
        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                navigateUpTo(position);
            }
        });
    }

    private void navigateUpTo(int position) {
        Intent intent = null;
        switch (position) {
            case 0:
                intent = new Intent(MainActivity.this, EventActivity.class);
                break;
            case 1:
                intent = new Intent(MainActivity.this, BookActivity.class);
                break;
            default:
                break;
        }
        startActivity(intent);
    }


}
