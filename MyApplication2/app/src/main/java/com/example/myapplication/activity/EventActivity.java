package com.example.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.adapter.EventAdapter;
import com.example.myapplication.model.Event;

import java.util.ArrayList;
import java.util.List;

public class EventActivity extends AppCompatActivity {
    ListView event_list;
    List<Event> events = new ArrayList<Event>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_activity);
        event_list = (ListView) findViewById(R.id.eventlist);
        fill_agenda();
        EventAdapter adapter = new EventAdapter(this, events);
        event_list.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        event_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(EventActivity.this, EventDetailActivity.class);
                intent.putParcelableArrayListExtra("event", (ArrayList<Event>) events);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
    }

    private void fill_agenda() {
        events.clear();
        events.add(new Event("Visite d'un centre d'orphelin",
                "IGA Marrakech", "Parascolaire",
                "25 Novembre 2019", 100,
                "Unknown", "0658746987",
                "Visite d'un centre d'orphelin",
                R.drawable.humanitaire));
        events.add(new Event("Journée Recrutement",
                "IGA Marrakech", "Emploi",
                "Le vendredi et la samedi 30 et 31 mai 2014",
                0, "Mlle Meriem",
                "066472673", "La journée de recrutement",
                R.drawable.recrutement));
    }
}
