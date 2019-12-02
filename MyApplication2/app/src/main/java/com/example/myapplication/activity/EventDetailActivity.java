package com.example.myapplication.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.interfaces.menu;
import com.example.myapplication.interfaces.string;
import com.example.myapplication.model.Event;

import java.util.List;

public class EventDetailActivity extends AppCompatActivity {
    String name, location, type, period, contactName, contactPhone, description;
    double price;
    int picture;
    TextView ename, elocation1, elocation2, etype, eperiod, econtactName, econtactPhone,
            edescription, eprice;
    List<Event> events;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_detail);
        ename = findViewById(R.id.event);
        elocation1 = findViewById(R.id.event_location_1);
        elocation2 = findViewById(R.id.event_location_2);
        etype = findViewById(R.id.type_event);
        eperiod = findViewById(R.id.event_period);
        eprice = findViewById(R.id.event_price);
        econtactName = findViewById(R.id.event_contact);
        econtactPhone = findViewById(R.id.event_tel);
        edescription = findViewById(R.id.description_event);
        
        Bundle bundle = getIntent().getExtras();
        position = bundle.getInt("position");
        data(position);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case menu.previous:
                int prev;
                if (position <= events.size())
                    prev = position;
                else prev = position - 1;
                data(prev);
                return true;
            case menu.share:
                Uri imageUri =
                        Uri.parse("android.resource://com.example.myapplication/drawable/"
                                + picture);
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("image/*");
                String text = description + "\n" + period + "\n" + price + " DH";
                shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, name);
                shareIntent.putExtra(Intent.EXTRA_TITLE, name);
                shareIntent.putExtra(Intent.EXTRA_TEXT, text);
                startActivity(Intent.createChooser(shareIntent, getResources()
                        .getString(string.share)));
                return true;
            case menu.next:
                int next;
                if (position >= events.size())
                    next = position;
                else next = position + 1;
                data(next);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void data(int position) {
        Bundle bundle = getIntent().getExtras();
        events = bundle.getParcelableArrayList("event");

        name = events.get(position).getName();
        location = events.get(position).getLocation();
        type = events.get(position).getType();
        period = events.get(position).getPeriod();
        contactName = events.get(position).getContactName();
        contactPhone = events.get(position).getContactPhone();
        description = events.get(position).getDescription();
        price = events.get(position).getPrice();
        picture = events.get(position).getPicture();

        ename.setText(name);
        elocation1.setText(location);
        elocation2.setText(location);
        etype.setText(type);
        eperiod.setText(period);
        eprice.setText(price + " DH");
        econtactName.setText(contactName);
        econtactPhone.setText(contactPhone);
        edescription.setText(description);
    }
}
