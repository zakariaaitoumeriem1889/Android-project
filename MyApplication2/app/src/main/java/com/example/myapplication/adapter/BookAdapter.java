package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.model.Book;

import java.util.List;

public class BookAdapter extends BaseAdapter {
    private List<Book> books;
    private LayoutInflater inflater;

    public BookAdapter(Context context, List<Book> books) {
        this.books = books;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Object getItem(int position) {
        return books.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ItemDisplay {
        TextView title;
        TextView author;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemDisplay display;
        if (convertView == null) {
            display = new ItemDisplay();
            convertView = inflater.inflate(R.layout.book_item, null);
            display.title = (TextView) convertView.findViewById(R.id.title_book);
            display.author = (TextView) convertView.findViewById(R.id.author_book);
            convertView.setTag(display);
        } else {
            display = (ItemDisplay) convertView.getTag();
        }
        display.title.setText(books.get(position).getTitle());
        display.author.setText(books.get(position).getAuthor());
        return convertView;
    }
}
