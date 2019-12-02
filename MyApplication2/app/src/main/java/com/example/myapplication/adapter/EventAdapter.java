package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.model.Event;

import java.util.List;

public class EventAdapter extends BaseAdapter {
    private List<Event> events;
    private LayoutInflater inflater;

    public EventAdapter(Context context, List<Event> events) {
        this.events = events;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return events.size();
    }

    @Override
    public Object getItem(int position) {
        return events.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class EventDisplay {
        ImageView picture;
        TextView title;
        TextView location;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        EventDisplay display;
        if (convertView == null) {
            display = new EventDisplay();
            convertView = inflater.inflate(R.layout.event_item, null);
            display.title = (TextView) convertView.findViewById(R.id.event_title);
            display.location = (TextView) convertView.findViewById(R.id.event_place);
            display.picture = (ImageView) convertView.findViewById(R.id.event_picture);
            convertView.setTag(display);
        } else {
            display = (EventDisplay) convertView.getTag();
        }
        display.title.setText(events.get(position).getName());
        display.location.setText(events.get(position).getLocation());
        display.picture.setImageResource(events.get(position).getPicture());
        return convertView;
    }
}
