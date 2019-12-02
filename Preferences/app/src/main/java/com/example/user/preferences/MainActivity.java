package com.example.user.preferences;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
   public static final String MY_PREFS = "fichierReferences";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      // SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("FAVORITE_COLOR", "vert");
        editor.commit();

       SharedPreferences prefs = this.getSharedPreferences(MY_PREFS,Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor2 = prefs.edit();
        editor2.putString("FAVORITE_COLOR", "Noir");
        editor2.commit();

        Button bouton = (Button)this.findViewById(R.id.test);
        bouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,PreferencesActivity.class);
                startActivity(i);
            }
        });

        Button bouton2 = (Button)this.findViewById(R.id.test2);
        bouton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(i);
            }
        });

    }
}
