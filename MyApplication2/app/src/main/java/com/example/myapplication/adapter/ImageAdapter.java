package com.example.myapplication.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import com.example.myapplication.R;

public class ImageAdapter extends BaseAdapter {
    private Context context;
    private int[] Img = { R.drawable.evenement, R.drawable.livre,
            R.drawable.seminaire, R.drawable.soiree };

    public ImageAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return Img.length;
    }

    @Override
    public Object getItem(int position) {
        return Img[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView view = new ImageView(context);
        view.setImageResource(Img[position]);
        view.setLayoutParams(new Gallery.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        view.setScaleType(ImageView.ScaleType.FIT_XY);
        return view;
    }
}
